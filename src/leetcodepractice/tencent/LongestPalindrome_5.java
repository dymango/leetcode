package leetcodepractice.tencent;

/**
 * @author dimmy
 */
public class LongestPalindrome_5 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
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
     * 示例 3：
     * <p>
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     * <p>
     * 输入：s = "ac"
     * 输出："a"
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length()) {
                if (chars[left] != chars[right]) break;
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    l = left;
                    r = right;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (chars[left] != chars[right]) break;
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    l = left;
                    r = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(l, r + 1);
    }

    public String longestPalindromeV2(String s) {
        int le = 0;
        int ri = s.length();
        int max = 0;
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                if(i==j) {
                    dp[i][j] = true;
                    continue;
                }

                if(i + 1 <= j-1 && i+1<l &&j-1>=0) {
                    boolean match = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    dp[i][j] = match;
                    if(match) {
                        if(j - i + 1 > max) {
                            max = j - i + 1;
                            le = i;
                            ri = j;
                        }
                    }
                }
            }
        }

        return s.substring(le, ri);
    }

    public static void main(String[] args) {
        LongestPalindrome_5 longestPalindrome_5 = new LongestPalindrome_5();
        System.out.println(longestPalindrome_5.longestPalindromeV2("babad"));
    }
}
