package leetcodepractice.twohundred;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

/**
 * @author dimmy
 */
public class isMatch_10 {

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入：s = "aa", p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     * <p>
     * 输入：s = "ab", p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 20
     * 1 <= p.length <= 20
     * s 只包含从 a-z 的小写字母。
     * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     * <p>
     * <p>
     * match[x][y] = match[x - 1][y - 1] & y = * & x = x- 1
     *
     * @param s
     * @param p
     * @return
     */
    @MainParam
    String s = "b";
    @MainParam
    String s2 = "b*";

    //"aaa"
    //p =
    //"ab*a"
    //"mississippi"
    //p =
    //"mis*is*ip*."
    //"aaa"
    //p =
    //"ab*ac*a"

    /**
     * "a"
     * p =
     * ".*..a*"
     *
     * "aab"
     * p =
     * "c*a*b"
     *
     * "ab"
     * p =
     * ".*.."
     *
     * s =
     * "b"
     * p =
     * "b*"
     * @param s
     * @param p
     * @return
     */

    @MainMethod
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        var row = match.length;
        var col = match[0].length;
        for (int i = 1; i < col; i++) {
            var c = p.charAt(i - 1);
            if (c == '.') {
                match[0][i] = false;
            } else if (c == '*') {
                match[0][i] = i - 2 < 0 || match[0][i - 2];
            } else {
                match[0][i] = false;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                var sCharIndex = i - 1;
                var pCharIndex = j - 1;
                var sc = s.charAt(sCharIndex);
                var pc = p.charAt(pCharIndex);
                if (pc == '.') {
                    match[i][j] = match[i - 1][j - 1];
                } else if (pc == '*') {
                    var pre = p.charAt(pCharIndex - 1);
                    if (pre == '.') {
                        match[i][j] = false;
                        for (int k = i; k >= 0; k--) {
                            match[i][j] = match[k][j - 2];
                            if (match[i][j]) break;
                        }
                    } else {
                        match[i][j] = match[i - 1][j - 1] && sc == p.charAt(pCharIndex - 1)
                            || match[i - 1][j] && pCharIndex > 0 && sc == p.charAt(pCharIndex - 1)
                            || match[i][j - 2];
                    }
                } else {
                    match[i][j] = match[i - 1][j - 1] && sc == pc;
                }

                if(i == 7 && j == 7) {
                    int y = 1;
                }

            }
        }

        return match[s.length()][p.length()];
    }

    private boolean check(String s, int a, String s2, int b) {
        if (a < 0 || a >= s.length() || b < 0 || b >= s2.length()) return true;
        return s.charAt(a) == s2.charAt(b);

    }
}
