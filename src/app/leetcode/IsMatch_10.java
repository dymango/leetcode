package app.leetcode;

/**
 * @author dimmy
 */
public class IsMatch_10 {

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入：s = "cba", p = "a*c"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     * <p>
     * 输入：s = "ab", p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 20
     * 1 <= p.length <= 20
     * s 只包含从 a-z 的小写字母。
     * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pLength; i++) {
            char c = p.charAt(i - 1);
            if (c == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    char pre = p.charAt(j - 2);
                    int index = i;
                    if (pre == '.') {
                        boolean match = false;
                        while (index >= 0 && !dp[index][j - 2]) index--;
                        if (index >= 0) match = true;
                        dp[i][j] = match;
                    } else {
                        char ts = s.charAt(index - 1);
                        char tp = p.charAt(j - 2);
                        if (ts != tp) {
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            boolean serialC = true;
                            for (int k = index; k >= 0; k--) {
                                if (!serialC) break;
                                if (dp[k][j - 2]) {
                                    dp[i][j] = true;
                                    break;
                                }

                                serialC = k > 0 && (s.charAt(k - 1) == tp);
                            }
                        }
                    }
                } else if (pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && sc == pc;
                }
            }
        }


        return dp[sLength][pLength];
    }

    public static void main(String[] args) {
        //"mississippi"
        //"mis*is*p*."
        //"aaa"
        //"ab*a"
        //"a"
        //".*..a*"
        //"aab"
        //"c*a*b"
        //"mississippi"
        //"mis*is*ip*."
        System.out.println(new IsMatch_10().isMatch("aaabac", "a*.*c"));
        System.out.println(new IsMatch_10().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new IsMatch_10().isMatch("mississippi", "mis*is*ip*."));
        System.out.println(new IsMatch_10().isMatch("aaa", "ab*a"));
        System.out.println(new IsMatch_10().isMatch("a", ".*..a*"));
        System.out.println(new IsMatch_10().isMatch("aab", "c*a*b"));
    }
}
