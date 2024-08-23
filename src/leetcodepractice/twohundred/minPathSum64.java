package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class minPathSum64 {

    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     *
     * @param grid
     * @return
     */
    public static void main(String[] args) {
        new minPathSum64().minPathSum(new int[][]{{1,2}, {1,1}});
    }

    public int minPathSum(int[][] grid) {
        var row = grid.length;
        var col = grid[0].length;
        int[][] sum = new int[row][col];
        sum[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) continue;
                if (i >= 1 && j >= 1) {
                    sum[i][j] = Math.min(
                        grid[i][j] + sum[i - 1][j],
                        grid[i][j] + sum[i][j - 1]
                    );
                } else if (i - 1 >= 0) {
                    sum[i][j] = grid[i][j] + sum[i - 1][j];
                } else {
                    sum[i][j] = grid[i][j] + sum[i][j - 1];
                }
            }
        }

        return sum[row - 1][col - 1];
    }
}
