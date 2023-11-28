package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class minPathSum_64 {

    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int w = grid[0].length;
        int[][] sumArr = new int[r][w];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 && j == 0) {
                    sumArr[i][j] = grid[i][j];
                    continue;
                }

                sumArr[i][j] = Integer.MAX_VALUE;
                if (i - 1 >= 0) {
                    sumArr[i][j] = Math.min(sumArr[i - 1][j] + grid[i][j], sumArr[i][j]);
                }

                if (j - 1 >= 0) {
                    sumArr[i][j] = Math.min(sumArr[i][j - 1] + grid[i][j], sumArr[i][j]);
                }
            }
        }

        return sumArr[r - 1][w - 1];
    }
}
