package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class NthMagicalNumber_878 {

    /**
     * 如果正整数可以被 A 或 B 整除，那么它是神奇的。
     * 返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：N = 1, A = 2, B = 3
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：N = 4, A = 2, B = 3
     * 输出：6
     * <p>
     * 示例 3：
     * 输入：N = 5, A = 2, B = 4
     * 输出：10
     * <p>
     * 示例 4：
     * 输入：N = 3, A = 6, B = 4
     * 输出：8
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= N <= 10^9
     * 2 <= A <= 40000
     * 2 <= B <= 40000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/nth-magical-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param a
     * @param b
     * @return
     */
    public int nthMagicalNumber(int n, int a, int b) {
        long num = 1;
        while (true) {
            if (num % a == 0 || num % b == 0) n--;
            if (n == 0) return (int) num % 100000007;
            num++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NthMagicalNumber_878().nthMagicalNumber(4, 2, 3));
        System.out.println(new NthMagicalNumber_878().nthMagicalNumber(5, 2, 4));
    }
}
