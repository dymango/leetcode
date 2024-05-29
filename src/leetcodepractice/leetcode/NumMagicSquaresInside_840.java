package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class NumMagicSquaresInside_840 {

    /**
     * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
     * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
     * <p>
     * [[5,5,5],
     * [5,5,5],
     * [5,5,5]]
     *  
     * <p>
     * 示例：
     * <p>
     * 输入: [[4,3,8,4],
     * [9,5,1,9],
     * [2,7,6,2]]
     * 输出: 1
     * 解释:
     * 下面的子矩阵是一个 3 x 3 的幻方：
     * 438
     * 951
     * 276
     * <p>
     * 而这一个不是：
     * 384
     * 519
     * 762
     * <p>
     * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
     * 提示:
     * <p>
     * 1 <= grid.length <= 10
     * 1 <= grid[0].length <= 10
     * 0 <= grid[i][j] <= 15
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/magic-squares-in-grid
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (check(grid, i, j)) count++;
            }
        }

        return count;
    }

    private boolean check(int[][] grid, int x, int y) {
        boolean[] record = new boolean[16];
        record[grid[x - 1][y]] = true;
        record[grid[x][y]] = true;
        record[grid[x + 1][y]] = true;
        record[grid[x][y - 1]] = true;
        record[grid[x][y + 1]] = true;
        record[grid[x + 1][y + 1]] = true;
        record[grid[x + 1][y - 1]] = true;
        record[grid[x - 1][y + 1]] = true;
        record[grid[x - 1][y - 1]] = true;
        for (int i = 1; i <= 9; i++) {
            if (!record[i]) return false;
        }

        if (x - 1 < 0 || x + 1 >= grid.length || y - 1 < 0 || y + 1 >= grid[0].length) return false;
        int v = grid[x - 1][y - 1] + grid[x - 1][y] + grid[x - 1][y + 1];
        int v2 = grid[x][y - 1] + grid[x][y] + grid[x][y + 1];
        if (v2 != v) return false;
        int v3 = grid[x + 1][y - 1] + grid[x + 1][y] + grid[x + 1][y + 1];
        if (v3 != v) return false;
        int v4 = grid[x - 1][y - 1] + grid[x][y - 1] + grid[x + 1][y - 1];
        if (v4 != v) return false;
        int v5 = grid[x - 1][y] + grid[x][y] + grid[x + 1][y];
        if (v5 != v) return false;
        int v6 = grid[x - 1][y + 1] + grid[x][y + 1] + grid[x + 1][y + 1];
        if (v6 != v) return false;
        int v7 = grid[x - 1][y - 1] + grid[x][y] + grid[x + 1][y + 1];
        if (v7 != v) return false;
        int v8 = grid[x - 1][y + 1] + grid[x][y] + grid[x + 1][y - 1];
        if (v8 != v) return false;
        return true;
    }
}
