package app.leetcode;

import java.util.Stack;

/**
 * @author dimmy
 */
public class IsValid_1003 {

    /**
     * 给你一个字符串 s ，请你判断它是否 有效 。
     * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
     * <p>
     * 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。注意，tleft 和 tright 可能为 空 。
     * 如果字符串 s 有效，则返回 true；否则，返回 false。
     * <p>
     * <p>
     * 示例 1：
     * 输入：s = "aabcbc"
     * 输出：true
     * 解释：
     * "" -> "abc" -> "aabcbc"
     * 因此，"aabcbc" 有效。
     * <p>
     * 示例 2：
     * 输入：s = "abcabcababcc"
     * 输出：true
     * 解释：
     * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
     * 因此，"abcabcababcc" 有效。
     * <p>
     * 示例 3：
     * 输入：s = "abccba"
     * 输出：false
     * 解释：执行操作无法得到 "abccba" 。
     * <p>
     * 提示：
     * 1 <= s.length <= 2 * 104
     * s 由字母 'a'、'b' 和 'c' 组成
     *
     * @param s
     * @return
     */
    public static void main(String[] args) {
        IsValid_1003 isValid1003 = new IsValid_1003();
        System.out.println(isValid1003.isValid("aabcbc"));
        System.out.println(isValid1003.isValid("abcabcababcc"));
        System.out.println(isValid1003.isValid("abccba"));
        System.out.println(isValid1003.isValid("aabbcc"));
        System.out.println(isValid1003.isValid("aabcbc"));
        System.out.println(isValid1003.isValid("babcc"));
        System.out.println(isValid1003.isValid("abbcc"));
    }

    public boolean isValidV3(String s) {
        if (!s.startsWith("a") || s.length() % 3 != 0) return false;
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == 'a') {
                if (!stack.isEmpty() && stack.peek() == 'c') {
                    stack.pop();
                }
                stack.push('a');
            } else if (c == 'b') {
                if (!stack.isEmpty()) {
                    if (stack.peek() == 'a') stack.pop();
                    else return false;
                }
                stack.push('b');
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == 'b') stack.pop();
                    else return false;
                } else return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValidV2(String s) {
        String sCopy = s;
        while (true) {
            int index = sCopy.indexOf("abc");
            if (index == -1) break;
            sCopy = sCopy.substring(0, index) + sCopy.substring(index + 3);
        }

        return sCopy.isEmpty();
    }

    public boolean isValid(String s) {
        int index = 0;
        int length = s.length();
        int validPosition = 1;
        char[] charArray = s.toCharArray();
        boolean[] visited = new boolean[charArray.length];
        int start = 0;
        while (index < length) {
            if (visited[index]) {
                index++;
                continue;
            }
            if (validPosition == 1) {
                if (!visited[index] && charArray[index] != 'a') return false;
                else {
                    start = index;
                    visited[index] = true;
                    validPosition++;
                    index++;
                }
            } else if (validPosition == 2) {
                if (!visited[index] && charArray[index] == 'b') {
                    visited[index] = true;
                    validPosition++;
                }
                index++;
            } else if (validPosition == 3) {
                if (!visited[index] && charArray[index] == 'c') {
                    visited[index] = true;
                    validPosition = 1;
                    index = start + 1;
                    continue;
                }

                index++;
            }
        }

        for (boolean b : visited) {
            if (!b) return false;
        }

        return true;
    }
}
