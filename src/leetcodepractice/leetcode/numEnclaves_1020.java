package leetcodepractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class numEnclaves_1020 {

    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
     * <p>
     * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
     * <p>
     * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
     *
     *
     * @param grid
     * @return
     */
    int sum = 0;

    public int numEnclaves(int[][] grid) {
        var x = grid.length;
        var y = grid[0].length;
        boolean[][] visit = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || i == x - 1 || j == 0 || j == y - 1) {
                    search(grid, i, j, visit, x, y);
                    continue;
                }

                if (grid[i][j] == 0 && !visit[i][j]) {
                    visit[i][j] = true;
                    sum++;
                }
            }
        }

        return x * y - sum;
    }

    private void search(int[][] grid, int i, int j, boolean[][] visit, int x, int y) {
        if (visit[i][j]) return;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            var size = q.size();
            for (int k = 0; k < size; k++) {
                var poll = q.poll();
                var tx = poll[0];
                var ty = poll[1];
                if (tx < 0 || tx >= x || ty < 0 || ty >= y || visit[tx][ty]) continue;
                if (grid[tx][ty] == 0) {
                    sum++;
                    visit[tx][ty] = true;
                    continue;
                }

                visit[tx][ty] = true;
                sum++;
                q.add(new int[]{tx + 1, ty});
                q.add(new int[]{tx, ty + 1});
                q.add(new int[]{tx - 1, ty});
                q.add(new int[]{tx, ty - 1});
            }
        }
    }
}
