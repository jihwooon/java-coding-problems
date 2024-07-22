package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 분할정복 {

    private int[] solution(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);

        int[] answer = new int[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[i];
        }

        return answer;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{3, 5, 1, 2, 8, 10, 22, 9})).isEqualTo(
            new int[]{1, 2, 3, 5, 8, 9, 10, 22});
    }
}
