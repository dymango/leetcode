package app.sort;

/**
 * @author dimmy
 */
public class QS {

    public void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int index = split(nums, start, end);
        sort(nums, start, index - 1);
        sort(nums, index + 1, end);
    }

    private int split(int[] nums, int start, int end) {
        if (start >= end) return -1;
        int main = start;
        start += 1;
        while (start < end) {
            while (start < nums.length && nums[start] <= nums[main]) start++;
            while (end >= 0 && nums[end] > nums[main]) end--;
            if (start > end) break;
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }

        int t = nums[end];
        nums[end] = nums[main];
        nums[main] = t;
        return end;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 8, 9, 2, 5, 0, 2, 4};
        new QS().sort(a, 0, a.length - 1);
        int i = 1;
    }
}
