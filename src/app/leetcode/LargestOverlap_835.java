package app.leetcode;

/**
 * @author dimmy
 */
public class LargestOverlap_835 {
    /**
     * 给你两个图像 img1 和 img2 ，两个图像的大小都是 n x n ，用大小相同的二维正方形矩阵表示。（并且为二进制矩阵，只包含若干 0 和若干 1 ）
     *
     * 转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的 重叠 是指两个图像都具有 1 的位置的数目。
     *
     * （请注意，转换 不包括 向任何方向旋转。）
     *
     * 最大可能的重叠是多少？
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
     * 输出：3
     * 解释：将 img1 向右移动 1 个单位，再向下移动 1 个单位。
     *
     * 两个图像都具有 1 的位置的数目是 3（用红色标识）。
     *
     * 示例 2：
     *
     * 输入：img1 = [[1]], img2 = [[1]]
     * 输出：1
     * 示例 3：
     *
     * 输入：img1 = [[0]], img2 = [[0]]
     * 输出：0
     *  
     *
     * 提示：
     *
     * n == img1.length
     * n == img1[i].length
     * n == img2.length
     * n == img2[i].length
     * 1 <= n <= 30
     * img1[i][j] 为 0 或 1
     * img2[i][j] 为 0 或 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/image-overlap
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param img1
     * @param img2
     * @return
     */
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] count = new int[2*N+1][2*N+1];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (A[i][j] == 1)
                    for (int i2 = 0; i2 < N; ++i2)
                        for (int j2 = 0; j2 < N; ++j2)
                            if (B[i2][j2] == 1)
                                count[i-i2 +N][j-j2 +N] += 1;

        int ans = 0;
        for (int[] row: count)
            for (int v: row)
                ans = Math.max(ans, v);
        return ans;
    }
}
