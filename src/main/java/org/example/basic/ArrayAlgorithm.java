package org.example.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayAlgorithm {

    public static void main(String[] args) {
        int[] numbers = {3, 1, 4, 2};
        ArrayList<String> friends = new ArrayList<>();
        friends.add("joy");
        friends.add("bill");
        friends.add("peter");

        reverseAndshuffle(friends);
        sort(numbers, friends);
        fill(numbers, friends);
    }

    private static void reverseAndshuffle(ArrayList<String> friends) {
        Collections.reverse(friends);
        System.out.println(friends);

        Collections.shuffle(friends);
        System.out.println(friends);
    }

    private static void sort(int[] numbers, ArrayList<String> friends) {
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        Collections.sort(friends);
        System.out.println(friends);
    }

    private static void fill(int[] numbers, ArrayList<String> friends) {
        Arrays.fill(numbers, 0);

        System.out.println(Arrays.toString(numbers));

        Collections.fill(friends, "1");

        System.out.println(friends);
    }
}
