package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class Change_518 {

    /**
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
     *
     * 示例 1:
     *
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     * 示例 2:
     *
     * 输入: amount = 3, coins = [2]
     * 输出: 0
     * 解释: 只用面额2的硬币不能凑成总金额3。
     * 示例 3:
     *
     * 输入: amount = 10, coins = [10]
     * 输出: 1
     *  
     *
     * 注意:
     *
     * 你可以假设：
     *
     * 0 <= amount (总金额) <= 5000
     * 1 <= coin (硬币面额) <= 5000
     * 硬币种类不超过 500 种
     * 结果符合 32 位符号整数
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change-2
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param amount
     * @param coins
     * @return
     */
    public static int change(int amount, int[] coins) {
        /**
         * dp[i] 表示 amount为i有几种拼法  dp[i] = dp[1]*dp[i - 1] + dp[2]*dp[i - 2]
         * dp[4] = dp[1]*dp[3] + 2
         * dp[i][j]表示前i种金币组成j金额的组合数
         * dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]
         */

//        int[][] dp = new int[coinNum + 1][amount + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i <= coinNum; i++) {
//            for (int j = 0; j < amount + 1; j++) {
//                for (int k = 0; k * coins[i - 1] <= j; k++) {
//                    dp[i][j] += dp[i-1][j - k * coins[i - 1]];
//                }
//            }
//        }
        int coinNum = coins.length;
        int[] dp2 = new int[amount + 1];
        dp2[0] = 1;
        for (int i = 0; i < coinNum; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp2[j] += dp2[j - coins[i]];
            }
        }

        return dp2[amount];
    }

    public static void main(String[] args) {
//        System.out.println(change(10, new int[]{10}));
        System.out.println(change(5, new int[]{1,2,5}));
    }
}
