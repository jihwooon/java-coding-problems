package org.example.basic;

public class BineryArray {

    public static void main(String[] args) {
        int[][] score = {
            {100, 100, 100},
            {20, 20, 20},
            {30, 30, 30},
            {40, 40, 40},
            {50, 50, 50}
        };

        findIndex("컴퓨터");
        calculate(score);
    }

    private static void findIndex(String str) {
        String[][] words = {
            {"chair", "의자"},
            {"computer", "컴퓨터"},
            {"integer", "의자"}
        };

        for (int i = 0; i < words.length; i++) {
            if (str.equals(words[i][1])) {
                System.out.println("정답");
            } else {
                System.out.println("실패");
            }
        }
    }

    private static void calculate(int[][] score) {
        int sum = 0;
        int average = 0;

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                sum += score[i][j];
                average = sum / score[i].length;
            }

            System.out.println("sum: " + sum);
            System.out.println("average: " + average);
        }
    }
}
