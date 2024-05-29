package interview.prepare.ibmprepare;

/**
 * @author dimmy
 */
public class SortUtil {

    public static void main(String[] args) {
        int[] array = {4, 7, 8, 3, 2, 4, 7, 6, 1};
//        new SortUtil().quickSort(array);
        new SortUtil().mergeSort(array);
//        new QuicklySort2(array).sort();
        int i = 1;
    }

    public void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end) return;
        int index = findIndex(array, start, end);
        sort(array, start, index - 1);
        sort(array, index + 1, end);
    }

    private int findIndex(int[] array, int start, int end) {
        int sign = array[start];
        int sp = start + 1;
        int ep = end;
        while (true) {
            while (sp < array.length - 1 && array[sp] < sign) {
                sp++;
            }
            while (ep >= 0 && array[ep] > sign) {
                ep--;
            }

            if (sp >= ep) break;
            exchange(array, sp, ep);
            sp++;
            ep--;
        }

        exchange(array, start, ep);
        return ep;
    }

    private void exchange(int[] array, int x, int y) {
        int t = array[x];
        array[x] = array[y];
        array[y] = t;
    }

    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private int[] mergeSort(int[] array, int start, int end) {
        if (start > end) return new int[0];
        if (start == end) return new int[]{array[start]};
        int mid = start + (end - start) / 2;
        int[] tempArray = new int[end - start + 1];
        int[] leftArray = mergeSort(array, start, mid);
        int[] rightArray = mergeSort(array, mid + 1, end);
        int li = 0, ri = 0;
        int index = 0;
        while (index < tempArray.length) {
            if (li >= leftArray.length) {
                tempArray[index] = rightArray[ri++];
            } else if (ri >= rightArray.length) {
                tempArray[index] = leftArray[li++];
            } else {
                int rn = rightArray[ri];
                int ln = leftArray[li];
                if (ln <= rn) {
                    tempArray[index] = leftArray[li++];
                } else {
                    tempArray[index] = rightArray[ri++];
                }
            }

            index++;
        }

        for (int i = 0; i < tempArray.length; i++) {
            array[start + i] = tempArray[i];
        }

        return tempArray;
    }
}
