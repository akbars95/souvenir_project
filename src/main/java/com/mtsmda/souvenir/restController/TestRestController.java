package com.mtsmda.souvenir.restController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dminzat on 3/18/2016.
 */
public class TestRestController {

    public static void main(String[] args) {
        List<Day> days = new ArrayList<>();

        for(Day day : Day.values()){
            if(!day.equals(Day.TUESDAY)){
                days.add(day);
            }
        }
        System.out.println(days);
    }

}

enum Day{
    MONDAY,
    TUESDAY,
    WEDNESDAY

}