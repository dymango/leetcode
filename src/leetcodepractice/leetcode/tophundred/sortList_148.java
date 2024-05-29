package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class sortList_148 {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     * [4,2,1,3]
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode sortedLeft = sortList(head);
        ListNode sortedRight = sortList(rightHead);
        ListNode virtualHead = new ListNode(-1);
        ListNode vp = virtualHead;
        while (sortedLeft != null && sortedRight != null) {
            if (sortedLeft.val <= sortedRight.val) {
                vp.next = sortedLeft;
                sortedLeft = sortedLeft.next;
            } else {
                vp.next = sortedRight;
                sortedRight = sortedRight.next;
            }

            vp = vp.next;
        }

        vp.next = sortedLeft != null ? sortedLeft : sortedRight;
        return virtualHead.next;
    }

    public ListNode sortListV2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(1);
//        ListNode n4 = new ListNode(3);
//        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        ListNode listNode = new sortList_148().sortList(n1);
        int i = 1;
    }
}
