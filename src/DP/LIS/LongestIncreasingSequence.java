package DP.LIS;

import java.util.Scanner;

public class LongestIncreasingSequence {
    public static int LongestClimbingSequenceLength(int[] arr) {
        int[] dp = new int[arr.length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(LongestClimbingSequenceLength(arr));
    }
}
