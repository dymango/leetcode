package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class nextPermutation_31 {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        boolean find = false;
        tag:
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int s = i;
                int k = i + 1;
                for (int j = length - 1; j >= k; j--) {
                    if (nums[j] > nums[s]) {
                        int t = nums[s];
                        nums[s] = nums[j];
                        nums[j] = t;
                        reverse(nums, k, length - 1);
                        find = true;
                        break tag;
                    }
                }
            }
        }

        if (!find) reverse(nums, 0, length - 1);
        int z = 1;
    }

    private void reverse(int[] a, int i, int j) {
        while (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        new nextPermutation_31().nextPermutation(new int[]{1, 2, 3, 4, 6,5});
    }
}
