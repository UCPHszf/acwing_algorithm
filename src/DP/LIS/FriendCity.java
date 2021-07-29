package DP.LIS;

import CustomizeDataStructure.Pair;

import java.util.Arrays;
import java.util.Comparator;

public class FriendCity {
    public int maxBridge(Pair<Integer, Integer>[] arr) {
        Arrays.sort(arr, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.first().compareTo(o2.first());
            }
        });
        int[] f = new int[arr.length];
        int res = 0;
        for (int i = 0; i < f.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j].second() < arr[i].second()) {
                    f[i] = Math.max(f[i], f[j] + 1);
                    res = Math.max(res, f[i]);
                }
            }
        }
        return res;
    }
}
