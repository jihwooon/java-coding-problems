package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 자연수뒤집어배열로만들기 {

    public int[] solution(long n) {
        String string = Long.toString(n);
        String reversed = new StringBuilder(string).reverse().toString();
        char[] charArray = reversed.toCharArray();

        int[] answer = new int[charArray.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = charArray[i] - '0';
        }

        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(12345)).isEqualTo(new int[]{5, 4, 3, 2, 1});
    }
}
