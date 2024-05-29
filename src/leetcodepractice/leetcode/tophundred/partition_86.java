package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class partition_86 {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode lp = left;
        ListNode right = new ListNode(-1);
        ListNode rp = right;

        ListNode hp = head;
        while (hp != null) {
            ListNode tempNode = hp;
            ListNode next = hp.next;
            tempNode.next = null;
            if (tempNode.val < x) {
                lp.next = tempNode;
                lp = lp.next;
            } else {
                rp.next = tempNode;
                rp = rp.next;
            }

            hp = next;
        }

        lp.next = right.next;
        return left.next;
    }
}
