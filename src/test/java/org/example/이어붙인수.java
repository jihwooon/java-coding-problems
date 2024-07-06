package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 이어붙인수 {

    public int solution(int[] num_list) {
        String linkedOddNumber = "";
        String linkedEvenNumber = "";

        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) {
                linkedOddNumber += num_list[i];
            } else {
                linkedEvenNumber += num_list[i];
            }
        }

        return Integer.parseInt(linkedOddNumber) + Integer.parseInt(linkedEvenNumber);
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{3, 4, 5, 2, 1})).isEqualTo(393);
        assertThat(solution(new int[]{5, 7, 8, 3})).isEqualTo(131);
    }
}
