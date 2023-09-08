package app.leetcode;

import app.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class DeleteDuplicates_82 {

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * 示例 2：
     * <p>
     * <p>
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode virtual = new ListNode(-1);
        ListNode pointer = virtual;
        ListNode hp = head;
        while (hp != null) {
            if (hp.next == null || hp.val != hp.next.val) {
                pointer.next = hp;
                pointer = pointer.next;
                hp = hp.next;
                continue;
            }

            int n = hp.val;
            while (hp != null && hp.val == n) {
                hp = hp.next;
            }

            if(hp == null) {
                pointer.next = null;
            }
        }

        return virtual.next;
    }
}
