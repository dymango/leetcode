package app.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class ShortestBridge_934 {

    /**
     * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
     * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
     * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
     * 返回必须翻转的 0 的最小数目。
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [[0,1],[1,0]]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
     * 输出：2
     * 示例 3：
     * <p>
     * 输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
     * 输出：1
     *  
     * <p>
     * 提示：
     * n == grid.length == grid[i].length
     * 2 <= n <= 100
     * grid[i][j] 为 0 或 1
     * grid 中恰有两个岛
     *
     * @param grid
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new ShortestBridge_934().shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}}));
    }

    public int shortestBridge(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> islandQueue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[row][col];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] poll = queue.poll();
                            int x = poll[0];
                            int y = poll[1];
                            if (x < 0 || x >= row || y < 0 || y >= col) continue;
                            if (grid[x][y] == 0 || grid[x][y] == -1) continue;
                            if (visited[x][y]) continue;
                            grid[x][y] = -1;
                            visited[x][y] = true;
                            islandQueue.offer(new int[]{x, y});
                            queue.offer(new int[]{x + 1, y});
                            queue.offer(new int[]{x - 1, y});
                            queue.offer(new int[]{x, y - 1});
                            queue.offer(new int[]{x, y + 1});
                        }
                    }


                    visited = new boolean[row][col];
                    int count = 0;
                    while (!islandQueue.isEmpty()) {
                        int size = islandQueue.size();
                        for (int k = 0; k < size; k++) {
                            int[] poll = islandQueue.poll();
                            int x = poll[0];
                            int y = poll[1];
                            if (x < 0 || x >= row || y < 0 || y >= col) continue;
                            if (visited[x][y]) continue;
                            visited[x][y] = true;
                            if (grid[x][y] == 1) {
                                return count - 1;
                            }

                            if (x + 1 < row) islandQueue.offer(new int[]{x + 1, y});
                            if (x - 1 >= 0) islandQueue.offer(new int[]{x - 1, y});
                            if (y - 1 >= 0) islandQueue.offer(new int[]{x, y - 1});
                            if (y + 1 < col) islandQueue.offer(new int[]{x, y + 1});
                        }

                        count++;
                    }
                }
            }
        }

        return 0;
    }
}
