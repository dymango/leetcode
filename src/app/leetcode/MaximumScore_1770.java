package app.leetcode;

/**
 * @author dimmy
 */
public class MaximumScore_1770 {

    /**
     * 给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。
     * <p>
     * 初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要：
     * <p>
     * 选择数组 nums 开头处或者末尾处 的整数 x 。
     * 你获得 multipliers[i] * x 分，并累加到你的分数中。
     * 将 x 从数组 nums 中移除。
     * 在执行 m 步操作后，返回 最大 分数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3], multipliers = [3,2,1]
     * 输出：14
     * 解释：一种最优解决方案如下：
     * - 选择末尾处的整数 3 ，[1,2,3] ，得 3 * 3 = 9 分，累加到分数中。
     * - 选择末尾处的整数 2 ，[1,2] ，得 2 * 2 = 4 分，累加到分数中。
     * - 选择末尾处的整数 1 ，[1] ，得 1 * 1 = 1 分，累加到分数中。
     * 总分数为 9 + 4 + 1 = 14 。
     * 示例 2：
     * <p>
     * 输入：nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
     * 输出：102
     * 解释：一种最优解决方案如下：
     * - 选择开头处的整数 -5 ，[-5,-3,-3,-2,7,1] ，得 -5 * -10 = 50 分，累加到分数中。
     * - 选择开头处的整数 -3 ，[-3,-3,-2,7,1] ，得 -3 * -5 = 15 分，累加到分数中。
     * - 选择开头处的整数 -3 ，[-3,-2,7,1] ，得 -3 * 3 = -9 分，累加到分数中。
     * - 选择末尾处的整数 1 ，[-2,7,1] ，得 1 * 4 = 4 分，累加到分数中。
     * - 选择末尾处的整数 7 ，[-2,7] ，得 7 * 6 = 42 分，累加到分数中。
     * 总分数为 50 + 15 - 9 + 4 + 42 = 102 。
     *  
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * m == multipliers.length
     * 1 <= m <= 103
     * m <= n <= 105
     * -1000 <= nums[i], multipliers[i] <= 1000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-score-from-performing-multiplication-operations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param multipliers
     * @return
     */
    public static int maximumScore(int[] nums, int[] multipliers) {
        int l = multipliers.length;
        int[][] dp = new int[l + 1][l + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= l; i++) {
            for (int j = 0; j <= l - i; j++) {
                if (i == 0 && j == 0) continue;
                int mi = i + j - 1;
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + nums[nums.length - j] * multipliers[mi];
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + nums[i - 1] * multipliers[mi];
                    continue;
                }

                dp[i][j] = Math.max(dp[i][j - 1] + nums[nums.length - j] * multipliers[mi], dp[i - 1][j] + nums[i - 1] * multipliers[mi]);
                if (i + j == l) max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        maximumScore(new int[]{-854,-941,10,299,995,-346,294,-393,351,-76,210,897,-651,920,624,969,-629,985,-695,236,637,-901,-817,546,-69,192,-377,251,542,-316,-879,-764,-560,927,629,877,42,381,367,-549,602,139,-312,-281,105,690,-376,-705,-906,85,-608,639,752,770,-139,-601,341,61,969,276,176,-715,-545,471,-170,-126,596,-737,130},
            new int[]{83,315,-442,-714,461,920,-737,-93,-818,-760,558,-584,-358,-228,-220});
    }
}
