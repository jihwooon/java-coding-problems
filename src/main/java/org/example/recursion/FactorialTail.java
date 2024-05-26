package org.example.recursion;

public class FactorialTail {

    public long factorialTail(long n, long accumulator) {
        if (n == 1L) {
            return accumulator;
        }

        var nextN = n - 1L;
        var nextAccumulator = n * accumulator;

        return n * factorialTail(nextN, nextAccumulator);
    }

    public static void main(String[] args) {
        FactorialTail factorialTail = new FactorialTail();

        System.out.println(factorialTail.factorialTail(4L,1L));
    }
}
