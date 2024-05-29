package leetcodepractice.leetcode;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class ReverseBetween_79 {

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     * 示例 2：
     * <p>
     * 输入：head = [5], left = 1, right = 1
     * 输出：[5]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链表中节点数目为 n
     * 1 <= n <= 500
     * -500 <= Node.val <= 500
     * 1 <= left <= right <= n
     * <p>
     * <p>
     * 进阶： 你可以使用一趟扫描完成反转吗？
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pointer = newHead;
        for (int i = 0; i < left - 1; i++) {
            pointer = pointer.next;
        }

        ListNode cur = pointer.next;
        ListNode temp;
        for (int i = 0; i < right - left; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pointer.next;
            pointer.next = temp;

        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n.next = n2;
        new ReverseBetween_79().reverseBetween(n, 2, 4);
    }
}
