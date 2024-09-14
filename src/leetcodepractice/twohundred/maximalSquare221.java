package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class maximalSquare221 {

    /**
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     *
     * @param matrix
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new maximalSquare221().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    public int maximalSquare(char[][] matrix) {
        var row = matrix.length;
        var col = matrix[0].length;
        int[][] max = new int[row][col];

        int r = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                var cur = matrix[i][j];
                if (cur == '0') continue;
                var min = Math.min(get(max, i - 1, j), Math.min(get(max, i, j - 1), get(max, i - 1, j - 1)));
                max[i][j] = min + 1;
                r = Math.max(r, max[i][j] * max[i][j]);
            }
        }

        return r;
    }

    private int get(int[][] arr, int x, int y) {
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) return 0;
        return arr[x][y];
    }
}
