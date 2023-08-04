package app.leetcode;

/**
 * @author dimmy
 */
public class UniquePathsWithObstacles_63 {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：obstacleGrid = [[0,0,0],
     * [0,1,0],
     * [0,0,0]]
     * 输出：2
     * 解释：3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * 示例 2：
     * <p>
     * <p>
     * 输入：obstacleGrid = [[0,1],[0,0]]
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * m == obstacleGrid.length
     * n == obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] 为 0 或 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/unique-paths-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param obstacleGrid
     * @return
     */
    int[][] cache;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cache[i][j] = -1;
            }
        }

        return count(row - 1, col - 1, obstacleGrid);
    }

    private int count(int x, int y, int[][] obstacleGrid) {
        if (x < 0 || y < 0 || obstacleGrid[x][y] == 1) return 0;
        if (x == 0 && y == 0) return 1;
        if (cache[x][y] != -1) return cache[x][y];
        int count = count(x, y - 1, obstacleGrid) + count(x - 1, y, obstacleGrid);
        cache[x][y] = count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsWithObstacles_63().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}

