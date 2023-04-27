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
     * 输入：s = "aa", p = "a*c"
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
        for (int i = 1; i <= sLength; i++) {
            dp[i][0] = false;
        }

        //"aab", "c*a*b"
        for (int i = 0; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (i == 0) {
                    if (p.charAt(j - 1) == '*') {
                        dp[0][j] = dp[i][j - 2];
                    } else if (p.charAt(j - 1) == '.') {
                        if(j>=2 && p.charAt(j - 2) == '.') {
                            dp[0][j] = s.length() >= 2 && dp[0][Math.max(0, j - 2)];
                        } else {
                            dp[0][j] = dp[0][Math.max(0, j - 2)];
                        }
                    }
                } else {
                    if (p.charAt(j - 1) == '*') {
                        if (p.charAt(j - 2) == '.') {
                            int index = i - 1;
                            while (index >= 0) {
                                if (dp[index][j - 2]) {
                                    dp[i][j] = true;
                                    break;
                                }

                                index--;
                            }
                        } else {
                            if (s.charAt(i - 1) == p.charAt(j - 2)) {
                                char c = s.charAt(i - 1);
                                boolean match = false;
                                int index = i - 1;
                                while (index >= 0 && s.charAt(index) == c) {
                                    match = dp[index - 1][j - 2] && dp[Math.max(index, 0)][Math.max(0, j - 2)];
                                    if (match) break;
                                    index--;
                                }

                                dp[i][j] = match;
                            } else {
                                dp[i][j] = dp[i][j - 2];
                            }
                        }
                    } else {
                        dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[Math.max(0, i - 1)][Math.max(0, j - 1)];
                    }
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
//        System.out.println(new IsMatch_10().isMatch("aaabac", "a*.*c"));
//        System.out.println(new IsMatch_10().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new IsMatch_10().isMatch("mississippi", "mis*is*ip*."));
//        System.out.println(new IsMatch_10().isMatch("aaa", "ab*a"));
//        System.out.println(new IsMatch_10().isMatch("a", ".*..a*"));
//        System.out.println(new IsMatch_10().isMatch("aab", "c*a*b"));
    }
}
