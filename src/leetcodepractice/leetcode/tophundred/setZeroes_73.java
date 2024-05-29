package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class setZeroes_73 {

    /**
     * 我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1)O(1)O(1) 的额外空间。但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含 000。因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 000。
     * 在实际代码中，我们首先预处理出两个标记变量，接着使用其他行与列去处理第一行与第一列，然后反过来使用第一行与第一列去更新其他行与列，最后使用两个标记变量更新第一行与第一列即可。
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/set-matrix-zeroes/solutions/669901/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param matrix 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean rowFlag = false;
        boolean columnFlag = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) columnFlag = true;
        }

        for (int i = 0; i < column; i++) {
            if (matrix[0][i] == 0) rowFlag = true;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowFlag) {
            for (int i = 0; i < column; i++) {
                matrix[0][i] = 0;
            }
        }

        if (columnFlag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
