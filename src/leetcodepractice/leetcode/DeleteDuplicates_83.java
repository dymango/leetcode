package leetcodepractice.leetcode;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class DeleteDuplicates_83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;
        while (pointer != null && pointer.next != null) {
            if (pointer.next.val == pointer.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }

        return head;
    }

}
