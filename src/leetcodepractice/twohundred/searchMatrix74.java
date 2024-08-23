package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class searchMatrix74 {

    /**
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     * 每行中的整数从左到右按非严格递增顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] m : matrix) {
            if (m[0] <= target && m[m.length - 1] >= target) {
                for (int n : m) {
                    if (n == target) return true;
                }
                return false;
            }
        }

        return false;
    }
}
