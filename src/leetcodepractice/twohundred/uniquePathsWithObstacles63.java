package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class uniquePathsWithObstacles63 {

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
    public static void main(String[] args) {
        new uniquePathsWithObstacles63().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 1, 0}});
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        var m = obstacleGrid.length;
        var n = obstacleGrid[0].length;
        int[][] steps = new int[m][n];
        steps[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                steps[i][j] = (i - 1 >= 0 ? steps[i - 1][j] : 0)
                    + (j - 1 >= 0 ? steps[i][j - 1] : 0);
            }
        }

        return steps[m - 1][n - 1];
    }
}
