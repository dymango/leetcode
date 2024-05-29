package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author dimmy
 */
public class FreqStack_895 {

    /**
     * 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
     * <p>
     * 实现 FreqStack 类:
     * <p>
     * FreqStack() 构造一个空的堆栈。
     * void push(int val) 将一个整数 val 压入栈顶。
     * int pop() 删除并返回堆栈中出现频率最高的元素。
     * 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
     * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
     * 输出：[null,null,null,null,null,null,null,5,7,5,4]
     * 解释：
     * FreqStack = new FreqStack();
     * freqStack.push (5);//堆栈为 [5]
     * freqStack.push (7);//堆栈是 [5,7]
     * freqStack.push (5);//堆栈是 [5,7,5]
     * freqStack.push (7);//堆栈是 [5,7,5,7]
     * freqStack.push (4);//堆栈是 [5,7,5,7,4]
     * freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
     * freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
     * freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
     * freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
     * freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= val <= 109
     * push 和 pop 的操作数不大于 2 * 104。
     * 输入保证在调用 pop 之前堆栈中至少有一个元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-frequency-stack
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static class Node {
        private Integer number;
        private Integer quantity;

        public Node(Integer number, Integer quantity) {
            this.number = number;
            this.quantity = quantity;
        }
    }

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack_895() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq)
            maxfreq = f;

        group.computeIfAbsent(f, z-> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }

}
