package com.mtsmda.souvenir.helper;

/**
 * Created by dminzat on 3/11/2016.
 */
public class Simple {

    public static void main(String[] args) {
        Counter counter = new Counter(190);
        counter.increment(100);
        counter.decrement(250);
        System.out.println(counter.getValue());
    }

}

class Counter{
    private int value;

    public Counter() {
        this(0);
    }

    public Counter(int value) {
        this.value = value;
    }

    public void increment(int value){
        this.value += value;
    }

    public void decrement(int value){
        increment(-value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}