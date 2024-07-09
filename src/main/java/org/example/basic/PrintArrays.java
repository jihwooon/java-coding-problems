package org.example.basic;

import java.util.Arrays;

public class PrintArrays {

    public static void main(String[] args) {
        printToString();
        printEquals();
        printSort();
    }

    private static void printSort() {
        int[] arr = {3, 2, 0, 1, 4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void printEquals() {
        String[][] str2D = {{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2D2 = {{"aaa", "bbb"}, {"AAA", "BBB"}};

        System.out.println(Arrays.equals(str2D, str2D2));
        System.out.println(Arrays.deepEquals(str2D, str2D2));
    }

    private static void printToString() {
        int[] arr = {0, 1, 2, 3};
        int[][] arr2D = {{11, 12}, {21, 22}};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(arr2D));
    }
}
