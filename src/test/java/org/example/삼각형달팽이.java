package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 삼각형달팽이 {

    private int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;

        int x = 0;
        int y = 0;

        while (true) {
            // 아래로 이동
            while (true) {
                // triangle[y][x]에 1이 할당이 되고 v는 2가 된다.
                triangle[y][x] = v++;
                if (y + 1 == n || triangle[y + 1][x] != 0) {
                    // y + 1 == n은 다음행 이 삼격형의 끝인지 확인한다.
                    break;
                }
                y += 1;
            }

            if (x + 1 == n || triangle[y][x + 1] != 0) {
                break;
            }
            x += 1;

            // 오른쪽으로 이동
            while (true) {
                triangle[y][x] = v++;
                if (x + 1 == n || triangle[y][x + 1] != 0) {
                    break;
                }
                x += 1;
            }
            if (triangle[y - 1][x - 1] != 0) {
                break;
            }
            x -= 1;
            y -= 1;

            // 왼쪽 위로 이동
            while (true) {
                triangle[y][x] = v++;
                if (triangle[y - 1][x - 1] != 0) {
                    break;
                }
                y -= 1;
                x -= 1;
            }
            if (y + 1 == n || triangle[y + 1][x] != 0) {
                break;
            }
            y += 1;
        }

        int[] result = new int[v - 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }

    @Test
    public void result() {
        assertThat(solution(4)).isEqualTo(new int[]{1, 2, 9, 3, 10, 8, 4, 5, 6, 7});
        assertThat(solution(5)).isEqualTo(
            new int[]{1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9});
    }
}
