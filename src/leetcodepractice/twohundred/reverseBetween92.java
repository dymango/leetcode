package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

public class reverseBetween92 {

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode vir = new ListNode(-1);
        vir.next = head;
        var vp = vir;

        int index = right - left + 1;

        int position = 0;
        while (vp != null) {
            if(position == index) {
                ListNode lp = vir;
                while (vp.next != null && position < right) {
                    vp = vp.next;
                    lp = lp.next;
                    position++;
                }

                ListNode pre = null;
                ListNode node = lp.next;
                while (node != null) {
                    var b = node == vp;
                    var temp = node.next;
                    node.next = pre;
                    pre = node;
                    node = temp;
                    if(b) {
                        var newHead = pre;
                        while (newHead.next != null) {
                            newHead = newHead.next;
                        }

                        newHead.next = temp;
                        break;
                    }
                }

                lp.next = pre;
                return vir.next;
            }

            vp = vp.next;
            position++;
        }

        return head;
    }
}
