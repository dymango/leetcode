package leetcodepractice.jianzhioffer;

/**
 * @author dimmy
 */
public class PrintNumbers_17 {

    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     *
     * 示例 1:
     *
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *  
     *
     * 说明：
     *
     * 用返回一个整数列表来代替打印
     * n 为正整数
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int pow = (int) Math.pow(10, n);
        int[] r = new int[pow-1];
        for (int i = 1; i < pow; i++) {
            r[i - 1] = i;
        }

        return r;
    }
}
