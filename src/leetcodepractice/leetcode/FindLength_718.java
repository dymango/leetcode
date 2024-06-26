package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class FindLength_718 {

    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     *
     *  
     *
     * 示例：
     *
     * 输入：
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出：3
     * 解释：
     * 长度最长的公共子数组是 [3, 2, 1] 。
     *  
     *
     * 提示：
     *
     * 1 <= len(A), len(B) <= 1000
     * 0 <= A[i], B[i] < 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int al = A.length;
        int bl = B.length;
        int max = 0;
        int[][] dp = new int[al + 1][bl + 1];
        for (int i = 1; i <= al; i++) {
            for (int j = 1; j <= bl; j++) {
                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
