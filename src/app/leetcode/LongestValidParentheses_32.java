package app.leetcode;

import java.util.Stack;

/**
 * @author dimmy
 */
public class LongestValidParentheses_32 {

    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     * <p>
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     * <p>
     * 输入：s = ""
     * 输出：0
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 3 * 104
     * s[i] 为 '(' 或 ')'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Node> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int current = 0;
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.add(new Node(aChar, current));
                current = 0;
            } else {
                if (!stack.isEmpty()) {
                    Node peek = stack.peek();
                    if (peek.c == '(') {
                        stack.pop();
                        int b = current + peek.leftSize + 2;
                        max = Math.max(max, b);
                        current = b;
                    } else {
                        stack.add(new Node(')', 0));
                        current = 0;
                    }
                } else {
                    stack.add(new Node(')', 0));
                    current = 0;
                }
            }
        }

        return max;
    }

    public static class Node {
        char c;
        int leftSize;

        public Node(char c, int leftSize) {
            this.c = c;
            this.leftSize = leftSize;
        }
    }

    public static void main(String[] args) {
        //")()())()()("
        System.out.println(new LongestValidParentheses_32().longestValidParentheses(")(()()))"));
        System.out.println(new LongestValidParentheses_32().longestValidParentheses("()"));
        System.out.println(new LongestValidParentheses_32().longestValidParentheses("()(())"));
        System.out.println(new LongestValidParentheses_32().longestValidParentheses(")()())()()("));
        System.out.println(new LongestValidParentheses_32().longestValidParentheses("(()))())("));

    }
}
