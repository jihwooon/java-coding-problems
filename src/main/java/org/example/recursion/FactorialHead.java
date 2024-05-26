package org.example.recursion;

public class FactorialHead {

    public long factorialHead(long n) {
        if (n == 1L) {
            return 1L;
        }

        var nextN = n - 1L;

        return n * factorialHead(nextN);
    }

    public static void main(String[] args) {
        FactorialHead factorialhead = new FactorialHead();

        System.out.println(factorialhead.factorialHead(4L));
    }

}
