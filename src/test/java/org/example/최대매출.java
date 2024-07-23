package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 최대매출 {

    private int solution(int[] arr, int k) {
        int answer;
        int sum = 0;
        for (int j = 0; j < k; j++) {
            sum += arr[j];
        }

        answer = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{12, 15, 11, 20, 25, 10, 20, 19, 13, 15}, 3)).isEqualTo(56);
    }
}
