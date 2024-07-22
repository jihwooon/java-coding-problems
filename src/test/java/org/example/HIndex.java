package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class HIndex {

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int h = citations.length - 1; h >= 1; h--) {
            // 논문의 갯수 중 3편이 3회 이상 인용 결과값 3이 나온다.
            if (isValid(citations, h)) {
                return h;// h 횟수의 값 리턴하라
            }
        }

        return answer;
    }

    private static boolean isValid(int[] citations, int h) {
        int index = citations.length - h; // 왜 인덱스가 필요하지?
        return citations[index] >= h;
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{3, 0, 6, 1, 5})).isEqualTo(3);
    }
}
