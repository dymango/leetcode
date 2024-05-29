package leetcodepractice.leetcode.tophundred;

import java.util.Stack;

/**
 * @author dimmy
 */
public class findMin_155 {

    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * 实现 MinStack 类:
     * <p>
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public findMin_155() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            helper.push(val);
            return;
        }

        stack.push(val);
        helper.push(Math.min(helper.peek(), val));
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (helper.isEmpty()) return -1;
        return helper.peek();
    }
}
