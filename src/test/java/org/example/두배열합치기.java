package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class 두배열합치기 {

    private ArrayList<Integer> solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int i = 0;
        int j = 0;
        int left = arr1.length - 1;
        int right = arr2.length;

        while (i <= left && j <= right) {
            if (arr1[i] < arr2[j]) {
                answer.add(arr1[i++]);
            } else {
                answer.add(arr2[j++]);
            }
        }

        while (i < left) {
            answer.add(arr1[i++]);
        }

        while (j < right) {
            answer.add(arr2[j++]);
        }

        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{1, 3, 5}, new int[]{2, 3, 6, 7, 9})).isEqualTo(
            List.of(1, 2, 3, 3, 5, 6, 7, 9));
    }
}
