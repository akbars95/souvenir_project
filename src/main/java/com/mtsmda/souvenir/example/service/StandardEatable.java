package com.mtsmda.souvenir.example.service;

/**
 * Created by dminzat on 3/31/2016.
 */
public class StandardEatable implements Eatable {
    @Override
    public void eat() {
        System.out.println(this.getClass().getCanonicalName());
    }
}