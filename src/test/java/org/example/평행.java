package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class 평행 {

    public double getSlope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }

    public int solution(int[][] dots) {
        Set<Double> slopes = new HashSet<>();

        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double slope = getSlope(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);

                if (slopes.contains(slope)) {
                    return 1;
                }

                slopes.add(slope);
            }
        }

        return 0;
    }

    public int solution1(int[][] dots) {
        Set<Double> slopes = new HashSet<>();

        return Arrays.stream(dots)
            .flatMap(dot1 -> Arrays.stream(dots)
                .filter(dot2 -> !Arrays.equals(dot1, dot2))
                .map(dot2 -> getSlope(dot1[0], dot1[1], dot2[0], dot2[1])))
            .anyMatch(slope -> !slopes.add(slope)) ? 1 : 0;
    }

    @Test
    public void result() throws Exception {
        assertThat(solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}})).isEqualTo(1);
        assertThat(solution1(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}})).isEqualTo(1);
    }

}
