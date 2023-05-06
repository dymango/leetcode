package app.leetcode;

import app.leetcode.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class RotateString_796 {

    /**
     * 给定两个字符串, A 和 B。
     * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
     *
     * 示例 1:
     * 输入: A = 'abcde', B = 'cdeab'
     * 输出: true
     *
     * 示例 2:
     * 输入: A = 'abcde', B = 'abced'
     * 输出: false
     * 注意：
     *
     * A 和 B 长度不超过 100。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        Map<Character, List<Character>> characterListMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i == chars.length - 1) {
                characterListMap.putIfAbsent(chars[i], new ArrayList<>());
                characterListMap.get(chars[i]).add(chars[0]);
                continue;
            }

            characterListMap.putIfAbsent(chars[i], new ArrayList<>());
            characterListMap.get(chars[i]).add(chars[i + 1]);
        }

        char[] goalChars = goal.toCharArray();
        for (int i = 0; i < goalChars.length; i++) {
            if(i == goalChars.length - 1) {
                if(!characterListMap.get(goalChars[i]).contains(goalChars[0])) return false;
                continue;
            }
            if(!characterListMap.get(goalChars[i]).contains(goalChars[i + 1])) return false;
        }

        return true;
    }
}
