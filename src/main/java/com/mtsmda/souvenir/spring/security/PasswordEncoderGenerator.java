package com.mtsmda.souvenir.spring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dminzat on 6/7/2016.
 */
public class PasswordEncoderGenerator {

    private static String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

    /*public static void main(String[] args) {
        Map<String, String> usernamePassword = new LinkedHashMap<>();
        usernamePassword.put("ivanAdmin1", "ivan1");
        usernamePassword.put("petr5", "petr5");
        usernamePassword.put("kuzima7", "kuzima7");

        *//*BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(15);*//*

        usernamePassword.forEach((key, value) ->{
            System.out.println(key + " original " + value + "\thash - " + encodePassword(value));
        });

        System.out.println("Done");
    }*/

}