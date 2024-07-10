package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class 큰수출력하기 {

    private ArrayList<Integer> solution(int[] n) {
        ArrayList<Integer> result = new ArrayList<>();

        result.add(n[0]);

        for (int i = 1; i < n.length; i++) {
            if (n[i] > n[i - 1]) {
                result.add(n[i]);
            }
        }

        return result;
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{7, 3, 9, 5, 6, 12})).isEqualTo(Arrays.asList(7, 9, 6, 12));
    }
}
