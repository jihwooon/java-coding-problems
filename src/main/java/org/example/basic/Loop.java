package org.example.basic;

public class Loop {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5};

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println(sum);

        int loopSum = 0;
        for (int n : numbers) {
            loopSum += n;
        }

        System.out.println(loopSum);
    }
}
