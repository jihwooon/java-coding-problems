package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class 중복된숫자개수 {

    public int countDuplicates(int[] array, int n) {
        int count = 0;

        for (int num : array) {
            if (num == n) {
                count++;
            }
        }

        return count;
    }

    public int countDuplicatesByStream(int[] array, int n) {
        return (int) Arrays.stream(array)
            .filter(num -> num == n)
            .count();
    }

    public int countDuplicatesRecursive(int[] array, int n) {
        return countDuplicatesRecursive(array, n, 0 ,0);
    }

    private int countDuplicatesRecursive(int[] array, int n, int index, int count) {
        if (index >= array.length) {
            return count;
        }

        if (array[index] == n) {
            count++;
        }

        return countDuplicatesRecursive(array, n, index + 1, count);
    }

    @Test
    public void result() {
        assertThat(countDuplicates(new int[]{1, 1, 2, 3, 4, 5}, 1)).isEqualTo(2);
        assertThat(countDuplicatesByStream(new int[]{1, 1, 2, 3, 4, 5}, 1)).isEqualTo(2);
        assertThat(countDuplicatesRecursive(new int[]{1, 1, 2, 3, 4, 5}, 1)).isEqualTo(2);
    }
}
