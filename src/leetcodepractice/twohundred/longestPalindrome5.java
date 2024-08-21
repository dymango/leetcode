package leetcodepractice.twohundred;

import leetcodepractice.LeetCode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class longestPalindrome5 {

    /**
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            var start = i;
            var end = i;
            while (start >= 0 && end < s.length()) {
                if (s.charAt(start) != s.charAt(end)) {
                    break;
                }

                String str = s.substring(start, end + 1);
                if (str.length() > max.length()) max = str;
                start--;
                end++;
            }

            start = i;
            end = i + 1;
            if (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                while (start >= 0 && end < s.length()) {
                    if (s.charAt(start) != s.charAt(end)) {
                        break;
                    }

                    String str = s.substring(start, end + 1);
                    if (str.length() > max.length()) max = str;
                    start--;
                    end++;
                }
            }

        }
        return max;
    }

    public String longestPalindromeV2(String s) {
        int[] max = new int[s.length()];
        Arrays.fill(max, 1);
        String str = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                max[i] = Math.max(max[i], 2);
            }
            var max1 = max[i - 1];
            if (i - max1 - 1 >= 0 && s.charAt(i) == s.charAt(i - max1 - 1)) {
                max[i] = Math.max(max[i], max[i - 1] + 1);
            }

            if (max[i] > str.length()) {
                str = s.substring(i - max[i] - 1, i + 1);
            }
        }

        return str;
    }

    public String longestPalindromeV3(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
