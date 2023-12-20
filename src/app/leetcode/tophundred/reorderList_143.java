package app.leetcode.tophundred;

import app.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author dimmy
 */
public class reorderList_143 {

    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     * L0 → L1 → … → Ln - 1 → Ln
     * 请将其重新排列后变为：
     * <p>
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        //[1,2,3,4,5]
        //输出：[1,5,2,4,3]
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        int l = 0;
        while (p != null) {
            stack.add(p);
            l++;
            p = p.next;
        }

        p = head;
        boolean origin = true;
        int count = 0;
        while (p != null) {
            if (origin) {
                ListNode pop = stack.pop();
                pop.next = null;
                ListNode t = p.next;
                p.next = pop;
                pop.next = t;
                origin = false;
            } else {
                origin = true;
            }

            count++;
            if (count == l) p.next = null;
            p = p.next;
        }
    }
}
