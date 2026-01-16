package leetcodepractice.leetcode;

import java.util.Stack;

/**
 * @author dimmy
 */
public class MaximalRectangle_85 {

    /**
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     * @param matrix
     * @return
     */

    public static void main(String[] args) {
        System.out.println(new MaximalRectangle_85().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
//        System.out.println(new MaximalRectangle_85().maximalRectangle(new char[][]{
//            {'0', '0', '1', '0'},
//            {'0', '0', '1', '0'},
//            {'0', '0', '1', '0'},
//            {'0', '0', '1', '1'},
//            {'0', '1', '1', '1'},
//            {'0', '1', '1', '1'},
//            {'1', '1', '1', '1'}}));
//        ["1","0","1","0","0"],
//        ["1","0","1","1","1"],
//        ["1","1","1","1","1"],
//        ["1","0","0","1","0"]]

    }

//    public int maximalRectangle(char[][] matrix) {
//
//        var n = matrix.length;
//        var m = matrix[0].length;
//        int[][] history = new int[n][m];
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            Stack<Integer> stack = new Stack<>();
//            for (int j = 0; j < m; j++) {
//                int height = matrix[i][j] == '1' ? 1 : 0;
//                if (matrix[i][j] == '1') {
//                    height = i == 0 ? 1 : (history[i - 1][j]) + 1;
//                }
//                history[i][j] = height;
//
//                if (matrix[i][j] == '0') {
//                    if (stack.isEmpty()) continue;
//                    Integer start = stack.peek();
//                    int last = j;
//                    while (!stack.isEmpty() && height < history[i][stack.peek()]) {
//                        last = stack.pop();
//                    }
//
//                    var area = (start - last + 1) * history[i][last];
//                    max = Math.max(max, area);
//                } else {
//                    if (stack.isEmpty()) stack.push(j);
//                    else {
//                        Integer start = stack.peek();
//                        if (height >= history[i][stack.peek()]) {
//                            stack.push(j);
//                            continue;
//                        }
//
//                        int last;
//                        while (!stack.isEmpty() && height < history[i][stack.peek()]) {
//                            last = stack.pop();
//                            var area = (start - last + 1) * history[i][last];
//                            max = Math.max(max, area);
//                        }
//
//                        if (!stack.isEmpty()) {
//                            var area = (start - stack.peek() + 1) * history[i][stack.peek()];
//                            max = Math.max(max, area);
//                        }
//
//                        stack.push(j);
//                    }
//                }
//            }
//
//            if (!stack.isEmpty()) {
//                Integer start = stack.peek();
//                int last = start;
//                while (!stack.isEmpty()) {
//                    last = stack.pop();
//                    var area = (start - last + 1) * history[i][last];
//                    max = Math.max(max, area);
//                }
//            }
//        }
//
//        return max;
//    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            // 更新当前行的高度数组
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            // 使用单调栈计算当前行的最大矩形面积
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
