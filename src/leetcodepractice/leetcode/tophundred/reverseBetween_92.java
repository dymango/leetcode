package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class reverseBetween_92 {

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode virtualNode = new ListNode(-1);
        ListNode vp = virtualNode;
        virtualNode.next = head;
        for (int i = 0; i < left - 1; i++) {
            virtualNode = virtualNode.next;
        }

        ListNode cur = virtualNode.next;
        int length = right - left;
        for (int i = 0; i < length; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = virtualNode.next;
            virtualNode.next = temp;
        }
        //13245
        //

        return vp.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        n1.next = n2;
        new reverseBetween_92().reverseBetween(n1, 1,2);

    }
}
