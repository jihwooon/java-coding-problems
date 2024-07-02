package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 배열의길이에따라다른연산하기 {

    public int[] calculate(int[] arr, int n, int i) {
        if (arr.length % 2 == 1 && i % 2 == 0) {
            arr[i] += n;
        } else if (arr.length % 2 == 0 && i % 2 == 1) {
            arr[i] += n;
        }

        return arr;
    }

    public int[] solution(int[] arr, int n) {
        int[] answer = {};

        for (int i = 0; i < arr.length; i++) {
            answer = calculate(arr, n, i);
        }

        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{49, 12, 100, 276, 33}, 27)).isEqualTo(
            new int[]{76, 12, 127, 276, 60});
        assertThat(solution(new int[]{444, 555, 666, 777}, 100)).isEqualTo(
            new int[]{444, 655, 666, 877});
    }
}
