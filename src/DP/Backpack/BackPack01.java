package DP.Backpack;

import java.util.Scanner;

public class BackPack01 {
    public static int maxValue(int[] weights, int[] values, int capacity) {
        int[][] f = new int[weights.length][capacity + 1];
        for (int i = 1; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= weights[i]) f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - weights[i]] + values[i]);
            }
        }
        return f[f.length - 1][f[0].length - 1];
    }

    public static int maxValueOneDimension(int[] weights, int[] values, int capacity) {
        int[] f = new int[capacity + 1];
        for (int i = 1; i < weights.length; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                f[j] = Math.max(f[j], f[j - weights[i]] + values[i]);
            }
        }
        return f[capacity];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int capacity = in.nextInt();
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            weights[i + 1] = in.nextInt();
            values[i + 1] = in.nextInt();
        }
        System.out.println(maxValueOneDimension(weights, values, capacity));
    }
}
