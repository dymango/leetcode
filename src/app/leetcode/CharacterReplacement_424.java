package app.leetcode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author dimmy
 */
public class CharacterReplacement_424 {
    /**
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
     *
     * 注意:
     * 字符串长度 和 k 不会超过 104。
     *
     * 示例 1:
     *
     * 输入:
     * s = "ABAB", k = 2
     *
     * 输出:
     * 4
     *
     * 解释:
     * 用两个'A'替换为两个'B',反之亦然。
     * 示例 2:
     *
     * 输入:
     * s = "AABABBA", k = 1
     *
     * 输出:
     * 4
     *
     * 解释:
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
      Tonight class we have three types of stories. Beginner, Intermediate and Advace stories. You can pick up any story written on paper. When it's your turn, you will stand up in front of them, Tell about the story in your own words to the rest of the class      * 子串 "BBBB" 有最长重复字母, 答案为 4。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param k
     * @return
     */
    private int[] map = new int[26];

    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int historyCharMax = 0;
        for (int right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }

        return chars.length - left;
    }
}
