package com.mtsmda.souvenir.spring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dminzat on 6/7/2016.
 */
public class PasswordEncoderGenerator {

    public static void main(String[] args) {
        Map<String, String> usernamePassword = new LinkedHashMap<>();
        usernamePassword.put("ivanAdmin1", "ivan1");
        usernamePassword.put("petr5", "petr5");
        usernamePassword.put("kuzima7", "kuzima7");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        usernamePassword.forEach((key, value) ->{
            System.out.println(key + " original " + value + "\thash - " + bCryptPasswordEncoder.encode(value));
        });

    }

}