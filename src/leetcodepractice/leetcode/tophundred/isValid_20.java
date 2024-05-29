package leetcodepractice.leetcode.tophundred;

import java.util.Stack;

/**
 * @author dimmy
 */
public class isValid_20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     * <p>
     * 输入：s = "(]"
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (c == ')' && pop != '(') return false;
                if (c == ']' && pop != '[') return false;
                if (c == '}' && pop != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}
