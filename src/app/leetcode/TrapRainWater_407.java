package app.leetcode;

import app.LeetCode;
import app.metaapp.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class TrapRainWater_407 {

    /**
     * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
     * <p>
     * 示例 1:
     * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
     * 输出: 4
     * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
     * <p>
     * 示例 2:
     * 输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
     * 输出: 10
     *  
     * <p>
     * 提示:
     * m == heightMap.length
     * n == heightMap[i].length
     * 1 <= m, n <= 200
     * 0 <= heightMap[i][j] <= 2 * 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/trapping-rain-water-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * {
     * {12,13,1,12},
     * {13,4,13,12},
     * {13,8,10,12},
     * {12,13,12,12},
     * {13,13,13,13}}
     * <p>
     * {
     * {5,5,5,1},
     * {5,1,1,5},
     * {5,1,5,5},
     * {5,2,5,8}}
     * <p>
     * {{9,9,9,9,9},{9,2,1,2,9},{9,2,8,2,9},{9,2,3,2,9},{9,9,9,9,9}}
     * <p>
     * {{14,17,18,16,14,16},{17,3,10,2,3,8},{11,10,4,7,1,7},{13,7,2,9,8,10},{13,1,3,4,8,6},{20,3,3,9,10,8}}
     *
     *
     * @param heightMap
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new TrapRainWater_407().trapRainWaterV2(new int[][]
            {
                {14, 17, 18, 16, 14, 16},
                {17, 3, 10, 2, 3, 8},
                {11, 10, 4, 7, 1, 7},
                {13, 7, 2, 9, 8, 10},
                {13, 1, 3, 4, 8, 6},
                {20, 3, 3, 9, 10, 8}}));
    }

    private int X;
    private int Y;

    public int trapRainWater(int[][] heightMap) {
        int r = heightMap.length;
        int c = heightMap[0].length;
        X = r;
        Y = c;
        int[][] graph = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int k = 0; k < c; k++) {
                if (i == 0 || k == 0 || i == X - 1 || k == Y - 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[r][c];
                    queue.add(new int[]{i, k});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int j = 0; j < size; j++) {
                            int[] poll = queue.poll();
                            int x = poll[0];
                            int y = poll[1];
                            graph[x][y] = 1;
                            visited[x][y] = true;
                            if (check(x + 1, y) && !visited[x + 1][y] && graph[x + 1][y] != 1 && heightMap[x + 1][y] >= heightMap[x][y]) {
                                queue.add(new int[]{x + 1, y});
                            }

                            if (check(x, y + 1) && !visited[x][y + 1] && graph[x][y + 1] != 1 && heightMap[x][y + 1] >= heightMap[x][y]) {
                                queue.add(new int[]{x, y + 1});
                            }

                            if (check(x - 1, y) && !visited[x - 1][y] && graph[x - 1][y] != 1 && heightMap[x - 1][y] >= heightMap[x][y]) {
                                queue.add(new int[]{x - 1, y});
                            }
                            if (check(x, y - 1) && !visited[x][y - 1] && graph[x][y - 1] != 1 & heightMap[x][y - 1] >= heightMap[x][y]) {
                                queue.add(new int[]{x, y - 1});
                            }
                        }

                    }
                }

            }
        }

        int sum = 0;
        while (true) {
            boolean replenish = false;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (graph[i][j] == 1) continue;
                    int min = Math.min(Math.min(heightMap[i + 1][j], heightMap[i - 1][j]), Math.min(heightMap[i][j + 1], heightMap[i][j - 1]));
                    if (heightMap[i][j] < min) {
                        sum += (min - heightMap[i][j]);
                        heightMap[i][j] = min;
                        replenish = true;
                    }
                }
            }

            boolean[][] sign = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int k = 0; k < c; k++) {
                    if (graph[i][k] == 1 || sign[i][k]) continue;
                    boolean[][] visited = new boolean[r][c];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, k});
                    int min = Integer.MAX_VALUE;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int j = 0; j < size; j++) {
                            int[] poll = queue.poll();
                            int x = poll[0];
                            int y = poll[1];
                            visited[x][y] = true;
                            sign[x][y] = true;
                            if (check(x + 1, y) && !visited[x + 1][y] && (graph[x + 1][y] == 1 || heightMap[x + 1][y] != heightMap[x][y])) {
                                min = Math.min(min, heightMap[x + 1][y]);
                            }

                            if (check(x, y + 1) && !visited[x][y + 1] && (graph[x][y + 1] == 1 || heightMap[x][y + 1] != heightMap[x][y])) {
                                min = Math.min(min, heightMap[x][y + 1]);
                            }

                            if (check(x - 1, y) && !visited[x - 1][y] && (graph[x - 1][y] == 1 || heightMap[x - 1][y] != heightMap[x][y])) {
                                min = Math.min(min, heightMap[x - 1][y]);
                            }

                            if (check(x, y - 1) && !visited[x][y - 1] && (graph[x][y - 1] == 1 || heightMap[x][y - 1] != heightMap[x][y])) {
                                min = Math.min(min, heightMap[x][y - 1]);
                            }


                            if (check(x + 1, y) && !visited[x + 1][y] && heightMap[x + 1][y] == heightMap[x][y]) {
                                queue.add(new int[]{x + 1, y});
                            }

                            if (check(x, y + 1) && !visited[x][y + 1] && heightMap[x][y + 1] == heightMap[x][y]) {
                                queue.add(new int[]{x, y + 1});
                            }

                            if (check(x - 1, y) && !visited[x - 1][y] && heightMap[x - 1][y] == heightMap[x][y]) {
                                queue.add(new int[]{x - 1, y});
                            }
                            if (check(x, y - 1) && !visited[x][y - 1] && heightMap[x][y - 1] == heightMap[x][y]) {
                                queue.add(new int[]{x, y - 1});
                            }
                        }
                    }

                    for (int j = 0; j < r; j++) {
                        for (int l = 0; l < c; l++) {
                            if (visited[j][l]) {
                                if (min > heightMap[i][k]) {
                                    sum += (min - heightMap[i][k]);
                                    heightMap[i][k] = min;
                                    replenish = true;
                                }
                            }
                        }
                    }
                }
            }

            if (!replenish) break;
        }

        return sum;
    }

    private boolean check(int x, int y) {
        if (x >= 0 && x < X && y >= 0 && y < Y) return true;
        return false;
    }

    public int trapRainWaterV2(int[][] heightMap) {
        int r = heightMap.length;
        int c = heightMap[0].length;
        X = r;
        Y = c;
        int sum = 0;
        while (true) {
            boolean replenish = false;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i == 0 || j == 0 || i == X - 1 || j == Y - 1) continue;
                    int min = Math.min(Math.min(heightMap[i + 1][j], heightMap[i - 1][j]), Math.min(heightMap[i][j + 1], heightMap[i][j - 1]));
                    if (heightMap[i][j] < min) {
                        sum += (min - heightMap[i][j]);
                        heightMap[i][j] = min;
                        replenish = true;
                    }
                }
            }

            boolean[][] sign = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int k = 0; k < c; k++) {
                    if (i == 0 || k == 0 || i == X - 1 || k == Y - 1) continue;
                    if (sign[i][k]) continue;
                    if (heightMap[i][k] > heightMap[i + 1][k] || heightMap[i][k] > heightMap[i][k + 1] || heightMap[i][k] > heightMap[i - 1][k] || heightMap[i][k] > heightMap[i][k - 1]) continue;
                    boolean[][] visited = new boolean[r][c];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, k});
                    int min = Integer.MAX_VALUE;
                    boolean invalid = false;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int j = 0; j < size; j++) {
                            int[] poll = queue.poll();
                            int x = poll[0];
                            int y = poll[1];
                            if (x == 0 || y == 0 || x == X - 1 || y == Y - 1) {
                                invalid = true;
                            }

                            visited[x][y] = true;
                            sign[x][y] = true;
                            if (!invalid) {
                                if (check(x + 1, y) && !visited[x + 1][y] && heightMap[x + 1][y] != heightMap[x][y]) {
                                    min = Math.min(min, heightMap[x + 1][y]);
                                }

                                if (check(x, y + 1) && !visited[x][y + 1] && heightMap[x][y + 1] != heightMap[x][y]) {
                                    min = Math.min(min, heightMap[x][y + 1]);
                                }

                                if (check(x - 1, y) && !visited[x - 1][y] && heightMap[x - 1][y] != heightMap[x][y]) {
                                    min = Math.min(min, heightMap[x - 1][y]);
                                }

                                if (check(x, y - 1) && !visited[x][y - 1] && heightMap[x][y - 1] != heightMap[x][y]) {
                                    min = Math.min(min, heightMap[x][y - 1]);
                                }
                            }


                            if (check(x + 1, y) && !visited[x + 1][y] && heightMap[x + 1][y] == heightMap[x][y]) {
                                queue.add(new int[]{x + 1, y});
                            }

                            if (check(x, y + 1) && !visited[x][y + 1] && heightMap[x][y + 1] == heightMap[x][y]) {
                                queue.add(new int[]{x, y + 1});
                            }

                            if (check(x - 1, y) && !visited[x - 1][y] && heightMap[x - 1][y] == heightMap[x][y]) {
                                queue.add(new int[]{x - 1, y});
                            }
                            if (check(x, y - 1) && !visited[x][y - 1] && heightMap[x][y - 1] == heightMap[x][y]) {
                                queue.add(new int[]{x, y - 1});
                            }
                        }
                    }

                    if (!invalid) {
                        for (int j = 0; j < r; j++) {
                            for (int l = 0; l < c; l++) {
                                if (visited[j][l]) {
                                    if (min > heightMap[i][k]) {
                                        sum += (min - heightMap[i][k]);
                                        heightMap[i][k] = min;
                                        replenish = true;
                                    }
                                }
                            }
                        }
                    }

                }
            }

            if (!replenish) break;
        }

        return sum;
    }

    public int trapRainWaterv3(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        int maxHeight = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                maxHeight = Math.max(maxHeight, heightMap[i][j]);
            }
        }
        int[][] water = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j){
                water[i][j] = maxHeight;
            }
        }
        Queue<int[]> qu = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (water[i][j] > heightMap[i][j]) {
                        water[i][j] = heightMap[i][j];
                        qu.offer(new int[]{i, j});
                    }
                }
            }
        }
        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i], ny = y + dirs[i + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (water[x][y] < water[nx][ny] && water[nx][ny] > heightMap[nx][ny]) {
                    water[nx][ny] = Math.max(water[x][y], heightMap[nx][ny]);
                    qu.offer(new int[]{nx, ny});
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res += water[i][j] - heightMap[i][j];
            }
        }
        return res;
    }

}
