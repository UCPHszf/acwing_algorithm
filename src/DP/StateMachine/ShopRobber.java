package DP.StateMachine;

public class ShopRobber {
    public int maxMoney(int[] values) {
        int[][] f = new int[values.length + 1][2];
        int len = f.length;
        f[0][0] = 0;
        f[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + values[i];
        }
        return Math.max(f[len - 1][0], f[len - 1][1]);
    }
}
