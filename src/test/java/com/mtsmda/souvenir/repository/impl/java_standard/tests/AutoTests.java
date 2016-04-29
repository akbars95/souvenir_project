package com.mtsmda.souvenir.repository.impl.java_standard.tests;

import com.mtsmda.souvenir.tests.Auto;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.*;

/**
 * Created by dminzat on 4/25/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AutoTests {

    private static Set<Auto> autos = new HashSet<>();
    private static List<Auto> autosList = new ArrayList<>();

    @BeforeClass
    public static void init(){
        for(int i = 0; i < 10; i++){
            Auto auto =  new Auto();
            Integer random = new Double(Math.random() * 100).intValue();
            auto.setId(random);
            auto.setModel("A" + random);
            auto.setMarka("Audi " + random);
            autos.add(auto);
            autosList.add(auto);
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test10DeleteFromSet(){
        System.out.println("size - " + autos.size());
        int i = 2;
        int count = 0;
        for (Auto auto : autos){
            count++;
            if(i == count){
                System.out.println(autos.remove(auto));
            }
        }
        System.out.println("size - " + autos.size());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test11DeleteFromList(){
        System.out.println("size - " + autosList.size());
        int i = 2;
        int count = 0;
        for (Auto auto : autosList){
            count++;
            if(i == count){
                System.out.println(autosList.remove(auto));
            }
        }
        System.out.println("size - " + autosList.size());
    }

    @Test()
    public void test10DeleteFromSetViaIterator(){
        System.out.println("size - " + autos.size());
        int i = 2;
        int count = 0;
        Iterator<Auto> iterator = autos.iterator();
        while (iterator.hasNext()){
            Auto auto = iterator.next();
            count++;
            if(i == count){
                iterator.remove();
            }
        }
        System.out.println("size - " + autos.size());
    }

}