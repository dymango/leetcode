package leetcodepractice.twohundred;

import java.util.Stack;

/**
 * @author dimmy
 */
public class MinStack155 {
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
     * <p>
     * -231 <= val <= 231 - 1
     * pop、top 和 getMin 操作总是在 非空栈 上调用
     * push, pop, top, and getMin最多被调用 3 * 104 次
     */

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minMemory = new Stack<>();


    public MinStack155() {

    }

    public void push(int val) {
        stack.push(val);
        if (minMemory.isEmpty()) {
            minMemory.push(val);
        } else {
            minMemory.push(Math.min(minMemory.peek(), val));
        }
    }

    public void pop() {
        minMemory.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minMemory.peek();
    }

}
