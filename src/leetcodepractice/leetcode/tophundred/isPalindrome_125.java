package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class isPalindrome_125 {

    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     * <p>
     * 字母和数字都属于字母数字字符。
     * <p>
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!targetChar(s.charAt(start))) {
                start++;
                continue;
            }

            if (!targetChar(s.charAt(end))) {
                end--;
                continue;
            }

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    private boolean targetChar(char c) {
        if (c >= 'a' && c <= 'z') return true;
        if (c >= 'A' && c <= 'Z') return true;
        return c >= '0' && c <= '9';
    }
}
