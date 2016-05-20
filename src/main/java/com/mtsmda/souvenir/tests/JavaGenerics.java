package com.mtsmda.souvenir.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 5/18/2016.
 */
public class JavaGenerics {

    public static void main(String[] args) {
        listSuper(new ArrayList<Number>());
        listSuper(new ArrayList<Object>());
//        listSuper(new ArrayList<Integer>());

        list2Extends(new ArrayList<Number>());
        list2Extends(new ArrayList<Integer>());
        list2Extends(new ArrayList<Double>());
    }

    private static void listSuper(List<? super Number> objects){

    }

    private static void list2Extends(List<? extends Number> objects){

    }

}