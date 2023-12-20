package app.leetcode.tophundred;

import java.util.Stack;

/**
 * @author dimmy
 */
public class evalRPN_150 {

    /**
     * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
     * 请你计算该表达式。返回一个表示表达式值的整数。
     * <p>
     * 注意：
     * <p>
     * 有效的算符为 '+'、'-'、'*' 和 '/' 。
     * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
     * 两个整数之间的除法总是 向零截断 。
     * 表达式中不含除零运算。
     * 输入是一个根据逆波兰表示法表示的算术表达式。
     * 答案及所有中间计算结果可以用 32 位 整数表示。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：tokens = ["2","1","+","3","*"]
     * 输出：9
     * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     * 示例 2：
     * <p>
     * 输入：tokens = ["4","13","5","/","+"]
     * 输出：6
     * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> numStack.push(numStack.pop() + numStack.pop());
                case "-" -> {
                    Integer pop = numStack.pop();
                    Integer pop2 = numStack.pop();
                    numStack.push(pop2 - pop);
                }
                case "*" -> numStack.push(numStack.pop() * numStack.pop());
                case "/" -> {
                    Integer pop = numStack.pop();
                    Integer pop2 = numStack.pop();
                    numStack.push(pop2 / pop);
                }
                default -> numStack.push(Integer.parseInt(token));
            }
        }

        return numStack.pop();
    }
}
