package leetcodepractice.jianzhioffer;

import java.util.Stack;

/**
 * @author dimmy
 */
public class MinStack_30 {

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     *
     * 示例:
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.min();   --> 返回 -2.
     *  
     *
     * 提示：
     *
     * 各函数的调用总次数不超过 20000 次
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * initialize your data structure here.
     */
    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();


    public MinStack_30() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            if (minStack.peek() >= x) minStack.push(x);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if(!minStack.empty() && minStack.peek().equals(pop)) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack_30 minStack_30 = new MinStack_30();
        minStack_30.push(-2);
        minStack_30.push(0);
        minStack_30.push(-3);
        System.out.println(minStack_30.min());
        minStack_30.pop();
        System.out.println(minStack_30.top());
        System.out.println(minStack_30.min());
        int i = 1;
    }
}
