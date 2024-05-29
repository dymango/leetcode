package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author dimmy
 */
public class LargestIsland_827 {

    /**
     * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
     * 返回执行此操作后，grid 中最大的岛屿面积是多少？
     * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: grid = [[1, 0], [0, 1]]
     * 输出: 3
     * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
     * 示例 2:
     * <p>
     * 输入: grid = [[1, 1], [1, 0]]
     * 输出: 4
     * 解释: 将一格0变成1，岛屿的面积扩大为 4。
     * 示例 3:
     * <p>
     * 输入: grid = [[1, 1], [1, 1]]
     * 输出: 4
     * 解释: 没有0可以让我们变成1，面积依然为 4。
     *  
     * <p>
     * 提示：
     * <p>
     * n == grid.length
     * n == grid[i].length
     * 1 <= n <= 500
     * grid[i][j] 为 0 或 1
     * <p>
     * <p>
     * <p>
     * {{1,0,1,0,1},
     * {0,1,1,0,1},
     * {1,1,1,0,0},
     * {1,0,1,1,1},
     * {0,0,1,1,0}}
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/making-a-large-island
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int sign = 1;
        int[][] seq = new int[n][n];
        Map<Integer, Integer> areaMap = new HashMap<>();
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
                if (visited[i][j] || grid[i][j] == 0) continue;
                int sum = 0;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        if (visited[x][y] || grid[x][y] == 0) continue;
                        visited[x][y] = true;
                        seq[x][y] = sign;
                        sum++;
                        if (x + 1 < n) {
                            queue.offer(new int[]{x + 1, y});
                        }
                        if (y + 1 < n) {
                            queue.offer(new int[]{x, y + 1});
                        }
                        if (x - 1 >= 0) {
                            queue.offer(new int[]{x - 1, y});
                        }
                        if (y - 1 >= 0) {
                            queue.offer(new int[]{x, y - 1});
                        }
                    }
                }

                max = Math.max(sum, max);
                areaMap.put(sign, sum);
                sign++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
                if (grid[i][j] != 0) continue;
                Set<Integer> set = new HashSet<>();
                int sum = 1;
                if (i + 1 < n) {
                    if (seq[i + 1][j] != 0 && set.add(seq[i + 1][j])) {
                        sum += areaMap.get(seq[i + 1][j]);
                    }
                }

                if (i - 1 >= 0) {
                    if (seq[i - 1][j] != 0 && set.add(seq[i - 1][j])) {
                        sum += areaMap.get(seq[i - 1][j]);
                    }
                }

                if (j + 1 < n) {
                    if (seq[i][j + 1] != 0 && set.add(seq[i][j + 1])) {
                        sum += areaMap.get(seq[i][j + 1]);
                    }
                }

                if (j - 1 >= 0) {
                    if (seq[i][j - 1] != 0 && set.add(seq[i][j - 1])) {
                        sum += areaMap.get(seq[i][j - 1]);
                    }
                }

                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
