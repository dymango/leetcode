package app.tencent;

/**
 * @author dimmy
 */
public class Reverse_7 {

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *  
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
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        long n = 0;
        long x2 = Math.abs(x);
        while (x2 > 0) {
            n = n * 10 + x2 % 10;
            x2 /= 10;
            if(n < Integer.MIN_VALUE || n > Integer.MAX_VALUE) return 0;
        }

        return (int) (x >= 0 ? n : -n);
    }
}
