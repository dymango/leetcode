package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class FindIntegers_600 {

    /**
     * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
     *
     * 示例 1:
     *
     * 输入: 5
     * 输出: 5
     * 解释:
     * 下面是带有相应二进制表示的非负整数<= 5：
     * 0 : 0
     * 1 : 1
     * 2 : 10
     * 3 : 11
     * 4 : 100
     * 5 : 101
     * 其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
     * 说明: 1 <= n <= 109
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public static int findIntegers(int num) {
        return find(0, 0, num, false);
    }
    public static int find(int i, int sum, int num, boolean prev) {
        if (sum > num)
            return 0;
        if (1<<i > num)
            return 1;
        if (prev)
            return find(i + 1, sum, num, false);
        return find(i + 1, sum, num, false) + find(i + 1, sum + (1 << i), num, true);
    }

    public static void main(String[] args) {
//        findIntegers(5);
        findIntegers(100000000);
//        findIntegers(1);
    }
}
