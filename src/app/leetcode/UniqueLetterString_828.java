package app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class UniqueLetterString_828 {

    /**
     * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
     * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
     * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。注意，某些子字符串可能是重复的，
     * 但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
     * 由于答案可能非常大，请将结果 mod 10 ^ 9 + 7 后再返回。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: s = "ABC"
     * 输出: 10
     * 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
     * 其中，每一个子串都由独特字符构成。
     * 所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
     * 示例 2：
     * <p>
     * 输入: s = "ABA"
     * 输出: 8
     * 解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
     * 示例 3：
     * <p>
     * 输入：s = "LEETCODE"
     * 输出：92
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 10^4
     * s 只包含大写英文字符
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-unique-characters-of-all-substrings-of-a-given-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int uniqueLetterString(String s) {
        int[] preSameCharIndex = new int[s.length()];
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer integer = indexMap.get(s.charAt(i));
            if (integer != null) {
                preSameCharIndex[i] = integer;
            } else {
                preSameCharIndex[i] = i;
            }

            indexMap.put(s.charAt(i), i);
        }

        int l = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[l][24];
        int level = 0;
        for (int i = level; i < l; i++) {
            if (i == 0) {
                dp[i][chars[i] - 97] = 1;
                continue;
            }

            if (dp[i - 1][chars[i] - 97] == 0) {
                //未出现
                int num = 0;
                for (int j = 0; j < 24; j++) {
                    if (dp[i - 1][j] != 0) {
                        num = dp[i][j] = dp[i - 1][j] + 1;
                    }
                }

                dp[i][chars[i] - 97] = num;
            } else {

            }
        }

        return l;
    }
}
