package leetcodepractice.leetcode;

import leetcodepractice.core.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class colorBorder_1034 {

    /**
     * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
     * 如果两个方块在任意 4 个方向上相邻，则称它们 相邻 。
     * 如果两个方块具有相同的颜色且相邻，它们则属于同一个 连通分量 。
     * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
     * 在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻
     * 在网格的边界上（第一行/列或最后一行/列）
     * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色。
     * 并返回最终的网格 grid 。
     *
     *示例 1：
     *
     * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
     * 输出：[[3,3],[3,2]]
     * 示例 2：
     *
     * 输入：grid = [[1,2,2],
     *              [2,3,2]], row = 0, col = 1, color = 3
     * 输出：[[1,3,3],[2,3,3]]
     * 示例 3：
     *
     * 输入：grid = [[1,1,1],
     *              [1,1,1],
     *              [1,1,1]], row = 1, col = 1, color = 2
     * 输出：[[2,2,2],[2,1,2],[2,2,2]]
     *
     * @param grid
     * @param row
     * @param col
     * @param color
     * @return
     *
     * 此题与搜索的经典题「200. 岛屿数量」较为类似，常规的思路是可以使用深度优先搜索或者广度优先搜索来寻找出位置 (row,col) 的所在的连通分量，额外要做的是搜索的时候需要判断当前的点是否属于边界。如果属于边界，需要把该点加入到一个用来存所有边界点的数组中。当搜索完毕后，再将所有边界点的进行着色。
     *
     */
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> borders = new ArrayList<>();
        int originalColor = grid[row][col];
        visited[row][col] = true;
        dfs(grid, row, col, visited, borders, originalColor);
        for (int i = 0; i < borders.size(); i++) {
            int x = borders.get(i)[0], y = borders.get(i)[1];
            grid[x][y] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited, List<int[]> borders, int originalColor) {
        int m = grid.length, n = grid[0].length;
        boolean isBorder = false;
        int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int nx = direc[i][0] + x, ny = direc[i][1] + y;
            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                isBorder = true;
            } else if (!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(grid, nx, ny, visited, borders, originalColor);
            }
        }
        if (isBorder) {
            borders.add(new int[]{x, y});
        }
    }

}
