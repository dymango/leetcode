package leetcodepractice.twohundred;

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
        var virtual = new ListNode(-1);
        var vp = virtual;
        var p1 = list1;
        var p2 = list2;
        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    ListNode temp = p1.next;
                    p1.next = null;
                    vp.next = p1;
                    vp = vp.next;
                    p1 = temp;
                } else {
                    ListNode temp = p2.next;
                    p2.next = null;
                    vp.next = p2;
                    vp = vp.next;
                    p2 = temp;
                }
            } else if (p1 != null) {
                ListNode temp = p1.next;
                p1.next = null;
                vp.next = p1;
                vp = vp.next;
                p1 = temp;
            } else {
                ListNode temp = p2.next;
                p2.next = null;
                vp.next = p2;
                vp = vp.next;
                p2 = temp;
            }
        }

        return virtual.next;
    }
}
