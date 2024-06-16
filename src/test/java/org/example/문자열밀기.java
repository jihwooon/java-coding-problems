package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

// A를 밀어서 B의 문자열이 되었을 때 최소 횟수 구하기
// 1. 입력 된 문자열의 모든 문자에 대해서 반복한다.
// 2. 알파벳이 아닌 경우 그대로 이어 붙이기
// 3. 알파벳인 경우 n만큼 밀어 이어 붙이기
public class 문자열밀기 {

    private int solution(String A, String B) {
        int count = 0;
        String copy = A;

        for (int i = 0; i < A.length(); i++) {
            if (copy.equals(B)) {
                return count;
            }

            String endLatter = copy.substring(copy.length() - 1);
            copy = endLatter + copy.substring(0, copy.length() - 1);
            count++;
        }

        return -1;
    }

    @Test
    public void result() throws Exception {
        assertThat(solution("hello", "ohell")).isEqualTo(1);
        assertThat(solution("apple", "elppa")).isEqualTo(-1);
    }
}
