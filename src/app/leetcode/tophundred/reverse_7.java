package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class reverse_7 {


    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * <p>
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * <p>
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 123
     * 输出：321
     * 示例 2：
     * <p>
     * 输入：x = -123
     * 输出：-321
     * 示例 3：
     * <p>
     * 输入：x = 120
     * 输出：21
     * 示例 4：
     * <p>
     * 输入：x = 0
     * 输出：0
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean tag = x >= 0;
        long num = 0;
        x = Math.abs(x);
        while (x > 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }

        if (num > Integer.MAX_VALUE) return 0;
        return tag ? (int) num : (int) -num;
    }

    public static void main(String[] args) {
        new reverse_7().reverse(1534236469);
    }
}
