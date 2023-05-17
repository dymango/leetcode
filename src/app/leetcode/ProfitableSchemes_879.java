package app.leetcode;

import app.leetcode.base.StopWatch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author dimmy
 */
public class ProfitableSchemes_879 {

    /**
     * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
     * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
     * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
     * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
     * 输出：2
     * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
     * 总的来说，有两种计划。
     * 示例 2：
     * <p>
     * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
     * 输出：7
     * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
     * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 100
     * 0 <= minProfit <= 100
     * 1 <= group.length <= 100
     * 1 <= group[i] <= 100
     * profit.length == group.length
     * 0 <= profit[i] <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/profitable-schemes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param minProfit
     * @param group
     * @param profit
     * @return 方法一：动态规划
     * 本题与经典背包问题非常相似。两者不同点在于经典背包问题只有一种容量限制，而本题却有两种限制：集团员工人数上限 nn，以及工作产生的利润下限 \textit{minProfit}minProfit。
     * <p>
     * 通过经典背包问题的练习，我们已知经典背包问题可以使用二维动态规划求解：两个维度分别代表物品和容量的限制标准。对于本题上述的两种限制，我们可以想到使用三维动态规划求解。本题解法的三个维度分别为：当前可选择的工作，已选择的小组员工人数，以及目前状态的工作获利下限。
     * <p>
     * 根据上述分析，我们可以定义一个三维数组 \textit{dp}dp 作为动态规划的状态，其中 \textit{dp}[i][j][k]dp[i][j][k] 表示在前 ii 个工作中选择了 jj 个员工，并且满足工作利润至少为 kk 的情况下的盈利计划的总数目。假设 \textit{group}group 数组长度为 \textit{len}len，那么不考虑取模运算的情况下，最终答案为：
     * <p>
     * \sum_{i=0}^{n}\textit{dp}[\textit{len}][i][\textit{minProfit}]
     * i=0
     * ∑
     * n
     * ​
     * dp[len][i][minProfit]
     * <p>
     * 所以我们可以新建一个三维数组 \textit{dp}[\textit{len} + 1][n + 1][\textit{minProfit} + 1]dp[len+1][n+1][minProfit+1]，初始化 \textit{dp}[0][0][0] = 1dp[0][0][0]=1。接下来分析状态转移方程，对于每个工作 ii，我们根据当前工作人数上限 jj，有能够开展当前工作和无法开展当前工作两种情况：
     * <p>
     * 如果无法开展当前工作 ii，那么显然：
     * <p>
     * \textit{dp}[i][j][k] = \textit{dp}[i - 1][j][k]
     * dp[i][j][k]=dp[i−1][j][k]
     * <p>
     * 如果能够开展当前工作 ii，设当前小组人数为 \textit{group}[i]group[i]，工作获利为 \textit{profit}[i]profit[i]，那么不考虑取模运算的情况下，则有：
     * <p>
     * \textit{dp}[i][j][k] = \textit{dp}[i - 1][j][k] + \textit{dp}[i - 1][j - \textit{group}[i]][\max(0, k - \textit{profit}[i])]
     * dp[i][j][k]=dp[i−1][j][k]+dp[i−1][j−group[i]][max(0,k−profit[i])]
     * <p>
     * 由于我们定义的第三维是工作利润至少为 kk 而不是 工作利润恰好为 kk，因此上述状态转移方程中右侧的第三维是 \max(0, k - \textit{profit}[i])max(0,k−profit[i]) 而不是 k - \textit{profit}[i]k−profit[i]。读者可以思考这一步的妙处所在。
     * <p>
     * 根据上述思路，参考代码如下：
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/profitable-schemes/solution/ying-li-ji-hua-by-leetcode-solution-3t8o/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    int N;
    int MIN_PROFIT;
    int[] g;
    int[] p;
    List<Node> nodes;
    int count = 0;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        StopWatch stopWatch = new StopWatch();
        N = n;
        MIN_PROFIT = minProfit;
        g = group;
        p = profit;
        nodes = new ArrayList<>();
        for (int i = 0; i < group.length; i++) {
            nodes.add(new Node(group[i], profit[i]));
        }

        nodes.sort(Comparator.comparingInt(o -> o.people));

        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (node.profit >= minProfit && node.people <= n) count = (count + 1) % 1000000007;
            backTracking(node.profit, node.people, i + 1);
        }
        System.out.println(stopWatch.elapsed());
        return minProfit == 0 ? count + 1 : count;
    }

    private void backTracking(int profit, int people, int index) {
        if (index >= nodes.size()) return;
        Node node = nodes.get(index);
        int totalProfit = node.profit + profit;
        int totalPeople = node.people + people;
        if (totalPeople > N) return;
        if (totalProfit >= MIN_PROFIT) {
            count = (count + 1) % 1000000007;
        }
        backTracking(totalProfit, totalPeople, index + 1);
        backTracking(profit, people, index + 1);
    }


    static class Node {
        public int people;
        public int profit;

        public Node(int people, int profit) {
            this.people = people;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new ProfitableSchemes_879().profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
        //64
        //0
        //[80, 40]
        //1
        //1
        //[2,2,2,2,2,2,1,2,1,1,2,1,2,2,2,1,2,1,1,2,1,2,1,2,2,2,2,1,1,2,2,2,1,1,2,1,2,2,2,1,2,2,2,2,1,2,2,1,2,2,1,1,1,1,1,1,2,2,2,2,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,2,2,1,1,2,2,2,1,1,2,2,1,1,2,2,1,2,2,1,1,2,2,2,2,2]
        //[2,1,2,2,2,1,0,1,2,0,0,2,2,1,1,1,2,0,1,1,2,0,2,2,1,0,1,0,1,2,2,1,1,2,0,2,1,1,1,1,1,2,0,1,0,2,2,2,2,2,0,1,1,2,1,0,1,0,0,2,1,0,2,0,2,1,1,1,0,1,0,1,2,2,0,1,1,2,2,0,1,0,0,1,1,2,2,2,2,1,0,0,1,2,1,1,1,1,0,1]
        //[88, 88]
        //100
        //10
        //[66,24,53,49,86,37,4,70,99,68,14,91,70,71,70,98,48,26,13,86,4,82,1,7,51,37,27,87,2,65,93,66,99,28,17,93,83,91,45,3,59,87,92,62,77,21,9,37,11,4,69,46,70,47,28,40,74,47,12,3,85,16,91,100,39,24,52,50,40,23,64,22,2,15,18,62,26,76,3,60,64,34,45,40,49,11,5,8,40,71,12,60,3,51,31,5,42,52,15,36]
        //[8,4,8,8,9,3,1,6,7,10,1,10,4,9,7,11,5,1,7,4,11,1,5,9,9,5,1,10,0,10,4,1,1,1,6,9,3,6,2,5,4,7,8,5,2,3,0,6,4,5,9,9,10,7,1,8,9,6,0,2,9,2,2,8,6,10,3,4,6,1,10,7,5,4,8,1,8,5,5,4,1,1,10,0,8,0,1,11,5,4,7,9,1,11,1,0,1,6,8,3]
        System.out.println(new ProfitableSchemes_879().profitableSchemes(100, 10, new int[]{66, 24, 53, 49, 86, 37, 4, 70, 99, 68, 14, 91, 70, 71, 70, 98, 48, 26, 13, 86, 4, 82, 1, 7, 51, 37, 27, 87, 2, 65, 93, 66, 99, 28, 17, 93, 83, 91, 45, 3, 59, 87, 92, 62, 77, 21, 9, 37, 11, 4, 69, 46, 70, 47, 28, 40, 74, 47, 12, 3, 85, 16, 91, 100, 39, 24, 52, 50, 40, 23, 64, 22, 2, 15, 18, 62, 26, 76, 3, 60, 64, 34, 45, 40, 49, 11, 5, 8, 40, 71, 12, 60, 3, 51, 31, 5, 42, 52, 15, 36}, new int[]{8, 4, 8, 8, 9, 3, 1, 6, 7, 10, 1, 10, 4, 9, 7, 11, 5, 1, 7, 4, 11, 1, 5, 9, 9, 5, 1, 10, 0, 10, 4, 1, 1, 1, 6, 9, 3, 6, 2, 5, 4, 7, 8, 5, 2, 3, 0, 6, 4, 5, 9, 9, 10, 7, 1, 8, 9, 6, 0, 2, 9, 2, 2, 8, 6, 10, 3, 4, 6, 1, 10, 7, 5, 4, 8, 1, 8, 5, 5, 4, 1, 1, 10, 0, 8, 0, 1, 11, 5, 4, 7, 9, 1, 11, 1, 0, 1, 6, 8, 3}));
//        System.out.println(new ProfitableSchemes_879().profitableSchemes(1, 1, new int[]{2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 2, 1, 2, 2, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 1, 0, 1, 2, 0, 0, 2, 2, 1, 1, 1, 2, 0, 1, 1, 2, 0, 2, 2, 1, 0, 1, 0, 1, 2, 2, 1, 1, 2, 0, 2, 1, 1, 1, 1, 1, 2, 0, 1, 0, 2, 2, 2, 2, 2, 0, 1, 1, 2, 1, 0, 1, 0, 0, 2, 1, 0, 2, 0, 2, 1, 1, 1, 0, 1, 0, 1, 2, 2, 0, 1, 1, 2, 2, 0, 1, 0, 0, 1, 1, 2, 2, 2, 2, 1, 0, 0, 1, 2, 1, 1, 1, 1, 0, 1}));
//        System.out.println(new ProfitableSchemes_879().profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
//        System.out.println(new ProfitableSchemes_879().profitableSchemes(64, 0, new int[]{80, 40}, new int[]{88, 88}));
    }

    public int profitableSchemesV2(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        int len = group.length, MOD = (int) 1e9 + 7;
        for (int i = 1; i <= len; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }
}
