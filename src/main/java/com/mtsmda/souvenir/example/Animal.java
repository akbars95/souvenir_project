package com.mtsmda.souvenir.example;

import com.mtsmda.souvenir.example.service.Eatable;

/**
 * Created by dminzat on 3/31/2016.
 */
public class Animal implements Eatable {
    @Override
    public void eat() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
