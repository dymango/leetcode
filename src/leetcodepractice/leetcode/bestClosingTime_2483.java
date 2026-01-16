package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class bestClosingTime_2483 {

    /**
     * 给你一个顾客访问商店的日志，用一个下标从 0 开始且只包含字符 'N' 和 'Y' 的字符串 customers 表示：
     * <p>
     * 如果第 i 个字符是 'Y' ，它表示第 i 小时有顾客到达。
     * 如果第 i 个字符是 'N' ，它表示第 i 小时没有顾客到达。
     * 如果商店在第 j 小时关门（0 <= j <= n），代价按如下方式计算：
     * <p>
     * 在开门期间，如果某一个小时没有顾客到达，代价增加 1 。
     * 在关门期间，如果某一个小时有顾客到达，代价增加 1 。
     * 请你返回在确保代价 最小 的前提下，商店的 最早 关门时间。
     *
     * t(j) = v(j) + v(n)
     * <p>
     * 注意，商店在第 j 小时关门表示在第 j 小时以及之后商店处于关门状态。
     *
     * @param customers
     * @return
     */
    public int bestClosingTime(String customers) {
        var length = customers.length();
        var left = new int[length];
        var right = new int[length];
        var charArray = customers.toCharArray();
        int yc = 0;
        int nc = 0;
        for (int i = 0; i < length; i++) {
            if (charArray[i] == 'N') {
                if (i > 0) left[i] = left[i - 1] + 1;
                else left[i] = 1;
                nc++;
            } else {
                yc++;
                left[i] = i > 0 ? left[i - 1] : 0;
            }
        }

        int min = left[length - 1];
        int closeTime = length;

        for (int i = length - 1; i >= 0; i--) {
            if (charArray[i] == 'Y') {
                if (i == length - 1) {
                    right[i] = 1;
                } else {
                    right[i] = right[i + 1] + 1;
                }
            } else {
                right[i] = i < length - 1 ? right[i + 1] : 0;
            }

            var sum = (i > 0 ? left[i - 1] : 0) + right[i];
            if (sum <= min) {
                min = sum;
                closeTime = i;
            }
        }

        if (nc < min) return length;
        return closeTime;
    }

    //yyynnyyyyyyyy -10 nnnn

    //nnnn
    //
    public int bestClosingTimeV2(String customers) {
        int n = customers.length();
        int profit = 0;
        int position = 0;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                profit++;
            } else {
                profit--;
            }

            if (profit > maxProfit) {
                maxProfit = profit;
                position = i + 1;
            }
        }

        return position;
    }
}
