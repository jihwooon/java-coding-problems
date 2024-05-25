package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class 중앙값구하기 {
    public int solution(int[] array) {
        Arrays.sort(array);

        return array[array.length >> 1];
    }

    @Test
    public void result() throws Exception {
        assertThat(solution(new int[]{1, 2, 10, 7, 11})).isEqualTo(7);
        assertThat(solution(new int[]{9, -1, 0})).isEqualTo(0);
    }
}
