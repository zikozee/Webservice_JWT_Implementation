package com.zikozee.sprinboot.consumingwebservices.jwt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCRYPTER {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        for (int i = 0; i < 10; i++) {
            String encodedPassword = encoder.encode("ziko123");
            System.out.println(encodedPassword);
        }
    }
}
