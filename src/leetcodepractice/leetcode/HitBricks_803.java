package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class HitBricks_803 {
    /**
     * 有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
     * <p>
     * 一块砖直接连接到网格的顶部，或者
     * 至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
     * 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli) 位置上的砖块时，对应位置的砖块（若存在）会消失，
     * 然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
     * <p>
     * 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
     * <p>
     * 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
     * 输出：[2]
     * 解释：
     * 网格开始为：
     * [[1,0,0,0]，
     * [1,1,1,0]]
     * 消除 (1,0) 处加粗的砖块，得到网格：
     * [[1,0,0,0]
     * [0,1,1,0]]
     * 两个加粗的砖不再稳定，因为它们不再与顶部相连，也不再与另一个稳定的砖相邻，因此它们将掉落。得到网格：
     * [[1,0,0,0],
     * [0,0,0,0]]
     * 因此，结果为 [2] 。
     * 示例 2：
     * <p>
     * 输入：grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
     * 输出：[0,0]
     * 解释：
     * 网格开始为：
     * [[1,0,0,0],
     * [1,1,0,0]]
     * 消除 (1,1) 处加粗的砖块，得到网格：
     * [[1,0,0,0],
     * [1,0,0,0]]
     * 剩下的砖都很稳定，所以不会掉落。网格保持不变：
     * [[1,0,0,0],
     * [1,0,0,0]]
     * 接下来消除 (1,0) 处加粗的砖块，得到网格：
     * [[1,0,0,0],
     * [0,0,0,0]]
     * 剩下的砖块仍然是稳定的，所以不会有砖块掉落。
     * 因此，结果为 [0,0] 。
     *  
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * grid[i][j] 为 0 或 1
     * 1 <= hits.length <= 4 * 104
     * hits[i].length == 2
     * 0 <= xi <= m - 1
     * 0 <= yi <= n - 1
     * 所有 (xi, yi) 互不相同
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bricks-falling-when-hit
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @param hits
     * @return
     */
    int[][] globalGrid;
    int m, n;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        m = grid.length;
        n = grid[0].length;
        int[] result = new int[hits.length];
        globalGrid = grid;
        for (int k = 0; k < hits.length; k++) {
            int[] hit = hits[k];
            globalGrid[hit[0]][hit[1]] = 0;
            for (int i = 0; i < n; i++) {
                if (globalGrid[0][i] == 1) {
                    search(0, i);
                }
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (globalGrid[i][j] == 1) {
                        count++;
                        globalGrid[i][j] = 0;
                    }

                    if (globalGrid[i][j] == 2) {
                        globalGrid[i][j] = 1;
                    }
                }
            }

            result[k] = count;
        }

        return result;
    }

    private void search(int x, int y) {
        if (x >= m || x < 0 || y >= n || y < 0) return;
        if (globalGrid[x][y] == 0 || globalGrid[x][y] == 2) return;
        globalGrid[x][y] = 2;
        search(x + 1, y);
        search(x - 1, y);
        search(x, y + 1);
        search(x, y - 1);
    }
}
