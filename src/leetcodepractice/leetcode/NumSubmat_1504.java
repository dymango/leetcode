package leetcodepractice.leetcode;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class NumSubmat_1504 {
    /**
     * 给你一个 m x n 的二进制矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
     *
     * @param mat
     * @return
     */
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        var total = 0;
        for (int i = 0; i < m; i++) {
            Stack<int[]> stack = new Stack<>();
            for (int j = 0; j < n; j++) {
                int height = 0;
                for (int k = i; k >= 0; k--) {
                    if (mat[k][j] == 1) height++;
                    else break;
                }


                while (!stack.isEmpty() && stack.peek()[2] >= height) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    var peek = stack.peek();
                    var area = peek[1] + (j - peek[0]) * height;
                    stack.push(new int[]{j, area, height});
                    total += area;
                } else {
                    var area = (j + 1) * height;
                    stack.push(new int[]{j, area, height});
                    total += area;
                }

            }
        }

        return total;
    }
}
