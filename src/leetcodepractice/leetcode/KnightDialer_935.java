package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class KnightDialer_935 {

    /**
     * 象棋骑士有一个独特的移动方式，它可以垂直移动两个方格，水平移动一个方格，或者水平移动两个方格，垂直移动一个方格(两者都形成一个 L 的形状)。
     * <p>
     * 象棋骑士可能的移动方式如下图所示:
     * <p>
     * <p>
     * <p>
     * 我们有一个象棋骑士和一个电话垫，如下所示，骑士只能站在一个数字单元格上(即蓝色单元格)。
     * <p>
     * <p>
     * <p>
     * 给定一个整数 n，返回我们可以拨多少个长度为 n 的不同电话号码。
     * <p>
     * 你可以将骑士放置在任何数字单元格上，然后你应该执行 n - 1 次移动来获得长度为 n 的号码。所有的跳跃应该是有效的骑士跳跃。
     * <p>
     * 因为答案可能很大，所以输出答案模 109 + 7.
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 1
     * 输出：10
     * 解释：我们需要拨一个长度为1的数字，所以把骑士放在10个单元格中的任何一个数字单元格上都能满足条件。
     * 示例 2：
     * <p>
     * 输入：n = 2
     * 输出：20
     * 解释：我们可以拨打的所有有效号码为[04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
     * 示例 3：
     * <p>
     * 输入：n = 3131
     * 输出：136006598
     * 解释：注意取模
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 5000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/knight-dialer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new KnightDialer_935().knightDialer(3131));
    }

    public int knightDialer(int n) {
        long[] dpV2 = new long[10];
        for (int i = 0; i < 10; i++) {
            dpV2[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            long[] next = new long[10];
            next[0] = (dpV2[4] + dpV2[6]) % 1000000007;
            next[1] = (dpV2[6] + dpV2[8]) % 1000000007;
            next[2] = (dpV2[7] + dpV2[9]) % 1000000007;
            next[3] = (dpV2[4] + dpV2[8]) % 1000000007;
            next[4] = (dpV2[9] + dpV2[0] + dpV2[3]) % 1000000007;
            next[5] = 0;
            next[6] = (dpV2[1] + dpV2[7] + dpV2[0]) % 1000000007;
            next[7] = (dpV2[2] + dpV2[6]) % 1000000007;
            next[8] = (dpV2[1] + dpV2[3]) % 1000000007;
            next[9] = (dpV2[2] + dpV2[4]) % 1000000007;
            dpV2 = next;
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dpV2[i];
            sum %= 1000000007;
        }
        return (int) sum;
    }
}
