package com.mtsmda.souvenir.model;

/**
 * Created by dminzat on 5/25/2016.
 */
public class B {

    public static void main(String[] args) {
        System.out.println(Fibonachi(3));
        System.out.println(Fibonacci(3));
    }

    static int Fibonachi(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return 1;
        }
        else
        {
            return Fibonachi(n - 1) + Fibonachi(n - 2);
        }
    }

    static long Fibonacci(int n)
    {
        if (n < 3)
            return 1;
        else
            return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

}