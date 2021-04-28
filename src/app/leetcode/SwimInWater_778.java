package app.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author dimmy
 */
public class SwimInWater_778 {
    /**
     * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
     * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
     * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[0,2],[1,3]]
     * 输出: 3
     * 解释:
     * 时间为0时，你位于坐标方格的位置为 (0, 0)。
     * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
     * <p>
     * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
     * 示例2:
     * <p>
     * 输入:
     * [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
     * 输出: 16
     * 解释:
     * 0  1  2  3  4
     * 24 23 22 21  5
     * 12 13 14 15 16
     * 11 17 18 19 20
     * 10  9  8  7  6
     * <p>
     * 最终的路线用加粗进行了标记。
     * 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
     *  
     *
     * 0  1  2  3  4
     * 24 50 51 13 53
     * 12 13 14 15 16
     * 11 17 18 19 20
     * 10  9  8  7  6
     * <p>
     * 提示:
     * <p>
     * 2 <= N <= 50.
     * grid[i][j] 是 [0, ..., N*N - 1] 的排列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swim-in-rising-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public static int swimInWater(int[][] grid) {
        int l = grid.length;
        int max = l * l - 1;
        int start = 0;
        int end = max;
        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean joint = tryJoin(mid, grid);
            if(joint) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }


    private static boolean tryJoin(int t, int[][] grid) {
        boolean[][] marked = new boolean[50][50];
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid.length; k++) {
                if(grid[j][k] == t) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{0, 0});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            int[] poll = queue.poll();
                            if(marked[poll[0]][poll[1]] || grid[poll[0]][poll[1]] > t) continue;
                            marked[poll[0]][poll[1]] = true;
                            if(poll[0] == grid.length - 1 && poll[1] == grid.length - 1) return true;
                            if(poll[0] + 1 < grid.length) {
                                queue.offer(new int[]{poll[0] + 1, poll[1]});
                            }
                            if(poll[0] - 1 >= 0) {
                                queue.offer(new int[]{poll[0] - 1, poll[1]});
                            }
                            if(poll[1] + 1 < grid.length) {
                                queue.offer(new int[]{poll[0], poll[1] + 1});
                            }
                            if(poll[1] - 1 >= 0) {
                                queue.offer(new int[]{poll[0], poll[1] - 1});
                            }
                        }
                    }
                }
            }
        }


        return false;
    }

   static int[][] globalGrid;
   static int min = Integer.MAX_VALUE;
    public static int swimInWater2(int[][] grid) {
        globalGrid = grid;
        dfs(0, 0, 0, new HashSet<>());
        return min;
    }

    private static void dfs(int x, int y, int ct, Set<Integer> tSet) {
        if(ct > min ||  x >= globalGrid.length || x < 0 || y >= globalGrid.length || y < 0 || tSet.contains(globalGrid[x][y])) return;
        if(x == globalGrid.length - 1 && y == globalGrid.length - 1) {
            min = Math.min(min, Math.max(ct, globalGrid[globalGrid.length - 1][globalGrid.length - 1]));
            return;
        }
        tSet.add(globalGrid[x][y]);
        dfs(x + 1, y, Math.max(globalGrid[x][y], ct), tSet);
        dfs(x - 1, y, Math.max(globalGrid[x][y], ct), tSet);
        dfs(x, y + 1, Math.max(globalGrid[x][y], ct), tSet);
        dfs(x, y - 1, Math.max(globalGrid[x][y], ct), tSet);
        tSet.remove(globalGrid[x][y]);
    }
    public static void main(String[] args) {
        System.out.println(swimInWater2(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
//        System.out.println(swimInWater2(new int[][]{{0, 2}, {1, 3}}));
    }
}
