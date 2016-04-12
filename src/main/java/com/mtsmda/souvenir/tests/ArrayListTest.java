package com.mtsmda.souvenir.tests;

import com.mtsmda.souvenir.model.SouvenirCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 4/11/2016.
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<SouvenirCategory> souvenirCategories = new ArrayList<>();
        SouvenirCategory souvenirCategory = new SouvenirCategory("cat1");
        souvenirCategories.add(souvenirCategory);
        souvenirCategories.add(new SouvenirCategory("cat2"));
        souvenirCategory.setSouvenirCategory("cat3");
        souvenirCategories.add(souvenirCategory);
        souvenirCategory = new SouvenirCategory("cat4");
        souvenirCategories.add(souvenirCategory);
        souvenirCategories.add(new SouvenirCategory("cat5"));

        for (SouvenirCategory souvenirCategory1 : souvenirCategories){
            System.out.println(souvenirCategory1);
        }

    }

}