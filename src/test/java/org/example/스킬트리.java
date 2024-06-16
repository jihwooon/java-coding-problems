package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * ## 미지의 것
 *  선행 스킬 순서 skill이고 유저들이 만든 스킬 트리를 담은 배열 매개별수로 주어질 때, 가능한 스킬 트리 개수를 반환하는 함수를 만들어라.
 *
 * ## 자료
 * 1. 스킬 순서는 CBD은 C -> B-> D 순서를 보장해야한다.
 * 2. skill_tree에 주어진 매개변수가 스킬 순서를 보장하지 않으면 불가능한 스킬 트리이다.
 *
 * ## 계획
 * 1. skill에 등장한 순서를 유지되어야 한다.
 * 2. skill 앞에서 나와야 하므로 skill 문자열의 앞부분, 즉 prefix가 되어야 합니다.
 *
 * ## 반성
 * 문제 풀이 유형을 알면 비교적으로 쉽게 풀 수 있다.
 */
public class 스킬트리 {

    public int solution(String skill, String[] skillTrees) {
        int count = (int) Arrays.stream(skillTrees)
            .map(s -> s.replaceAll("[^" + skill + "]", "")) // skillTrees 매개변수는 skill 문자열과 비교하고 제외한다.
            .filter(skill::startsWith) // prefix 동일 여부를 확인하고 확인한다.
            .count();

        return count;
    }

    @Test
    public void result() throws Exception {
        assertThat(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"})).isEqualTo(2);
    }
}
