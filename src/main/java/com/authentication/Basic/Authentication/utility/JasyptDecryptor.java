package com.authentication.Basic.Authentication.utility;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JasyptDecryptor {

    @Value("${jasypt.encryptor.password}")
    private String encryptionKey;

    public String decrypt(String encryptedText) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(encryptionKey);
        String encryptedValue = encryptedText.replaceAll("^ENC\\((.*)\\)$", "$1");
        String encryptPassword = textEncryptor.decrypt(encryptedValue);
        return encryptPassword;
    }
}
