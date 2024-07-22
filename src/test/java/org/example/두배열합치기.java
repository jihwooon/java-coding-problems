package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 두배열합치기 {

    private int[] solution(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        int left = arr1.length - 1;
        int right = arr2.length;

        while (i <= left && j <= right) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < left) {
            result[k++] = arr1[i++];
        }

        while (j < right) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{1, 3, 5}, new int[]{2, 3, 6, 7, 9})).isEqualTo(
            new int[]{1, 2, 3, 3, 5, 6, 7, 9});
    }
}
