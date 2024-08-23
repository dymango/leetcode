package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class swapPairs24 {

    //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        //1234
        //2143
        var vir = new ListNode(-1);
        vir.next = head;
        var p1 = vir.next;
        var p2 = p1.next;
        var pre = vir;
        while (p1 != null && p2 != null) {
            var tp1 = p2.next;
            var tp2 =  tp1 == null ? null : tp1.next;

            p1.next = tp1;
            p2.next = p1;
            pre.next = p2;

            pre = p1;
            p1 = tp1;
            p2 = tp2;
        }

        return vir.next;
    }
}
