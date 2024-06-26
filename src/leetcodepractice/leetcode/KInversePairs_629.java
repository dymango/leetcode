package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class KInversePairs_629 {

    /**
     * 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
     *
     * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
     *
     * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
     *
     * 示例 1:
     *
     * 输入: n = 3, k = 0
     * 输出: 1
     * 解释:
     * 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
     * 示例 2:
     *
     * 输入: n = 3, k = 1
     * 输出: 2
     * 解释:
     * 数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/k-inverse-pairs-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @param k
     * @return
     */
    public int kInversePairs(int n, int k) {
        int mod = (int) (1e9 + 7);
        int[][] f = new int[n + 1][k + 1];
        // i个数字，0个逆序对，有一种，就是升序
        for (int i = 1; i <= n; i++) {
            f[i][0] = 1;
        }
        // 枚举i个数字
        for (int i = 2; i <= n; i++) {
            // 枚举逆序对个数
            for (int j = 1; j <= k; j++) {
                for (int p = Math.max(j - i + 1, 0); p <= j; p++) {
                    f[i][j] = (f[i][j] + f[i - 1][p]) % mod;
                }
            }
        }

        return f[n][k];
    }


}
