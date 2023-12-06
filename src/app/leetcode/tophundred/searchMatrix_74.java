package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class searchMatrix_74 {

    /**
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     * <p>
     * 每行中的整数从左到右按非严格递增顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) return false;
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if(matrix[i][0] <= target && matrix[i][column - 1] >= target) {
                int start = 0, end = column - 1;
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    int num = matrix[i][mid];
                    if (num == target) return true;
                    if (num > target) end = mid - 1;
                    else start = mid + 1;
                }

                break;
            }
        }

        return false;
    }
}
