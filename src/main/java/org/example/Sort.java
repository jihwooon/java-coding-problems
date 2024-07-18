package org.example;

import java.util.Arrays;

//EX2. Given the array int[] numbers = { 48, 46, 7, 9, 8, 51, 98, 11, 12 },
// write a method to find the second largest number in the array.
// 15 Minutes
public class Sort {

    public static void main(String[] args) {
        int[] numbers = {48, 46, 7, 9, 8, 51, 98, 11, 12};

        System.out.println(findLatestNumber(numbers));
    }

    private static int findLatestNumber(int[] numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Array length must be at least 2");
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num != firstLargest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
