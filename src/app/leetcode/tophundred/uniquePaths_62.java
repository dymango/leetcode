package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class uniquePaths_62 {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     * <p>
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
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= m, n <= 100
     * 题目数据保证答案小于等于 2 * 109
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] stepArr = new int[m][n];
        stepArr[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                stepArr[i][j] = 0;
                if (i > 0) {
                    stepArr[i][j] += stepArr[i - 1][j];
                }

                if (j > 0) {
                    stepArr[i][j] += stepArr[i][j - 1];
                }
            }
        }

        return stepArr[m - 1][n - 1];
    }
}
