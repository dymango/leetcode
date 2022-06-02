package app.sort;

/**
 * @author dimmy
 */
public class QuicklySort2 {
    int[] arr;

    public QuicklySort2(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        sort(0, arr.length - 1);
    }

    private void sort(int low, int hi) {
        if (low >= hi) return;
        int partition = partition(low, hi);
        sort(low, partition - 1);
        sort(partition + 1, hi);
    }

    private int partition(int low, int hi) {
        int sign = arr[low];
        int i = low + 1;
        int j = hi;
        while (true) {
            while (i <= hi && arr[i] < sign) {
                i++;
            }
            while (j >= low && arr[j] > sign) {
                j--;
            }
            if (i >= j) break;
            exchange(i, j);
            i++;
            j--;
        }

        exchange(low, j);
        return j;
    }

    private void exchange(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuicklySort2 quicklySort2 = new QuicklySort2(new int[]{5, 8, 9, 2, 5, 0, 2, 4});
        quicklySort2.sort();
        int i = 1;
    }
}
