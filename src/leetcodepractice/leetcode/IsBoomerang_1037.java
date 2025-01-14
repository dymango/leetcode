package leetcodepractice.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class IsBoomerang_1037 {

    /**
     * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
     * <p>
     * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：points = [[1,1],[2,3],[3,2]]
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：points = [[1,1],[2,2],[3,3]]
     * 输出：false
     *
     * @param points
     * @return
     */
    public boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }


    public static void main(String[] args) {
        System.out.println(new IsBoomerang_1037().isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        System.out.println(new IsBoomerang_1037().isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }
}
