package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 숫자만포함사는문자열 {

    public boolean containsOnlyDigits(String str) {
        return !str.chars().allMatch(n -> !Character.isDigit(n));
    }

    @Test
    public void result() throws Exception {
        assertThat(containsOnlyDigits("12345")).isEqualTo(true);
    }
}
