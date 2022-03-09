package app.jianzhioffer;

/**
 * @author dimmy
 */
public class MyPow_16 {

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * 示例 2：
     * <p>
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * 示例 3：
     * <p>
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     *  
     * <p>
     * 提示：
     * <p>
     * -100.0 < x < 100.0
     * -231 <= n <= 231-1
     * -104 <= xn <= 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        if(n == 2) return x*x;
        double t = x;
        if (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                x *= t;
            }

            return x;
        } else {
            n = Math.abs(n);
            if(n == 2) x*=x;
            else if(n != 1) {
                for (int i = 0; i < n - 1; i++) {
                    x *= t;
                }
            }

            return 1 / x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MyPow_16().myPow(2.0000, 10));
    }
}
