package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 시저암호 {

    public StringBuilder solution(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            stringBuilder.append(push(c, n));
        }

        return stringBuilder;
    }

    private static char push(char c, int i) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        char offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + i) % ('Z' - 'A' + 1);

        return (char) (offset + position);
    }

    @Test
    public void result() {
        assertThat(solution("AB", 1)).isEqualTo("BC");
    }

}
