package app.leetcode;

/**
 * @author dimmy
 */
public class SurfaceArea_892 {
    /**
     * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
     * <p>
     * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
     * <p>
     * 请你返回最终这些形体的总表面积。
     * <p>
     * 注意：每个形体的底面也需要计入表面积中。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：grid = [[1,2],[3,4]]
     * 输出：34
     * 示例 2：
     * <p>
     * <p>
     * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：32
     * 示例 3：
     * <p>
     * <p>
     * 输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
     * 输出：46
     *  
     * <p>
     * 提示：
     * <p>
     * n == grid.length
     * n == grid[i].length
     * 1 <= n <= 50
     * 0 <= grid[i][j] <= 50
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/surface-area-of-3d-shapes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) sum += 2;
                max = Math.max(max, grid[i][j]);
            }

            sum += (2 * max);
        }

        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }

            sum += (2 * max);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (leftValid(i, j, grid) && rightValid(i, j, grid)) {
                    if (grid[i][j + 1] > grid[i][j]) sum += grid[i][j + 1] - grid[i][j];
                    if (grid[i][j - 1] > grid[i][j]) sum += grid[i][j - 1] - grid[i][j];
                }
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (upValid(j, i, grid) && downValid(j, i, grid)) {
                    if (grid[j + 1][i] > grid[j][i]) sum += grid[j + 1][i] - grid[j][i];
                    if (grid[j - 1][i] > grid[j][i]) sum += grid[j - 1][i] - grid[j][i];
                }
            }
        }

        return sum;
    }

    private boolean upValid(int i, int j, int[][] grid) {
        int t = --i;
        if (t < 0) return false;
        while (t >= 0) {
            if (grid[t][j] > 0) return true;
            t--;
        }
        return false;
    }

    private boolean downValid(int i, int j, int[][] grid) {
        int t = ++i;
        if (t >= grid.length) return false;
        while (t < grid.length) {
            if (grid[t][j] > 0) return true;
            t++;
        }
        return false;
    }


    private boolean leftValid(int i, int j, int[][] grid) {
        int t = --j;
        if (t < 0) return false;
        while (t >= 0) {
            if (grid[i][t] > 0) return true;
            t--;
        }
        return false;
    }

    private boolean rightValid(int i, int j, int[][] grid) {
        int t = ++j;
        if (t >= grid[0].length) return false;
        while (t < grid[0].length) {
            if (grid[i][t] > 0) return true;
            t++;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new SurfaceArea_892().surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(new SurfaceArea_892().surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        System.out.println(new SurfaceArea_892().surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
