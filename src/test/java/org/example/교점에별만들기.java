package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : points) {
            if (point.x < x) {
                x = point.x;
            }
            if (point.y < y) {
                y = point.y;
            }
        }

        return new Point(x, y);
    }

    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : points) {
            if (point.x > x) {
                x = point.x;
            }
            if (point.y > y) {
                y = point.y;
            }
        }

        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(
                    line[i][0], line[i][1], line[i][2],
                    line[j][0], line[j][1], line[j][2]
                );

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point maximumPoint = getMaximumPoint(points);
        Point minimumPoint = getMinimumPoint(points);

        int width = (int) (maximumPoint.x - minimumPoint.x + 1);
        int height = (int) (maximumPoint.y - minimumPoint.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int) (p.x - minimumPoint.x);
            int y = (int) (maximumPoint.y - p.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }

    @Test
    public void result() {
        assertThat(solution(
            new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})).isEqualTo(
            new String[]{"....*....", ".........", ".........", "*.......*", ".........",
                ".........", ".........", ".........", "*.......*"});

        assertThat(solution(
            new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}})).isEqualTo(new String[]{"*.*"});
    }
}
