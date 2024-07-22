package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class n의제곱 {

    private int solution(int n, int m) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 1;
        }
        if (m == 0) {
            return 1;
        }

        return n * solution(n, m - 1);
    }

    @Test
    public void result() {
        assertThat(solution(0, 0)).isEqualTo(1);
        assertThat(solution(2, 3)).isEqualTo(8);
    }
}
