package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dimmy
 */
public class TwoCitySchedCost_1029 {

    /**
     * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
     * <p>
     * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：costs = [[10,20],[30,200],[400,50],[30,20]]
     * 输出：110
     * 解释：
     * 第一个人去 a 市，费用为 10。
     * 第二个人去 a 市，费用为 30。
     * 第三个人去 b 市，费用为 50。
     * 第四个人去 b 市，费用为 20。
     * <p>
     * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
     * 示例 2：
     * <p>
     * 输入：costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
     * 输出：1859
     * 示例 3：
     * <p>
     * 输入：costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
     * 输出：3086
     *
     * @param costs
     * @return 2 * n == costs.length
     * 2 <= costs.length <= 100
     * costs.length 为偶数
     * 1 <= aCosti, bCosti <= 1000
     */
    @MainParam
    int[][] costs = {{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}};

    @MainMethod
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> {
            var dif = Math.abs(o1[0] - o1[1]);
            var dif2 = Math.abs(o2[0] - o2[1]);
            return Integer.compare(dif, dif2);
        });
        var n = costs.length / 2;
        int a = 0, b = 0;
        int sum = 0;
        for (int i = costs.length - 1; i >= 0; i--) {
            int[] cost = costs[i];
            if (a == n) {
                sum += cost[1];
                b++;
                continue;
            }

            if (b == n) {
                sum += cost[0];
                a++;
                continue;
            }

            if (cost[0] < cost[1]) {
                sum += cost[0];
                a++;
            } else {
                sum += cost[1];
                b++;
            }
        }

        return sum;
    }

    public int twoCitySchedCostV2(int[][] costs) {
        // Sort by a gain which company has
        // by sending a person to city A and not to city B
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        int n = costs.length / 2;
        // To optimize the company expenses,
        // send the first n persons to the city A
        // and the others to the city B
        for (int i = 0; i < n; ++i) total += costs[i][0] + costs[i + n][1];
        return total;
    }

}
