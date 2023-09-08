package app.leetcode;

/**
 * @author dimmy
 */
public class IsInterleave_97 {

    /**
     * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
     * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
     * <p>
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
     * 注意：a + b 意味着字符串 a 和 b 连接。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：s1 = "", s2 = "", s3 = ""
     * 输出：true
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= s1.length, s2.length <= 100
     * 0 <= s3.length <= 200
     * s1、s2、和 s3 都由小写英文字母组成
     * <p>
     * <p>
     * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */

    public static void main(String[] args) {
        System.out.println(new IsInterleave_97().isInterleave("a", "", "aa"));
//        System.out.println(new IsInterleave_97().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    //：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() +s2.length()) return false;
        int s1l = s1.length();
        int s2l = s2.length();
        boolean[][] dp = new boolean[s1l + 1][s2l + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1l; i++) {
            dp[i + 1][0] = s3.substring(0, i + 1).equals(s1.substring(0, i + 1));
        }

        for (int i = 0; i < s2l; i++) {
            dp[0][i + 1] = s3.substring(0, i + 1).equals(s2.substring(0, i + 1));
        }

        for (int i = 1; i < s1l + 1; i++) {
            for (int j = 1; j < s2l + 1; j++) {
                int index = i + j - 1;
                boolean b = s2.charAt(j - 1) == s3.charAt(index) && dp[i][j - 1];
                boolean b2 = s1.charAt(i - 1) == s3.charAt(index) && dp[i - 1][j];
                dp[i][j] = b || b2;
            }
        }

        return dp[s1l][s2l];
    }


}
