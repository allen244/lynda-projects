package com.example.java;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        double value = .012;
        double psum = value + value + value;
        System.out.println("Sum" + psum);

        String str = Double.toString(value);
        System.out.println("str" + str);

        BigDecimal big = new BigDecimal(str);
        BigDecimal bigSUM = big.add(big).add(big).add(big);
        System.out.println("bigSUM" + bigSUM.toString());

        int v= 56;
        int v2=v;
        System.out.println("v2 "+v2);

    }

}
