package org.example;

// Ex1. Guess output line 19, 20, 21
// 5 Minutes
public class FixOperator {

    public static void main(String[] args) {

        int a = 1;
        int b = 2;
        int c = 3;

        a = b++ + c++; // b++ -> b = 2 ; c++ -> c= 3 => a = 5
        b = ++a * c--; // ++a -> a = 5 + 1 = 6 * 4 => 24
        c = a + b - c; // 6 + 24 - 3

        // Guess the Output
        // 1. a: 6
        // 2. b: 12
        // 3. c: 16
        System.out.println("a = " + a); // Line 1
        System.out.println("b = " + b); // Line 2
        System.out.println("c = " + c); // Line 3
    }
}
