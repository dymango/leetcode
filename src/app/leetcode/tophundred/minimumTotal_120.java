package app.leetcode.tophundred;

import java.util.List;

/**
 * @author dimmy
 */
public class minimumTotal_120 {

    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * <p>
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     * @param triangle
     * @return
     */
    boolean[][] visited;
    int[][] steps;

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int column = triangle.get(triangle.size() - 1).size();
        visited = new boolean[row][column];
        steps = new int[row][column];
        return get(triangle, 0, 0);
    }

    private int get(List<List<Integer>> triangle, int i, int j) {
        if (i >= triangle.size()) return 0;
        List<Integer> list = triangle.get(i);
        if (j >= list.size()) return 0;
        if (visited[i][j]) return steps[i][j];
        int sum = Math.min(get(triangle, i + 1, j), get(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
        visited[i][j] = true;
        steps[i][j] = sum;
        return sum;
    }
}
