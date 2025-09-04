package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MinimumArea_3195 {

    /**
     * 给你一个二维 二进制 数组 grid。请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。
     * <p>
     * 返回这个矩形可能的 最小 面积。
     *
     * @param grid
     * @return
     */
    public int minimumArea(int[][] grid) {
        var left = Integer.MAX_VALUE;
        var right = 0;
        var down = 0;
        var up = Integer.MAX_VALUE;

        var l = grid.length;
        var h = grid[0].length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < h; j++) {
                if (grid[i][j] == 0) continue;
                if (j < left) left = j;
                if (j > right) right = j;
                if (i < up) up = i;
                if (i > down) down = i;
            }
        }

        return (right - left + 1) * (down - up + 1);
    }
}
