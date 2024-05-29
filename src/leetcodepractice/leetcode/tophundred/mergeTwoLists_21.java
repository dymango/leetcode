package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class mergeTwoLists_21 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                p.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            p = p.next;
        }

        while (list1 != null) {
            p.next = new ListNode(list1.val);
            p = p.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            p.next = new ListNode(list2.val);
            p = p.next;
            list2 = list2.next;
        }

        return head.next;
    }
}
