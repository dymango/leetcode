package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MinFallingPathSum_931 {
    int row;
    int col;

    public int minFallingPathSum(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] minValue = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                minValue[i][j] = matrix[i][j];
                minValue[i][j] = Math.min(matrix[i][j] + get(minValue, i - 1, j), Math.min(matrix[i][j] + get(minValue, i - 1, j - 1), matrix[i][j] + get(minValue, i - 1, j + 1)));
                if (i == row - 1) {
                    min = Math.min(min, minValue[i][j]);
                }
            }
        }

        return min;
    }

    private int get(int[][] minValue, int i, int j) {
        if (i < 0) return 0;
        if (j < 0 || j >= col) return 0;
        return minValue[i][j];
    }
}
