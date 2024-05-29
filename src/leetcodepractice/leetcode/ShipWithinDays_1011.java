package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

/**
 * @author dimmy
 */
public class ShipWithinDays_1011 {

    /**
     * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
     * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
     * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
     * <p>
     * 分析： 定义为规划问题，第n天要传送前f个包裹，船的最大装载重量为max
     * 定义数组[n][f] = max
     * <p>
     * <p>
     * 示例 1：
     * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
     * 输出：15
     * 解释：
     * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
     * 第 1 天：1, 2, 3, 4, 5
     * 第 2 天：6, 7
     * 第 3 天：8
     * 第 4 天：9
     * 第 5 天：10
     * <p>
     * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
     * 示例 2：
     * <p>
     * 输入：weights = [3,2,2,4,1,4], days = 3
     * 输出：6
     * 解释：
     * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
     * 第 1 天：3, 2
     * 第 2 天：2, 4
     * 第 3 天：1, 4
     * 示例 3：
     * <p>
     * 输入：weights = [1,2,3,1,1], days = 4
     * 输出：3
     * 解释：
     * 第 1 天：1
     * 第 2 天：2
     * 第 3 天：3
     * 第 4 天：1, 1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= days <= weights.length <= 5 * 104
     * 1 <= weights[i] <= 500
     *
     * @param weights
     * @param days
     * @return
     */
    @MainParam
    int[] weights = {70,259,379,369,287,145,259,29,150,410,493,121,184,92,79,168,269,209,139,437};
    @MainParam
    int days = 20;
    //10 10 80 10 90
    // 80
    @MainMethod
    public int shipWithinDays(int[] weights, int days) {
        int wl = weights.length;
        int[] sums = new int[wl];
        int[] max = new int[wl];
        sums[0] = weights[0];
        max[0] = weights[0];
        for (int i = 1; i < weights.length; i++) {
            sums[i] = sums[i - 1] + weights[i];
            max[i] = Math.max(weights[i], max[i - 1]);
        }

        int[] plans = sums;

        for (int i = 1; i < days; i++) {
            int[] newPlans = new int[wl];
            for (int j = i; j < wl; j++) {
                if (i == j) newPlans[j] = max[j];
                else newPlans[j] = Math.max(weights[j], plans[j - 1]);
                for (int k = j - 1; k >= 0; k--) {
                    int temp = sums[j] - sums[k];
                    newPlans[j] = Math.min(newPlans[j], Math.max(temp, i - 1 <= k ? plans[k] : max[k]));
                }
            }

            plans = newPlans;
        }

        return plans[wl - 1];
    }
}
