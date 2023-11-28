package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class mySqrt_69 {

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * <p>
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * <p>
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 4
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= x <= 231 - 1
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        while (start < end) {
            long mid = start + (end - start) / 2;
            long product = mid * mid;
            if (product == x) return (int) mid;
            if (product > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (int) (start * start > x ? start - 1 : start);
    }

    public static void main(String[] args) {
        System.out.println(new mySqrt_69().mySqrt(8));
    }
}
