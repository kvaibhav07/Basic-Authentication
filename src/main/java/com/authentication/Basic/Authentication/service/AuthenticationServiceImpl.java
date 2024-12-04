package com.authentication.Basic.Authentication.service;

import com.authentication.Basic.Authentication.config.AppConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Base64;

@Component
public class AuthenticationServiceImpl implements AuthenticationService{

    @Value("${app.auth.skip.flag}")
    private String authSkipFlag;

    private final AppConfig appConfig;

    public AuthenticationServiceImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public String verifyAuthentication(String authHeader) {
        if(StringUtils.hasText(authSkipFlag) && "ON".equalsIgnoreCase(authSkipFlag) && StringUtils.hasText(authHeader)){
            String base64Credentials = authHeader.substring("Basic ".length());
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            String[] values = credentials.split(":", 2);

            String username = values[0];
            String password = values[1];

            // Validate credentials
            if (appConfig.getUsername().equals(username) && appConfig.getPassword().equals(password)) {
                return "Authentication Successful!";
            } else {
                return "Authentication Failed!";
            }
        }
        return "Auth flag is not enable and value is : "+authSkipFlag;
    }
}
