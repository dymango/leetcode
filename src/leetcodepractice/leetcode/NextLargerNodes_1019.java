package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;
import leetcodepractice.leetcode.base.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author dimmy
 */
public class NextLargerNodes_1019 {
    /**
     * 给定一个长度为 n 的链表 head
     * <p>
     * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
     * <p>
     * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
     *
     * 找出「下一个更大的元素」是经典的可以用单调栈解决的问题。
     *
     * 我们对链表进行一次遍历，同时维护一个内部值单调递减（不是严格单调递减，可以相等）的栈。栈中的元素对应着还没有找到下一个更大的元素的那些元素，它们在栈中的顺序与它们在链表中出现的顺序一致。这也解释了为什么栈中的值是单调递减的：如果有两个元素不满足单调递减的限制，那么后一个元素大于前一个元素，与「还没有找到下一个更大的元素」相矛盾。
     *
     * 当我们遍历到链表中的值为 val 的节点时，只要它大于栈顶元素的值，我们就可以不断取出栈顶的节点，即栈顶节点的下一个更大的元素就是 val。在这之后，我们再将 val 放入栈顶，为其在后续的遍历中找到它的下一个更大的元素，同时也保证了栈的单调性。
     *
     * 细节
     *
     * 当我们取出栈顶的元素时，我们是不知道它在链表中的位置的。因此在单调栈中，我们需要额外存储一个表示位置的变量。
     *
     * @param head
     * @return
     */
    @MainParam
    ListNode arr = build();

    public ListNode build() {
        //2,7,4,3,5
        ListNode n = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(5);
//        ListNode n4 = new ListNode(3);
//        ListNode n5 = new ListNode(5);
//        n4.next = n5;
//        n3.next = n4;
        n2.next = n3;
        n.next = n2;
        return n;
    }

    @MainMethod
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> nodes = new Stack<>();
        int[] r = new int[10000];
        int i = 0;
        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            nodes.push(head);
            map.putIfAbsent(head, i);
            ListNode next = head.next;
            int y = i + 1;
            while (next != null && next.val <= head.val) {
                nodes.push(next);
                map.putIfAbsent(next, y);
                next = next.next;
                if (next == null) {
                    y++;
                    break;
                }
                while (!nodes.isEmpty() && nodes.peek().val < next.val) {
                    r[map.get(nodes.peek())] = next.val;
                    nodes.pop();
                }

                y++;
            }

            if (next != null) {
                while (!nodes.isEmpty()) {
                    r[map.get(nodes.peek())] = next.val;
                    nodes.pop();
                }
            } else {
                while (!nodes.isEmpty()) {
                    r[map.get(nodes.peek())] = 0;
                    nodes.pop();
                }

                i = y;
                break;
            }

            i = y;
            head = next;
        }

        int[] result = new int[i];
        if (i - 1 >= 0) System.arraycopy(r, 0, result, 0, i);
        return result;
    }
}
