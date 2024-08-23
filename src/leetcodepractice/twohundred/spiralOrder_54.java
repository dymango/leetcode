package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class spiralOrder_54 {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * @param matrix
     * @return
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        int start = 0;
        int end = 0;
        int direction = 1;
        List<Integer> r = new ArrayList<>();
        r.add(matrix[start][end]);
        var visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;
        while (true) {
            var result = nextPositionCalculator(matrix, visited, direction, start, end);
            if(result[1] < 0 || result[1] >= matrix.length || result[2] < 0 || result[2] >= matrix[0].length || visited[result[1]][result[2]]) return r;
            visited[result[1]][result[2]] = true;
            r.add(matrix[result[1]][result[2]]);
            direction = result[0];
            start = result[1];
            end = result[2];
        }
    }

    private int[] nextPositionCalculator(int[][] matrix, boolean[][] visited, int direction, int x, int y) {
        var row = matrix.length;
        var col = matrix[0].length;
        if (direction == 1) {
            if (y + 1 >= col || visited[x][y + 1]) {
                return new int[]{2, x + 1, y};
            } else {
                return new int[]{1, x, y + 1};
            }
        } else if (direction == 2) {
            if (x + 1 >= row || visited[x + 1][y]) {
                return new int[]{3, x, y - 1};
            } else {
                return new int[]{2, x + 1, y};
            }
        } else if (direction == 3) {
            if (y - 1 < 0 || visited[x][y - 1]) {
                return new int[]{4, x - 1, y};
            } else {
                return new int[]{3, x, y - 1};
            }
        } else {
            if (x - 1 < 0 || visited[x - 1][y]) {
                return new int[]{1, x, y + 1};
            } else {
                return new int[]{4, x - 1, y};
            }
        }
    }
}
