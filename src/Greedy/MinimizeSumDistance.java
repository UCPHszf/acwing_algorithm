package Greedy;

import java.util.Arrays;

public class MinimizeSumDistance {
    public int minimizeSumDistance(int[] locations) {
        Arrays.sort(locations);
        int n = locations.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(locations[i] - locations[n / 2]);
        }
        return res;
    }
}
