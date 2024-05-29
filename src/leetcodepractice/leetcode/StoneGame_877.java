package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class StoneGame_877 {

    /**
     * Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
     * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
     * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
     * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。
     *
     * 示例 1：
     * 输入：piles = [5,3,4,5]
     * 输出：true
     * 解释：
     * Alice 先开始，只能拿前 5 颗或后 5 颗石子 。
     * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
     * 如果 Bob 拿走前 3 颗，那么剩下的是 [4,5]，Alice 拿走后 5 颗赢得 10 分。
     * 如果 Bob 拿走后 5 颗，那么剩下的是 [3,4]，Alice 拿走后 4 颗赢得 9 分。
     * 这表明，取前 5 颗石子对 Alice 来说是一个胜利的举动，所以返回 true 。
     *
     * 示例 2：
     * 输入：piles = [3,7,2,3]
     * 输出：true
     *  
     *
     * 提示：
     *
     * 2 <= piles.length <= 500
     * piles.length 是 偶数
     * 1 <= piles[i] <= 500
     * sum(piles[i]) 是 奇数
     *
     *
     * 方法一：动态规划
     * 由于每次只能从行的开始或结束处取走整堆石子，因此可以保证剩下的石子堆一定是连续的。
     *
     * 如果只剩下一堆石子，则当前玩家只能取走这堆石子。如果剩下多堆石子，则当前玩家可以选择从行的开始或结束处取走整堆石子，然后轮到另一个玩家在剩下的石子堆中取走石子。这是一个递归的过程，因此可以使用递归进行求解，递归过程中维护一个总数，表示 \text{Alice}Alice 和 \text{Bob}Bob 的石子数量之差，当游戏结束时，如果总数大于 00，则 \text{Alice}Alice 赢得比赛，否则 \text{Bob}Bob 赢得比赛。
     *
     * 如果有 nn 堆石子，则递归的时间复杂度为 O(2^n)O(2
     * n
     *  )，无法通过所有的测试用例。递归的时间复杂度高的原因是存在大量重复计算。由于存在重复子问题，因此可以使用动态规划降低时间复杂度。
     *
     * 定义二维数组 \textit{dp}dp，其行数和列数都等于石子的堆数，\textit{dp}[i][j]dp[i][j] 表示当剩下的石子堆为下标 ii 到下标 jj 时，即在下标范围 [i, j][i,j] 中，当前玩家与另一个玩家的石子数量之差的最大值，注意当前玩家不一定是先手 \text{Alice}Alice。
     *
     * 只有当 i \le ji≤j 时，剩下的石子堆才有意义，因此当 i>ji>j 时，\textit{dp}[i][j]=0dp[i][j]=0。
     *
     * 当 i=ji=j 时，只剩下一堆石子，当前玩家只能取走这堆石子，因此对于所有 0 \le i < \textit{nums}.\text{length}0≤i<nums.length，都有 \textit{dp}[i][i]=\textit{piles}[i]dp[i][i]=piles[i]。
     *
     * 当 i<ji<j 时，当前玩家可以选择取走 \textit{piles}[i]piles[i] 或 \textit{piles}[j]piles[j]，然后轮到另一个玩家在剩下的石子堆中取走石子。在两种方案中，当前玩家会选择最优的方案，使得自己的石子数量最大化。因此可以得到如下状态转移方程：
     *
     * \textit{dp}[i][j]=\max(\textit{piles}[i] - \textit{dp}[i+1][j], \textit{piles}[j] - \textit{dp}[i][j-1])
     * dp[i][j]=max(piles[i]−dp[i+1][j],piles[j]−dp[i][j−1])
     *
     * 最后判断 \textit{dp}[0][\textit{piles}.\text{length}-1]dp[0][piles.length−1] 的值，如果大于 00，则 \text{Alice}Alice 的石子数量大于 \text{Bob}Bob 的石子数量，因此 \text{Alice}Alice 赢得比赛，否则 \text{Bob}Bob 赢得比赛。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/stone-game/solution/shi-zi-you-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;

    }
}
