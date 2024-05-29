package leetcodepractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class MaxAreaOfIsland_695 {

    /**
     * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
     *
     * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     *
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     *
     *  
     *
     * 示例 1:
     *
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
     *
     * 示例 2:
     *
     * [[0,0,0,0,0,0,0,0]]
     * 对于上面这个给定的矩阵, 返回 0。
     *
     *  
     *
     * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-area-of-island
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(marked[i][j]) continue;
                if(grid[i][j] == 0) continue;
                int count = 0;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int[] poll = queue.poll();
                        if(grid[poll[0]][poll[1]] == 1) {
                            count++;
                        } else {
                            continue;
                        }

                        int x1 = poll[0];
                        int y1 = poll[1] + 1;
                        int y2 = poll[1] - 1;
                        if(x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && !marked[x1][y1]) {
                            queue.add(new int[]{x1, y1});
                            marked[x1][y1] = true;
                        }

                        if(x1 >= 0 && x1 < grid.length && y2 >= 0 && y2 < grid[0].length && !marked[x1][y2]) {
                            queue.add(new int[]{x1, y2});
                            marked[x1][y2] = true;
                        }

                        int x2 = poll[0] + 1;
                        int x3 = poll[0] - 1;
                        int y3 = poll[1];
                        if(x2 >= 0 && x2 < grid.length && y3 >= 0 && y3 < grid[0].length && !marked[x2][y3]) {
                            queue.add(new int[]{x2, y3});
                            marked[x2][y3] = true;
                        }

                        if(x3 >= 0 && x3 < grid.length && y3 >= 0 && y3 < grid[0].length && !marked[x3][y3]) {
                            queue.add(new int[]{x3, y3});
                            marked[x3][y3] = true;
                        }
                    }
                }

                max = Math.max(count, max);
            }
        }

        return max;
    }
}
