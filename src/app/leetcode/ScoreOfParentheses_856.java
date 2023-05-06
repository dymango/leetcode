package app.leetcode;

import java.util.Stack;

/**
 * @author dimmy
 */
public class ScoreOfParentheses_856 {

    /**
     * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
     * () 得 1 分。
     * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
     * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
     *  
     *
     * 示例 1：
     *
     * 输入： "()"
     * 输出： 1
     * 示例 2：
     *
     * 输入： "(())"
     * 输出： 2
     * 示例 3：
     *
     * 输入： "()()"
     * 输出： 2
     * 示例 4：
     *
     * 输入： "(()(()))"
     * 输出： 6
     *  
     *
     * 提示：
     *
     * S 是平衡括号字符串，且只含有 ( 和 ) 。
     * 2 <= S.length <= 50
     *
     * @param s
     * @return
     */
    public static void main(String[] args) {
        ScoreOfParentheses_856 scoreOfParentheses_856 = new ScoreOfParentheses_856();
        System.out.println(scoreOfParentheses_856.scoreOfParentheses("(()(()))"));
        System.out.println(scoreOfParentheses_856.scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses_856.scoreOfParentheses("(())"));
        System.out.println(scoreOfParentheses_856.scoreOfParentheses("()"));
    }
    public int scoreOfParentheses(String s) {
        int value = 0;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i] == '(') {
                int index = i + 1;
                int count = 1;
                while (index < charArr.length) {
                    if(charArr[index] == ')') count--;
                    else count++;
                    if(count == 0) {
                        if(index - i > 1) {
                            value += 2*scoreOfParentheses(s.substring(i + 1, index));
                        } else {
                            value += 1;
                        }

                        i = index;
                        break;
                    }
                    index++;
                }
            }
        }

        return value;
    }

    /**
     * official answer
     * @param S
     * @return
     */
    public int scoreOfParenthesesV2(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }
}
