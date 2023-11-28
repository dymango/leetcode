package app.leetcode.tophundred;

import app.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class rotateRight_61 {

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode point = head;
        while (point != null) {
            length++;
            point = point.next;
        }

        point = head;
        int index = 0;
        while (point != null) {
            if (index == length - (k%length) - 1) {
                ListNode virtualNode = new ListNode(-1);
                virtualNode.next = point.next;
                point.next = null;
                ListNode vp = virtualNode;
                while (vp.next != null) {
                    vp = vp.next;
                }

                vp.next = head;
                return virtualNode.next;
            }

            index++;
            point = point.next;
        }

        return null;
    }
}
