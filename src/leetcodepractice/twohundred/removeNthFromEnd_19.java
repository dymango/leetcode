package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class removeNthFromEnd_19 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int index = 0;
        while (p != null) {
            if (index == n) {
                ListNode p2 = head;
                while (p.next != null) {
                    p = p.next;
                    p2 = p2.next;
                }

                if (p2.next != null) {
                    p2.next = p2.next.next;
                }

                return head;
            }

            index++;
            p = p.next;
        }

        return index > 0 ? head.next : null;
    }
}
