package leetcodepractice.twohundred;

public class isInterleave97 {

    /**
     * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
     * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空
     * 子字符串
     * <p>
     * <p>
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
     * 注意：a + b 意味着字符串 a 和 b 连接。
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new isInterleave97().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];
        match[0][0] = true;
        for (int i = 1; i <= s3.length(); i++) {
            for (int j = 0; j <= s1.length(); j++) {
                for (int k = 0; k <= s2.length(); k++) {
                    if (j == 0 && k == 0) continue;
                    if (j == 0) {
                        match[j][k] = s2.charAt(k - 1) == s3.charAt(i - 1) && match[j][k - 1];
                    } else if (k == 0) {
                        match[j][k] = s1.charAt(j - 1) == s3.charAt(i - 1) && match[j - 1][k];
                    } else {
                        match[j][k] = s2.charAt(k - 1) == s3.charAt(i - 1) && match[j][k - 1]
                            || s1.charAt(j - 1) == s3.charAt(i - 1) && match[j - 1][k];
                    }
                }
            }
        }

        return match[s1.length()][s2.length()];
    }

    public boolean isInterleaveV2(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] match = new boolean[s1.length() + 1][ s2.length() + 1];
        match[0][0] = true;
        for (int i = 1; i < s2.length(); i++) {
            match[0][i] = s3.charAt(i - 1) == s2.charAt(i - 1) && match[0][i - 1];
        }

        for (int i = 1; i < s1.length(); i++) {
            match[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) && match[i - 1][0];
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int s3position = i + j;
                match[i][j] = s1.charAt(i - 1) == s3.charAt(s3position) && match[i - 1][j]
                || s2.charAt(j - 1) == s2.charAt(s3position) && match[i][j - 1];
            }
        }

        return match[s1.length()][s2.length()];

    }
}
