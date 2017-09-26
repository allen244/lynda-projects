package com.example.java;

public class Main {

    public static void main(String[] args) {

        int intValue1 = 56;
        int intValue2 = 42;

        int result = intValue1 + intValue2;

        System.out.println("addition " + result);

        int result1 = intValue1 - intValue2;

        System.out.println("Sub " + result1);
        int result2 = intValue1 * intValue2;

        System.out.println("mult " + result2);
        double result3 = (double) intValue1 / intValue2;

        System.out.println("div " + result3);
        int result4 = intValue1 % intValue2;

        System.out.println("modulus " + result4);

        boolean test = false;
        boolean r = !test;

        System.out.println("test " + r);

        int t =10;

        System.out.println("test " + t++);


        System.out.println("test " + t);

    }

}
