package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class ArrangeCoins_441 {

    /**
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     *
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     *
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     *
     * 示例 1:
     *
     * n = 5
     *
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤
     *
     * 因为第三行不完整，所以返回2.
     * 示例 2:
     *
     * n = 8
     *
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤ ¤
     * ¤ ¤
     *
     * 因为第四行不完整，所以返回3.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/arranging-coins
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
        if(n == 1) return 1;
        int sum = 0;
        int row = 0;
        while(sum < n) {
            sum += (++row);
            if(sum < 0) return row-1;
        }

        if(sum == n) return row;
        return row - 1;
    }

    public static void main(String[] args) {

        System.out.println( arrangeCoins(2147483647));
    }
}
