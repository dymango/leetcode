package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MaxDotProduct_1458 {

    /**
     * 给你两个数组 nums1 和 nums2 。
     * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
     * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
     *
     * @param nums1
     * @param nums2
     * @return dp[n][m]
     * dp[n][m] = dp[n-1][m -1] + nums1[n] * nums2[m] / dp[n 1][m-1] / nums1[n]*any nums2[m!] + dp[n-1][m!-1]
     * <p>
     * [-1,-1]
     * nums2 =
     * [1,1]
     * <p>
     * <p>
     * [-5,-1,-2]
     * nums2 =
     * [3,3,5,5]
     *
     *
     *
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        var length1 = nums1.length;
        var length2 = nums2.length;
        int[][] dp = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0) dp[i][j] = Math.max(dp[i][j], dp[i][j] + dp[i - 1][j - 1]);
                if (j > 0) dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                if (i > 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }

        return dp[length1 - 1][length2 - 1];
    }

}
