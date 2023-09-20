package app.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class NumIslands_200 {

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 输出：3
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] || grid[i][j] != '1') continue;
                count++;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y] && grid[x][y] == '1') {
                            visited[poll[0]][poll[1]] = true;
                            queue.add(new int[]{x - 1, y});
                            queue.add(new int[]{x, y - 1});
                            queue.add(new int[]{x, y + 1});
                            queue.add(new int[]{x + 1, y});
                        }
                    }
                }
            }
        }

        return count;
    }
}
