package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class addTwoNumbers_2 {

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 5052
     * 505
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode hp = head;
        int pre = 0;
        while (p1 != null || p2 != null) {
            ListNode node = new ListNode(0);
            if (p1 != null) node.val += p1.val;
            if (p2 != null) node.val += p2.val;
            node.val += pre;

            if (node.val >= 10) {
                pre = node.val / 10;
                node.val = node.val % 10;
            } else {
                pre = 0;
            }


            hp.next = node;
            hp = hp.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        if(pre != 0) {
            hp.next = new ListNode(pre);
        }
        return head.next;
    }

    private ListNode reverseListNode(ListNode listNode) {
        ListNode pre = null;
        ListNode pointer = listNode;
        while (pointer != null) {
            var temp = pointer.next;
            pointer.next = pre;
            pre = pointer;
            pointer = temp;
        }

        return pre;
    }
}
