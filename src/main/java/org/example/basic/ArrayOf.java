package org.example.basic;

import java.math.BigInteger;

public class ArrayOf {

    public static void main(String[] args) {
        String[] name = new String[100];

        for (int i = 0; i < name.length; i++) {
            name[i] = "";
        }

        BigInteger[] numbers = new BigInteger[100];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = BigInteger.valueOf(i);
        }

        String[] author = {
            "James Gosling",
            "Bill Joy",
            "Guy Steele",
        };

        String result = "";

        for (int i = 0; i < author.length; i++) {
           result =  author[i];
        }

        System.out.println(result);

    }
}
