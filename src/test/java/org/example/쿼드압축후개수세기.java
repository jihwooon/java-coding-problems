package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 쿼드압축후개수세기 {

    private static class Count {

        public final int zero;
        public final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;

        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                        .add(count(offsetX + h, offsetY, h, arr))
                        .add(count(offsetX, offsetY + h, h, arr))
                        .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }

        return new Count(1, 0);
    }

    public int[] solution(int[][] doubleArray) {
        Count count = count(0, 0, doubleArray.length, doubleArray);
        return new int[]{count.zero, count.one};
    }

    @Test
    public void result() {
        assertThat(solution(
            new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
            }))
            .isEqualTo(
                new int[]{4, 9});

        assertThat(solution(
            new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
            }))
            .isEqualTo(
                new int[]{10, 15});
    }
}
