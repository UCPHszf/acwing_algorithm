package Sort;

import org.junit.Test;

import java.util.Scanner;

public class Quick_choose {
    int[] arr = {1, 4, 2, 3, 5, 9, 8, 7, 6};

    public int quick_choose(int l, int r, int k) {
        if (l == r) return arr[l];
        int i = l - 1, j = r + 1, x = arr[l];
        while (i < j) {
            while (arr[++i] < x) ;
            while (arr[--j] > x) ;
            if(i<j)
                swap(arr, i, j);
        }
        int mid = j - l + 1;
        if (k <= mid) return quick_choose(l, j, k);
        return quick_choose(j + 1, r, k - mid);
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void quickChooseTest() {
        System.out.println(quick_choose(0, arr.length - 1, 6));
    }
}
