package com.organic.pdorganic.security;

import com.organic.pdorganic.security.entity.User;

public interface UserServicesForSecurity {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerficationToken(String token);
}
