package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MaxProfit_714 {

    /**
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     *
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     *
     * 返回获得利润的最大值。
     *
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * 示例 1:
     * dp[i][j]
     *
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     * 注意:
     *
     * 0 < prices.length <= 50000.
     * 0 < prices[i] < 50000.
     * 0 <= fee < 50000.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
     * 定义状态 \textit{dp}[i][0]dp[i][0] 表示第 ii 天交易完后手里没有股票的最大利润，\textit{dp}[i][1]dp[i][1] 表示第 ii 天交易完后手里持有一支股票的最大利润（ii 从 00 开始）。
     *
     * 考虑 \textit{dp}[i][0]dp[i][0] 的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 \textit{dp}[i-1][0]dp[i−1][0]，或者前一天结束的时候手里持有一支股票，即 \textit{dp}[i-1][1]dp[i−1][1]，这时候我们要将其卖出，并获得 \textit{prices}[i]prices[i] 的收益，但需要支付 \textit{fee}fee 的手续费。因此为了收益最大化，我们列出如下的转移方程：
     *
     * \textit{dp}[i][0]=\max\{\textit{dp}[i-1][0],\textit{dp}[i-1][1]+\textit{prices}[i]-\textit{fee}\}
     * dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]−fee}
     *
     * 再来按照同样的方式考虑 \textit{dp}[i][1]dp[i][1] 按状态转移，那么可能的转移状态为前一天已经持有一支股票，即 \textit{dp}[i-1][1]dp[i−1][1]，或者前一天结束时还没有股票，即 \textit{dp}[i-1][0]dp[i−1][0]，这时候我们要将其买入，并减少 \textit{prices}[i]prices[i] 的收益。可以列出如下的转移方程：
     *
     * \textit{dp}[i][1]=\max\{\textit{dp}[i-1][1],\textit{dp}[i-1][0]-\textit{prices}[i]\}
     * dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
     *
     * 对于初始状态，根据状态定义我们可以知道第 00 天交易结束的时候有 \textit{dp}[0][0]=0dp[0][0]=0 以及 \textit{dp}[0][1]=-\textit{prices}[0]dp[0][1]=−prices[0]。
     *
     * 因此，我们只要从前往后依次计算状态即可。由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，因此这时候 \textit{dp}[n-1][0]dp[n−1][0] 的收益必然是大于 \textit{dp}[n-1][1]dp[n−1][1] 的，最后的答案即为 \textit{dp}[n-1][0]dp[n−1][0]。
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] =-prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
