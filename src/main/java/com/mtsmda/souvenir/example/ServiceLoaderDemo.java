package com.mtsmda.souvenir.example;

import com.mtsmda.souvenir.example.service.Eatable;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by dminzat on 3/31/2016.
 */
/**
 * souvenir_project\src\main\resources\META-INF\services
 * */
public class ServiceLoaderDemo {

    public static void main(String[] args) {
        ServiceLoader<Eatable> eatables = ServiceLoader.load(Eatable.class);
        Iterator<Eatable> iterator = eatables.iterator();
        while (iterator.hasNext()) {
            iterator.next().eat();
        }
    }

}