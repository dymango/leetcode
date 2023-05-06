package app.leetcode;

/**
 * @author dimmy
 */
public class IsMatch_44 {

    /**
     * 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符序列（包括空字符序列）。
     * 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
     *  
     * 示例 1：
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * <p>
     * 示例 2：
     * 输入：s = "aa", p = "*"
     * 输出：true
     * 解释：'*' 可以匹配任意字符串。
     * <p>
     * 示例 3：
     * 输入：s = "cb", p = "?a"
     * 输出：false
     * 解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length, p.length <= 2000
     * s 仅由小写英文字母组成
     * p 仅由小写英文字母、'?' 或 '*' 组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/wildcard-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sL = s.length();
        int pL = p.length();
        boolean[][] dp = new boolean[sL + 1][pL + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pL; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i <= sL; i++) {
            for (int j = 1; j <= pL; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    int index = i;
                    boolean match = false;
                    while (index >= 0 && !dp[index][j - 1]) index--;
                    if (index >= 0) match = true;
                    dp[i][j] = match;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && sc == pc;
                }
            }
        }

        return dp[sL][pL];
    }

    //"adceb"
    //"*a*b"
    public static void main(String[] args) {
        new IsMatch_44().isMatch("adceb", "*a*b");
    }
}
