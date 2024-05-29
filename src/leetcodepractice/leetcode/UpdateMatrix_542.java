package leetcodepractice.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class UpdateMatrix_542 {
    /**
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     * <p>
     * 两个相邻元素间的距离为 1 。
     * <p>
     * 示例 1:
     * 输入:
     * <p>
     * 0 0 0
     * 0 1 0
     * 0 0 0
     * 输出:
     * <p>
     * 0 0 0
     * 0 1 0
     * 0 0 0
     * 示例 2:
     * 输入:
     * <p>
     * 0 0 0
     * 0 1 0
     * 1 1 1
     * 输出:
     * <p>
     * 0 0 0
     * 0 1 0
     * 1 2 1
     * 注意:
     * <p>
     * 给定矩阵的元素个数不超过 10000。
     * 给定矩阵中至少有一个元素是 0。
     * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/01-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @return
     */
    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] marked = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    marked[i][j] = true;
                }
            }
        }

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                if (x + 1 < row && matrix[x + 1][y] != 0 && !marked[x + 1][y]) {
                    queue.offer(new int[]{x + 1, y});
                    matrix[x + 1][y] = level;
                    marked[x + 1][y] = true;
                }
                if (x - 1 >= 0 && matrix[x - 1][y] != 0 && !marked[x - 1][y]) {
                    queue.offer(new int[]{x - 1, y});
                    matrix[x - 1][y] = level;
                    marked[x - 1][y] = true;
                }
                if (y + 1 < col && matrix[x][y + 1] != 0 && !marked[x][y + 1]) {
                    queue.offer(new int[]{x, y + 1});
                    marked[x][y + 1] = true;
                    matrix[x][y + 1] = level;
                }
                if (y - 1 >= 0 && matrix[x][y - 1] != 0 && !marked[x][y - 1]) {
                    queue.offer(new int[]{x, y - 1});
                    marked[x][y - 1] = true;
                    matrix[x][y - 1] = level;
                }
            }

            level++;
        }


        return matrix;
    }

    public static void main(String[] args) {
//        updateMatrix(new int[][]{
//                { 0 ,0 ,0},
//                { 0 ,1, 0},
//                {1 ,1 ,1}
//        });

        updateMatrix2(new int[][]{
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}});
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 初始化动态规划的数组，所有的距离值都设置为一个很大的数
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }
        // 如果 (i, j) 的元素为 0，那么距离为 0
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        // 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i + 1 < m) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }
}
