package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class 문제개수세기 {

    public Map<Character, Integer> solution(String str) {
        HashMap<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            result.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }
        System.out.println(result);

        return result;
    }

    @Test
    public void result() throws Exception {
        assertThat(solution("1234565")).isEqualTo("{'1'=1, '2'=1, '3'=1, '4'=1, '5'=2, '6'=1}");
    }

    public Map<Character, Long> countDuplicateCharacters(String str) {
        Map<Character, Long> result = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return result;
    }

    @Test
    public void result2() throws Exception {
        assertThat(countDuplicateCharacters("1234565")).isEqualTo("");
    }
}
