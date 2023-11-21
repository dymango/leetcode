package app.leetcode.tophundred;

import app.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class swapPairs_24 {

    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode p = h;
        while (p != null) {
            if (p.next != null && p.next.next != null) {
                ListNode temp = p.next.next;
                p.next.next = temp.next;
                temp.next = p.next;
                p.next = temp;
                p = p.next.next;
            } else {
                break;
            }
        }

        return h.next;
    }
}
