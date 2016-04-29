package com.mtsmda.souvenir.tests;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by dminzat on 4/29/2016.
 */
public class SetDemo {

    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(19);
        integerSet.add(28);
        integerSet.add(150);

        Set<Integer> integerSet1 = new HashSet<>();
        for(int i = 0; i < 30; i++){
            integerSet1.add(i);
        }

        integerSet.addAll(integerSet1);

        Iterator<Integer> iterator = integerSet.iterator();
        for(;iterator.hasNext();){
            if(iterator.next().equals(5)){
                iterator.remove();
            }
        }

        System.out.println(integerSet.size());
    }

}