package interview.prepare.ibmprepare;

/**
 * @author dimmy
 */
public class SearchUtil {
    public int binarySearch(int[] array, int num) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int n = array[mid];
            if (n == num) return mid;
            else if (n > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
