package app.leetcode;

import app.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
