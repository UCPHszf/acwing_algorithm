package Sort;

import org.junit.Test;

public class MergeSort {
    int[] tmp;

    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        mergeSort(arr, 0, mid);
        mergeSort(arr, mid + 1, r);
        int k = 0;
        int i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= r) {
            tmp[k++] = arr[j++];
        }
        for (int a = l, b = 0; a <= r; a++, b++) {
            arr[a] = tmp[b];
        }
    }

    @Test
    public void test_MergeSort() {
        int[] arr = {1, 5, 6, 8, 4, 2, 9, 11, 100, 35};
        tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        for (Integer i : arr) {
            System.out.println(i + " ");
        }
    }
}
