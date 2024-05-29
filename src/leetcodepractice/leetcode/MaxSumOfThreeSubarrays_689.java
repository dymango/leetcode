package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MaxSumOfThreeSubarrays_689 {

    /**
     * 给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。
     * <p>
     * 每个子数组的长度为k，我们要使这3*k个项的和最大化。
     * <p>
     * 返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,1,2,6,7,5,1], 2
     * 输出: [0, 3, 5]
     * 解释: 子数组 [1, 2], [2, 6], [7, 5] 对应的起始索引为 [0, 3, 5]。
     * 我们也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
     * 注意:
     * <p>
     * nums.length的范围在[1, 20000]之间。
     * nums[i]的范围在[1, 65535]之间。
     * k的范围在[1, floor(nums.length / 3)]之间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        //前i个值有j个数组的最大值
        //dp[i][j] = max(dp[i][j-1], dp[i-(0...k)][j-1])
        int[][] dp = new int[nums.length + 1][4];
        int[] sums = new int[nums.length + 1];
        sums[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        for (int j = 1; j < 4; j++) {
            for (int i = k; i <= nums.length; i++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - k][j - 1] + sums[i] - sums[i - k]);
            }
        }

        int[] ret = new int[3];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(dp[i][3], max);
        }

        for (int j = 3; j >= 1; j--) {
            for (int i = 1; i <= nums.length; i++) {
                if (dp[i][j] == max) {
                    ret[j - 1] = i - k;
                    max -= sums[i] - sums[i - k];
                }
            }
        }

        return ret;
    }

    private static int getDpValue(int[] sums, int i, int j) {
        return sums[j] - (i - 1 >= 0 ? sums[i - 1] : 0);
    }


    public static void main(String[] args) {
        maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2);
    }
}
