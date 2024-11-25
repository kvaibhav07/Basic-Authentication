package com.authentication.Basic.Authentication.controller;

import com.authentication.Basic.Authentication.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AppConfig appConfig;

    @Autowired
    public AuthController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/basic-auth")
    public String authenticate(@RequestHeader("Authorization") String authHeader) {
        // Decode Basic Auth Header
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
}
