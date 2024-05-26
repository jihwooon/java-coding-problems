package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class 중복된문자제거 {

    public String removeDuplicatesByHashSet(String str) {
        HashSet<Character> hashSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (hashSet.contains(ch)) {
                continue;
            }
            hashSet.add(ch);
            stringBuilder.append(ch);
        }

        return stringBuilder.toString();
    }

    public String removeDuplicatesByStream(String str) {
        return Arrays.asList(str.split("")).stream()
            .distinct()
            .collect(Collectors.joining());
    }

    public String removeDuplicatesByStringBuilder(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (stringBuilder.indexOf(String.valueOf(ch)) == -1) {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }

    public String removeDuplicateRecursive(String str) {
        return removeDuplicatesRecursive(str, "", 0);
    }

    private String removeDuplicatesRecursive(String str, String result, int index) {
        if (index >= str.length()) {
            return result;
        }

        char currentChar = str.charAt(index);
        if (!result.contains(String.valueOf(currentChar))) {
            result += currentChar;
        }

        return removeDuplicatesRecursive(str.substring(index + 1), result, 0);
    }

    @Test
    public void result() {
        assertThat(removeDuplicatesByHashSet("people")).isEqualTo("peol");
        assertThat(removeDuplicatesByStream("people")).isEqualTo("peol");
        assertThat(removeDuplicatesByStringBuilder("people")).isEqualTo("peol");
        assertThat(removeDuplicateRecursive("people")).isEqualTo("peol");
    }
}
