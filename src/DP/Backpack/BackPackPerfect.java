package DP.Backpack;

import java.util.Scanner;

public class BackPackPerfect {
    //完全背包问题
    public static int maxValue(int[] weights, int[] values, int capacity) {
        int[][] f = new int[weights.length][capacity + 1];
        for (int i = 1; i < weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                for (int k = 0; k * weights[i] <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * weights[i]] + k * values[i]);
                }
            }
        }
        return f[f.length - 1][f[0].length - 1];
    }

    public static int maxValueTwoDimension(int[] weights, int[] values, int capacity) {
        int[][] f = new int[weights.length][capacity + 1];
        for (int i = 1; i < weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= weights[i]) f[i][j] = Math.max(f[i][j], f[i][j - weights[i]] + values[i]);
            }
        }
        return f[f.length - 1][f[0].length - 1];
    }

    public static int maxValueOneDimension(int[] weights, int[] values, int capacity) {
        int[] f = new int[capacity + 1];
        for (int i = 1; i < weights.length; i++) {
            for (int j = weights[i]; j <= capacity; j++) {
                f[j] = Math.max(f[j], f[j - weights[i]] + values[i]);
            }
        }
        return f[capacity];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), capacity = in.nextInt();
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            weights[i] = in.nextInt();
            values[i] = in.nextInt();
        }
        System.out.println(maxValue(weights, values, capacity));
    }
}
