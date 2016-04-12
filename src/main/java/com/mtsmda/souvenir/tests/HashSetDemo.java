package com.mtsmda.souvenir.tests;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by dminzat on 4/7/2016.
 */
public class HashSetDemo {

    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        integers.add(new Integer(19));
        integers.add(new Integer(9));
        integers.add(new Integer(8));
        integers.add(new Integer(1029));
        integers.add(new Integer(152));

        for (Integer i : integers){
            System.out.println(i + " - " + i.hashCode());
        }

        Set<String> strings = new LinkedHashSet<>();
        strings.add("ivan");
        strings.add("rubit");
        strings.add("drova");
        strings.add("varvara");
        strings.add("topit");
        strings.add("peci");

        for (String s : strings){
            System.out.println(s + " - " + s.hashCode());
        }

    }

}