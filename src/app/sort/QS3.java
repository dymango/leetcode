package app.sort;

/**
 * @author dimmy
 */
public class QS3 {

    public void sort(int[] list, int start, int end) {
        if (start >= end) return;
        int index = findIndex(list, start, end);
        sort(list, start, index - 1);
        sort(list, index, end);
    }

    private void exchange(int[] list, int i, int j) {
        int t = list[i];
        list[i] = list[j];
        list[j] = t;
    }

    public int findIndex(int[] list, int start, int end) {
        int tag = list[start];
        int left = start + 1;
        int right = end;
        while (left < right) {
            while (left < end && list[left] < tag) {
                left++;
            }

            while (right > start && list[right] >= tag) {
                right--;
            }

            if (left < right) {
                exchange(list, left, right);
            }
        }

        if (list[left] < tag) {
            exchange(list, start, left);
        }

        return left;
    }

    public static void main(String[] args) {
        int[] list = {5, 8, 9, 2, 5, 0, 2, 4};
        new QS3().sort(list, 0, list.length - 1);
        int i = 1;
    }

}


