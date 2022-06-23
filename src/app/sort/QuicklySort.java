package app.sort;

/**
 * @author dimmy
 */
public class QuicklySort {
    public void sort(int[] arr, int low, int hi) {
        if (low >= hi) return;
        int j = partition(arr, low, hi);
        sort(arr, low, j - 1);
        sort(arr, j + 1, hi);
    }

    private int partition(int[] arr, int low, int hi) {
        int sign = arr[low];
        int i = low, j = hi + 1;
        while (true) {
            while (i < hi && arr[++i] < sign) {
            }
            while (j > low && arr[--j] > sign) {
            }
            if (i >= j) break;
            exchange(arr, i, j);
        }

        exchange(arr, low, j);
        return j;
    }


    private void exchange(int[] arr, int p1, int p2) {
        if (p1 == p2) return;
        arr[p1] ^= arr[p2];
        arr[p2] ^= arr[p1];
        arr[p1] ^= arr[p2];
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 8, 9, 2, 5, 0, 2, 4};
        new QuicklySort().sort(a, 0, a.length - 1);
        int i = 1;
    }
}
