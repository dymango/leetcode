package leetcodepractice.tencent;

/**
 * @author dimmy
 */
public class UniquePaths_62 {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：m = 3, n = 7
     * 输出：28
     * 示例 2：
     * <p>
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     * 示例 3：
     * <p>
     * 输入：m = 7, n = 3
     * 输出：28
     * 示例 4：
     * <p>
     * 输入：m = 3, n = 3
     * 输出：6
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= m, n <= 100
     * 题目数据保证答案小于等于 2 * 109
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param m
     * @param n
     * @return
     */
    int M, N;
    int[][] cache;
    public int uniquePaths(int m, int n) {
        M = m;
        N = n;
        cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cache[i][j] = -1;
            }
        }
        return recursion(0, 0);
    }

    private int recursion(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1;
        if (x >= M || y >= N) return 0;
        if(cache[x][y] != -1) return cache[x][y];
        int i = recursion(x + 1, y) + recursion(x, y + 1);
        cache[x][y] = i;
        return i;
    }
}
