package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 교점에별만들기 {

    private static class Point {

        public final long x;
        public final long y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }

    public String[] solution(int[][] line) {
        String[] answer = {};

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {

            }
        }

        return answer;
    }

    @Test
    public void result() {
        Point point = new Point(1,2);

        assertThat(point.x).isEqualTo(1);
        assertThat(point.y).isEqualTo(2);


//        assertThat(solution(
//            new int[][]{{2, -1, 4}, {-2 - 1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})).isEqualTo(
//            new String[]{"....*....", ".........", ".........", "*.......*", ".........",
//                ".........", ".........", ".........", "*.......*"});
    }

}
