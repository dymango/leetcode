package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MaxProfit_123 {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2：
     * <p>
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3：
     * <p>
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
     * 示例 4：
     * <p>
     * 输入：prices = [1]
     * 输出：0
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 105
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        int length = prices.length;
        int[] profits = new int[length];
        int lowestPrice = prices[0];
        for (int i = 1; i < length; i++) {
            lowestPrice = Math.min(lowestPrice, prices[i]);
            profits[i] = Math.max(profits[i - 1], prices[i] - lowestPrice);
            result = Math.max(profits[i], result);
        }

        int low = Integer.MAX_VALUE;
        int high = prices[length - 1];
        int max = high - low;
        for (int i = length - 2; i > 0; i--) {
            if (prices[i] < low) low = prices[i];
            max = Math.max(max, high - low);
            if (prices[i] > high) {
                high = prices[i];
                low = prices[i - 1];
            }

            result = Math.max(result, max + profits[i - 1]);
        }

        return result;
    }

    //Professional solution
    public int maxProfitV2(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]); //最低价
            sell1 = Math.max(sell1, buy1 + prices[i]); //利润
            buy2 = Math.max(buy2, sell1 - prices[i]); //第一次获利 - 第二次买入价格   10   4 = 6
            sell2 = Math.max(sell2, buy2 + prices[i]); // 6 + 7 = 13 
        }
        return sell2;
    }

    public static void main(String[] args) {
        new MaxProfit_123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
//        new MaxProfit_123().maxProfit(new int[]{7, 6, 4, 3, 1});
    }
}
