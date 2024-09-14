package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class searchMatrix_240 {

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        var row = matrix.length;
        var col = matrix[0].length;
        int x = 0, y = col - 1;
        while (x < row && y >= 0) {
            var num = matrix[x][y];
            if(num > target) {
                y--;
            } else if(num < target) {
                x++;
            } else {
                return true;
            }
        }

        return false;
    }

}
