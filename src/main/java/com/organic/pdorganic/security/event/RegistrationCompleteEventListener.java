package com.organic.pdorganic.security.event;

import com.organic.pdorganic.security.UserServicesForSecurityImplementation;
import com.organic.pdorganic.security.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Autowired
    private UserServicesForSecurityImplementation userServicesForSecurityImplementation;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //token created for particular user
        User user = event.getUser();
        log.info("User in onApplicationEvent : "+user);
        String token = UUID.randomUUID().toString();
        userServicesForSecurityImplementation.saveVerificationTokenForUser(token,user);

        String url = event.getApplicationUrl() + "/verifyRegistration?token="+token;
        log.info("Click link to verify your account : "+url);
    }
}
