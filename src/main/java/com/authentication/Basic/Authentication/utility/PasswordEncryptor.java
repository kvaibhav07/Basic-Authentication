package com.authentication.Basic.Authentication.utility;

import org.jasypt.util.text.BasicTextEncryptor;

public class PasswordEncryptor {

    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

        // Set the encryption key
        textEncryptor.setPassword("my-secret-key");

        // Encrypt the username and password
       // String encryptedUsername = textEncryptor.encrypt("my-username");
        String encryptedPassword = textEncryptor.encrypt("my-password");

        //System.out.println("Encrypted Username: " + encryptedUsername);
        System.out.println("Encrypted Password: " + encryptedPassword);
       // System.out.println("Decrypted Password : "+textEncryptor.decrypt("encrypted-password"));
    }
}
