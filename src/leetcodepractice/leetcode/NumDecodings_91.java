package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class NumDecodings_91 {

    /**
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     * <p>
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
     * <p>
     * "AAJF" ，将消息分组为 (1 1 10 6)
     * "KJF" ，将消息分组为 (11 10 6)
     * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
     * <p>
     * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
     * <p>
     * 题目数据保证答案肯定是一个 32 位 的整数。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "12"
     * 输出：2
     * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2：
     * <p>
     * 输入：s = "226"
     * 输出：3
     * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     * 示例 3：
     * <p>
     * 输入：s = "06"
     * 输出：0
     * 解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 100
     * s 只包含数字，并且可能包含前导零。
     *
     * @param s
     * @return
     */
    String S;


    public static void main(String[] args) {
//        System.out.println(new NumDecodings_91().numDecodings("111111111111111111111111111111111111111111111"));
//        System.out.println(new NumDecodings_91().numDecodings("2611055971756562"));
//        System.out.println(new NumDecodings_91().numDecodings("226"));
//        System.out.println(new NumDecodings_91().numDecodings("206"));
        System.out.println(new NumDecodings_91().numDecodings("500"));
        System.out.println(new NumDecodings_91().numDecodings("12"));
        System.out.println(new NumDecodings_91().numDecodings("1242161"));
    }


    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length];
        char c = s.charAt(0);
        dp[0] = c >= 49 && c <= 57 ? 1 : 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '0') {
                int n = Integer.parseInt(s.substring(i - 1, i + 1));
                if (n > 0 && n <= 26) {
                    dp[i] = (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = 0;
                }
                continue;
            }

            int n = Integer.parseInt(s.substring(i - 1, i + 1));
            if (s.charAt(i - 1) != '0' && n > 0 && n <= 26) dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
            else dp[i] = dp[i - 1];
        }

        return dp[length - 1];
    }

    private void print(List<?> wildcardList) {
        for (Object o : wildcardList) {
            System.out.println(o.toString());
        }
    }

    private Set<String> count(int start, int end) {
        List<NumDecodings_91> wildcardList = new ArrayList<NumDecodings_91>();
        print(wildcardList);

        if (start > end) return Collections.emptySet();
        if (S.charAt(start) == '0') return Collections.emptySet();
        if (start == end) {
            return Set.of(String.valueOf((char) (S.charAt(start) - 49 + 65)));
        }

        Set<String> set = new HashSet<>();
        if (end - start < 2) {
            String substring = S.substring(start, end + 1);
            int n = Integer.parseInt(substring);
            if (n >= 1 && n <= 26) set.add(String.valueOf((char) (n + 64)));
        }

        for (int i = start; i <= end - 1; i++) {
            Set<String> leftList = count(start, i);
            Set<String> rightList = count(i + 1, end);
            if (leftList.isEmpty() || rightList.isEmpty()) continue;
            for (String s : leftList) {
                for (String string : rightList) {
                    set.add(s + string);
                }
            }
        }

        return set;
    }
}
