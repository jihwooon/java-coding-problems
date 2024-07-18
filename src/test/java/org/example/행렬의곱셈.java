package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 행렬의곱셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int column = arr2[0].length;
        int[][] arr = new int[row][column];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;

                for (int k = 0; k < arr1.length - 1; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return arr;
    }

    @Test
    public void result() {
        assertThat(solution(new int[][]{
            {1, 4},
            {3, 2},
            {4, 1}
        }, new int[][]{
            {3, 3},
            {3, 3}
        })).isEqualTo(new int[][]{
            {15, 15},
            {15, 15},
            {15, 15}
        });
    }
}
