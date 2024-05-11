package app.leetcode;

import app.executor.MainMethod;

import java.util.Stack;

/**
 * @author dimmy
 */
public class Clumsy_1006 {

    /**
     * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
     * <p>
     * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
     * <p>
     * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
     * <p>
     * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
     * <p>
     * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
     * <p>
     * 示例 1：
     * <p>
     * 输入：4
     * 输出：7
     * 解释：7 = 4 * 3 / 2 + 1
     * 示例 2：
     * <p>
     * 输入：10
     * 输出：12
     * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
     *
     * @param n
     * @return
     */

    @MainMethod
    public int clumsy(int n) {
        Stack<Integer> stack = new Stack<>();
        int opera = 1;
        stack.push(n);
        for (int i = n - 1; i >= 1; i--) {
            if (opera < 3) {
                Integer pop = stack.pop();
                stack.push(cal(pop, i, opera));
            } else {
                if(opera == 3) {
                    int sum = stack.stream().mapToInt(value -> value).reduce((left, right) -> left - right).orElse(0);
                    stack.clear();
                    stack.push(sum);
                    Integer pop = stack.pop();
                    stack.push(cal(pop, i, opera));
                } else {
                    stack.push(i);
                }

            }

            opera++;
            if (opera > 4) opera = 1;
        }

        return stack.stream().mapToInt(value -> value).reduce((left, right) -> left - right).orElse(0);
    }

    private int cal(int a, int b, int opera) {
        if (opera == 1) return a * b;
        if (opera == 2) return a / b;
        if (opera == 3) return a + b;
        return a - b;
    }
}
