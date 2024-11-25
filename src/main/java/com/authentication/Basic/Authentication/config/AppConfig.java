package com.authentication.Basic.Authentication.config;

import com.authentication.Basic.Authentication.utility.JasyptDecryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    private final JasyptDecryptor jasyptDecryptor;

    @Value("${app.auth.username}")
    private String username;

    @Value("${app.auth.password}")
    private String password;

    public AppConfig(JasyptDecryptor jasyptDecryptor) {
        this.jasyptDecryptor = jasyptDecryptor;
    }

    public String getPassword() {
        return jasyptDecryptor.decrypt(password);
    }

    public String getUsername() {
        return username;
    }
}
