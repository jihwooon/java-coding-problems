package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class 함수형스타일 {

    private int solution(List<Integer> integers) {
        if (integers == null) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return integers.stream()
            .filter(i -> i != null)
            .mapToInt(Integer::intValue)
            .sum();
    }

    @Test
    public void result() {
        assertThat(solution(Arrays.asList(1, 2, null, 3, 4, 5))).isEqualTo(15);
    }
}
