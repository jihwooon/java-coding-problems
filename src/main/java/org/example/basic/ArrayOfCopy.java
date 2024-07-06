package org.example.basic;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayOfCopy {

    public static void main(String[] args) {
        copyList(); // 배열 복사
        copyArrayList(); // 배열 리스트 복사
    }

    private static void copyList() {
        int[] primes = new int[]{1, 2, 3, 4, 5};
        int[] numbers = primes;

        numbers[3] = 42;

        System.out.println("배열 복사: " + numbers[3]);

        int[] copiedPrimes = Arrays.copyOf(primes, primes.length);

        System.out.println("배열 복사: " + copiedPrimes.length);
    }

    private static void copyArrayList() {
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Bill Joy");
        friends.add("Paul");

        ArrayList<String> people = friends;
        people.set(0, "Mary");

        ArrayList<String> copiedFriends = new ArrayList<>(friends);

        System.out.println("배열 리스트: " + copiedFriends);
    }
}
