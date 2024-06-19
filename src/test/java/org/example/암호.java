package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 암호 {

    private static class Hash {

        int number;
        String str;

        public Hash(int number, String str) {
            this.number = number;
            this.str = str;
        }

        public String replaceHash(String str) {
            String substring = str.substring(0, 7);
            String replace = substring.replace('#', '1').replace('*', '0');

            return replace;
        }

        public String replaceBinary(String replace, String answer) {
            int index = Integer.parseInt(replace, 2);
            answer += (char) index;

            return answer;
        }

        public String getSubstring(String str) {
            return str.substring(7);
        }
    }

    private String solution(int n, String str) {
        Hash hash = new Hash(n, str);
        String answer = "";

        for (int i = 0; i < n; i++) {
            String replace = hash.replaceHash(str);

            answer = hash.replaceBinary(replace, answer);

            str = hash.getSubstring(str);
        }

        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(4, "#****###**#####**#####**##**")).isEqualTo("COOL");
    }
}
