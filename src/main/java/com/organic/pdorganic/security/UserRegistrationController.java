package com.organic.pdorganic.security;

import com.organic.pdorganic.security.entity.User;
import com.organic.pdorganic.security.event.RegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRegistrationController {

    @Autowired
    UserServicesForSecurityImplementation userServicesForSecurity;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
        User user = userServicesForSecurity.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
        return "Success";
    }

    public String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
        String result  = userServicesForSecurity.validateVerficationToken(token);
        if(result.equalsIgnoreCase("valid")){
            return "User verfies Succesfully";
        }
        return "Bad User";
    }

}
