package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

public class deleteDuplicates82 {

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode vir = new ListNode(-1);
        vir.next = head;
        var pre = vir;
        var p = pre.next;
        var p2 = p.next;
        while (p2 != null) {
            if (p.val == p2.val) {
                var find = p2;
                while (find != null && find.val == p2.val) {
                    find = find.next;
                }

                pre.next = find;
                p = pre;
                p2 = p.next == null ? null : p.next;
            } else {
                pre = p;
                p = p.next;
                p2 = p2.next;
            }
        }

        return vir.next;
    }
}
