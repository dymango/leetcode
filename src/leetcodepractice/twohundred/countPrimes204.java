package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class countPrimes204 {
    /**
     * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 10
     * 输出：4
     * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * 示例 2：
     * <p>
     * 输入：n = 0
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：n = 1
     * 输出：0
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }

        return count;
    }

    private boolean isPrime(int n) {
        for (int j = 2; j * j <= n; j++) {
            if (n % j == 0) return false;
        }

        return true;
    }
}
