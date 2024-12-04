package com.authentication.Basic.Authentication.controller;

import com.authentication.Basic.Authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/basic-auth")
    public String authenticate(@RequestHeader("Authorization") String authHeader) {
        return authenticationService.verifyAuthentication(authHeader);
    }
}
