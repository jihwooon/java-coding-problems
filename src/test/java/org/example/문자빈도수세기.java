package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 문자빈도수세기 {

    private long solution(String str, char ch) {
        return str.chars()
            .filter(c -> c == ch)
            .count();
    }

    @Test
    public void result() {
        assertThat(solution("char", 'a')).isEqualTo(1);
    }
}
