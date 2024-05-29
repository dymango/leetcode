package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class uniquePathsWithObstacles_63 {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] stepArr = new int[m][n];
        stepArr[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) continue;
                stepArr[i][j] = 0;
                if (i > 0 && obstacleGrid[i - 1][j] != 1) {
                    stepArr[i][j] += stepArr[i - 1][j];
                }

                if (j > 0 && obstacleGrid[i][j - 1] != 1) {
                    stepArr[i][j] += stepArr[i][j - 1];
                }
            }
        }

        stepArr[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        return stepArr[m - 1][n - 1];
    }
}
