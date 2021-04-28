package app.leetcode;

/**
 * @author dimmy
 */
public class MonotoneIncreasingDigits_738 {
    /**
     * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
     *
     * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
     *
     * 示例 1:
     *
     * 输入: N = 10
     * 输出: 9
     * 示例 2:
     *
     * 输入: N = 1234
     * 输出: 1234
     * 示例 3:
     *
     * 输入: N = 332
     * 输出: 299
     * 说明: N 是在 [0, 10^9] 范围内的一个整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        int res = 0;
        // 倍数
        int seed = 1;
        while (N > 0) {
            int num = N % 10;
            N /= 10;
            int high = N % 10;
            if (high > num) {
                // 高位大于低位，将低位全部置为9，高位数字-1
                res = seed*10 - 1;
                N -= 1;
            }else  {
                res = num * seed + res;
            }
            seed *= 10;
        }
        return res;
    }
}
