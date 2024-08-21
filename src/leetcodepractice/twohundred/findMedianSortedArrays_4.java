package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class findMedianSortedArrays_4 {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 算法的时间复杂度应该为 O(log (m+n)) 。1
     * 1234
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int left = sum % 2 == 0 ? sum / 2 - 1 : sum / 2;
        int a = 0;
        int b = 0;
        while (left != 0) {
            if (a >= nums1.length) {
                b++;
            } else if (b >= nums2.length) {
                a++;
            } else {
                if (nums1[a] < nums2[b]) {
                    a++;
                } else {
                    b++;
                }
            }

            left--;
        }

        if (sum % 2 != 0) {
            if (a >= nums1.length) return nums2[b];
            if (b >= nums2.length) return nums1[a];
            return Integer.min(nums1[a], nums2[b]);
        }

        double min = Double.MAX_VALUE;
        if (a < nums1.length - 1) {
            min = Math.min(min, (double)(nums1[a] + nums1[a + 1])/2);
        }

        if (b < nums2.length - 1) {
            min = Math.min(min, (double) (nums2[b] + nums2[b + 1])/2);
        }

        if (a < nums1.length && b < nums2.length) {
            min = Math.min(min, (double) (nums1[a] + nums2[b]) / 2);
        }

        return min;
    }
}
