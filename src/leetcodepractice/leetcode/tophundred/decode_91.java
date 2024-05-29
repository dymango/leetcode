package leetcodepractice.leetcode.tophundred;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 */
public class decode_91 {
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
     */

    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            set.add(String.valueOf(i));
        }

        int length = s.length();
        int[] count = new int[s.length()];
        count[0] = 1;
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            String substring = s.substring(i - 1, i + 1);
            if (c == '0' && !substring.startsWith("1") && !substring.startsWith("2")) return 0;
            int n = c - 49;
            if (n >= 0 && n <= 26) {
                if (set.contains(substring)) {
                    count[i] = count[i - 1] + (i > 1 ? count[i - 2] : 1);
                } else {
                    count[i] = count[i - 1];
                }

            } else {
                count[i] = i > 1 ? count[i - 2] : 1;
            }
        }

        return count[length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new decode_91().numDecodings("11106"));
        System.out.println(new decode_91().numDecodings("12"));
        System.out.println(new decode_91().numDecodings("226"));
        System.out.println(new decode_91().numDecodings("06"));
    }
}
