package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class rotate_48 {

    public void rotate(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        for (int j = width - 1; j >= 0; j--) {
            for (int i = 0; i < height; i++) {
                int t = matrix[j][i];
                matrix[j][i] = matrix[width - j - 1][i];
                matrix[width - j - 1][i] = t;
            }
        }
    }
}
