package leetcodepractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class AllCellsDistOrder_1030 {

    /**
     * 给定四个整数 rows ,   cols ,  rCenter 和 cCenter 。有一个 rows x cols 的矩阵，你在单元格上的坐标是 (rCenter, cCenter) 。
     * <p>
     * 返回矩阵中的所有单元格的坐标，并按与 (rCenter, cCenter) 的 距离 从最小到最大的顺序排。你可以按 任何 满足此条件的顺序返回答案。
     * <p>
     * 单元格(r1, c1) 和 (r2, c2) 之间的距离为|r1 - r2| + |c1 - c2|。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：rows = 1, cols = 2, rCenter = 0, cCenter = 0
     * 输出：[[0,0],[0,1]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
     * 示例 2：
     * <p>
     * 输入：rows = 2, cols = 2, rCenter = 0, cCenter = 1
     * 输出：[[0,1],[0,0],[1,1],[1,0]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
     * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
     * 示例 3：
     * <p>
     * 输入：rows = 2, cols = 3, rCenter = 1, cCenter = 2
     * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
     * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
     *
     * @param rows
     * @param cols
     * @param rCenter
     * @param cCenter
     * @return
     */
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] r = new int[rows * cols][2];
        boolean[][] visited = new boolean[rows][cols];
        int index = 0;
        Queue<int[]> stack = new LinkedList<>();
        stack.add(new int[]{rCenter, cCenter});
        while (!stack.isEmpty()) {
            var size = stack.size();
            for (int i = 0; i < size; i++) {
                var poll = stack.poll();
                if (poll[0] < 0 || poll[0] >= rows || poll[1] < 0 || poll[1] >= cols || visited[poll[0]][poll[1]]) continue;
                r[index++] = poll;
                visited[poll[0]][poll[1]] = true;

                stack.add(new int[]{poll[0] + 1, poll[1]});
                stack.add(new int[]{poll[0], poll[1] + 1});
                stack.add(new int[]{poll[0] - 1, poll[1]});
                stack.add(new int[]{poll[0], poll[1] - 1});
            }
        }

        return r;
    }
}
