package Sort;

import org.junit.Test;

public class QuickSort {

    void quickSort(int[] arr, int l, int r) {

    }

    @Test
    public void test_quicksort() {
        int[] arr = {1, 7, 5, 3, 2, 8, 9};
        quickSort(arr, 0, arr.length);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }
}
