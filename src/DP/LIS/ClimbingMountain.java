package DP.LIS;

public class ClimbingMountain {
    //需要先单调上升，再单调下降，即折线型
    public static int getLongestSequenceLength(int[] arr) {
        int[] f = new int[arr.length];
        int[] g = new int[arr.length];
        for (int i = 0; i < f.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (f[i] > f[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            g[i] = 1;
            for (int j = arr.length - 1; j > i; j--) {
                if (g[i] > g[j]) {
                    g[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, f[i] + g[i] - 1);
        }
        return res;
    }
}
