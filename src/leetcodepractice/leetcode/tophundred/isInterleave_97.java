package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class isInterleave_97 {

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
     * ：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出：true
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int length = s1.length();
        int length2 = s2.length();
        boolean[][] join = new boolean[length + 1][length2 + 1];
        join[0][0] = true;

        for (int i = 1; i <= length; i++) {
            String substring = s1.substring(0, i);
            join[i][0] = substring.equals(s3.substring(0, i));
        }

        for (int i = 1; i <= length2; i++) {
            String substring = s2.substring(0, i);
            join[0][i] = substring.equals(s3.substring(0, i));
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length2; j++) {
                int s3l = i + j;
                char s3c = s3.charAt(s3l - 1);
                char s1c = s1.charAt(i - 1);
                boolean s1Match = s1c == s3c && join[i - 1][j];
                char s2c = s2.charAt(j - 1);
                boolean s2Match = s2c == s3c && join[i][j - 1];
                join[i][j] = s1Match || s2Match;
            }
        }


        return join[length][length2];
    }

    public static void main(String[] args) {
        new isInterleave_97().isInterleave("aabcc", "dbbca", "aadbbcbcac");
        //潮汐全能魂守冰女暗牧
        //人马火猫巨魔舞姬圣堂
        //骷髅末日神灵天怒幻刺
    }
}
