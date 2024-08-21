package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class reverse_7 {
    /**
     * 代码
     * 测试用例
     * 测试结果
     * 测试结果
     * 7. 整数反转
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * <p>
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * <p>
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int num = Math.abs(x);
        long newNum = 0;
        while (num > 0) {
            newNum = newNum * 10 + num % 10;
            num /= 10;
        }

        if (newNum > Integer.MAX_VALUE) return 0;
        return x < 0 ? (int) -newNum : (int) newNum;
    }
}
