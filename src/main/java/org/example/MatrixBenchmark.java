package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class MatrixBenchmark {

    public static void main(String[] args) {
        int size = 1000;
        int[][] mat = generateRandomMatrix(size, size);
        int iterations = 100;

        List<Long> times1 = new ArrayList<>();
        List<Long> times2 = new ArrayList<>();

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            averageMat_v1(mat, size);
            long endTime = System.nanoTime();
            times1.add(endTime - startTime);

            startTime = System.nanoTime();
            averageMat_v2(mat, size);
            endTime = System.nanoTime();
            times2.add(endTime - startTime);
        }

        double avgTime1 = times1.stream().mapToLong(Long::longValue).average().orElse(0);
        double avgTime2 = times2.stream().mapToLong(Long::longValue).average().orElse(0);

        System.out.println("Row-major (v1) average time: " + avgTime1 + " ns");
        System.out.println("Column-major (v2) average time: " + avgTime2 + " ns");

        createChart(times1, times2);
    }

    private static void createChart(List<Long> times1, List<Long> times2) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < times1.size(); i++) {
            dataset.addValue(times1.get(i), "Row-major", String.valueOf(i + 1));
            dataset.addValue(times2.get(i), "Column-major", String.valueOf(i + 1));
        }

        JFreeChart chart = ChartFactory.createLineChart(
            "Row-major vs Column-major Access Time",
            "Iteration",
            "Time (ns)",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Benchmark Results");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ChartPanel(chart));
            frame.pack();
            frame.setVisible(true);
        });
    }

    private static int[][] generateRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = rand.nextInt(100);
            }
        }
        return mat;
    }

    private static int averageMat_v1(int[][] mat, int n) {
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                total += mat[i][j];
            }
        }

        return total / (n * n);
    }

    private static int averageMat_v2(int[][] mat, int n) {
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                total += mat[j][i];
            }
        }

        return total / (n * n);
    }
}
