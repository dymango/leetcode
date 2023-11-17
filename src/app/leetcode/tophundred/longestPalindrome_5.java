package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class longestPalindrome_5 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int max = 1;
        String resultStr = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    int l = right - left + 1;
                    if (l > max) {
                        max = l;
                        resultStr = s.substring(left, right + 1);
                    }

                } else {
                    break;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    int l = right - left + 1;
                    if (l > max) {
                        max = l;
                        resultStr = s.substring(left, right + 1);
                    }
                } else {
                    break;
                }
                left--;
                right++;
            }
        }

        return resultStr;
    }
}
