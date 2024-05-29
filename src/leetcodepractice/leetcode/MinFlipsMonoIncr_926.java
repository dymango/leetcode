package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MinFlipsMonoIncr_926 {

    /**
     * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
     * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
     * 返回使 s 单调递增的最小翻转次数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "00110"
     * 输出：1
     * 解释：翻转最后一位得到 00111.
     * 示例 2：
     * <p>
     * 输入：s = "010110"
     * 输出：2
     * 解释：翻转得到 011111，或者是 000111。
     * 示例 3：
     * <p>
     * 输入：s = "00011000"
     * 输出：2
     * 解释：翻转得到 00000000。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 105
     * s[i] 为 '0' 或 '1'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/flip-string-to-monotone-increasing
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int minFlipsMonoIncr(String s) {
        return minRevertCount(s, s.length() - 1, '1');
    }

    private int minRevertCount(String s, int end, char pre) {
        if (end < 0) return 0;
        char last = s.charAt(end);
        char reverseLast = last == '0' ? '1' : '0';
        if (pre == '0') {
            if (last == '1') {
                return minRevertCount(s, end - 1, '0') + 1;
            } else {
                return minRevertCount(s, end - 1, '0');
            }
        } else {
            return Math.min(minRevertCount(s, end - 1, last), minRevertCount(s, end - 1, reverseLast) + 1);
        }
    }

    public static void main(String[] args) {
        new MinFlipsMonoIncr_926().minFlipsMonoIncrV2("00011000");
    }

    public int minFlipsMonoIncrV2(String s) {
        int length = s.length();
        int count1;
        int count2;
        if (s.charAt(0) == '0') {
            count1 = 0;
            count2 = 1;
        } else {
            count1 = 1;
            count2 = 0;
        }

        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            boolean isZero = c == '0';
            int tc2 = Math.min(count1, count2) + (!isZero ? 0 : 1);
            if(!isZero) count1++;
            count2 = tc2;
        }

        return Math.min(count1, count2);
    }
}
