package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class 중복된문자제거 {

    public String solution(String str) {
        HashSet<Character> used = new HashSet<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (used.contains(c)) {
                continue;
            }
            used.add(c);
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public String removeDuplicates(String str) {
        return Arrays.asList(str.split("")).stream()
            .distinct()
            .collect(Collectors.joining());
    }

    @Test
    public void result() {
        assertThat(solution("people")).isEqualTo("peol");
        assertThat(removeDuplicates("people")).isEqualTo("peol");
    }
}
