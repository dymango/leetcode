package leetcodepractice.twohundred;

public class maxProfit122 {

    /*
    给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

返回 你能获得的 最大 利润 。


     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] profits = new int[length][2];
        for (int i = 1; i < prices.length; i++) {
            profits[i][0] = Math.max(
                profits[i - 1][1] + Math.max(0, prices[i]- prices[i -1]),
                 profits[i -1][0]
                );

            profits[i][1] = Math.max(profits[i - 1][0],
                profits[i - 1][1] + Math.max(0, prices[i]- prices[i -1]));
        }

        return Math.max(profits[length - 1][0], profits[length - 1][1]);
    }
}
