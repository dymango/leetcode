package leetcodepractice.leetcode;

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
        int col = grid[0].length;
        int row = grid.length;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) continue;
                sum += 2;
                sum += i - 1 < 0 ? grid[i][j] : Math.max(grid[i][j] - grid[i - 1][j], 0);
                sum += i + 1 >= row ? grid[i][j] : Math.max(grid[i][j] - grid[i + 1][j], 0);
                sum += j - 1 < 0 ? grid[i][j] : Math.max(grid[i][j] - grid[i][j - 1], 0);
                sum += j + 1 >= col ? grid[i][j] : Math.max(grid[i][j] - grid[i][j + 1], 0);
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new SurfaceArea_892().surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(new SurfaceArea_892().surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        System.out.println(new SurfaceArea_892().surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
