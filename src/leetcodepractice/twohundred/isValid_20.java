package leetcodepractice.twohundred;

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
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                var pop = stack.pop();
                if (c == ')' && pop != '(') return false;
                else if (c == '}' && pop != '{') return false;
                else if (c == ']' && pop != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
