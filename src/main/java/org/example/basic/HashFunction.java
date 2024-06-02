package org.example.basic;

import java.util.HashSet;

public class HashFunction {

    private int x;
    private int y;

    public HashFunction() {}

    public static HashFunction of(final int x, final int y) {
        HashFunction hashFunction = new HashFunction();
        hashFunction.x = x;
        hashFunction.y = y;

        return new HashFunction();
    }

    public static void main(String[] args) {
        HashSet<HashFunction> hashSet = new HashSet<>();

        HashFunction hashFunction = HashFunction.of(1, 2);
        hashSet.add(hashFunction);

        System.out.println(hashSet.contains(hashFunction));
    }
}
