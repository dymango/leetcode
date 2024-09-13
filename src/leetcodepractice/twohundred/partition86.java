package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

public class partition86 {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        var vir = new ListNode(-1);
        var vir2 = new ListNode(-1);
        var vp = vir;
        var vp2 = vir2;
        var p = head;
        while (p != null) {
            if(p.val < x) {
                var temp = p.next;
                p.next = null;
                vp.next = p;
                vp = vp.next;
                p = temp;
            } else {
                var temp = p.next;
                p.next = null;
                vp2.next = p;
                vp2 = vp2.next;
                p = temp;
            }
        }

        vp.next =  vir2.next;
        return vir.next;
    }
}
