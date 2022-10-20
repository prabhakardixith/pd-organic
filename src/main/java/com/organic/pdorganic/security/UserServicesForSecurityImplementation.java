package com.organic.pdorganic.security;

import com.organic.pdorganic.security.entity.User;
import com.organic.pdorganic.security.entity.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserServicesForSecurityImplementation implements UserServicesForSecurity{


    @Autowired
    VerificationTokenRepo verificationTokenRepo;
    @Autowired
    UserRepositoryForSecurity userRepositoryForSecurity;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepositoryForSecurity.save(user);

        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken newVerificationToken = new VerificationToken(user,token);
        verificationTokenRepo.save(newVerificationToken);
    }

    @Override
    public String validateVerficationToken(String token) {
        VerificationToken verificationToken = verificationTokenRepo.findByToken(token);
        if (verificationToken == null){
            return "invalid";
        }
        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if (verificationToken.getExpirationTime().getTime() - cal.getTime().getTime() <= 0){
            verificationTokenRepo.delete(verificationToken);
            return "Expired";
        }
        user.setEnabled(true);
        userRepositoryForSecurity.save(user);
        return "Valid";
    }
}
