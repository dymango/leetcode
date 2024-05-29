package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class merge_88 {
    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int length = m + n;
        int[] helper = new int[m];
        System.arraycopy(nums1, 0, helper, 0, m);
        int p1 = 0, p2 = 0;
        int index = 0;
        while (p1 < m && p2 < n) {
            if (helper[p1] < nums2[p2]) {
                nums1[index] = helper[p1];
                p1++;
            } else {
                nums1[index] = nums2[p2];
                p2++;
            }

            index++;
        }

        if (p1 < m) {
            for (int i = index; i < length; i++) {
                nums1[i] = helper[p1++];
            }
        }

        if (p2 < n) {
            for (int i = index; i < length; i++) {
                nums1[i] = nums2[p2++];
            }
        }

    }

    public static void main(String[] args) {
        new merge_88().merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }

    private void exchange(int[] nums, int i, int[] nums2, int j) {
        int t = nums[i];
        nums[i] = nums2[j];
        nums2[j] = t;
    }
}
