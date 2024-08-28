package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class detectCycle142 {

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 不允许修改 链表。
     *
     * @param head
     * @return head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点
     */

    public static void main(String[] args) {
        var listNode = new ListNode(3);
        var listNode2 = new ListNode(2);
        var listNode3 = new ListNode(0);
        var listNode4 = new ListNode(-4);
        listNode4.next = listNode2;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode.next = listNode2;
        new detectCycle142().detectCycle(listNode);
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                var hp = head;
                if(slow.next == hp) return slow;
                while (hp != slow) {
                    hp = hp.next;
                    slow = slow.next;
                }
                return hp;
            }
        }

        return null;
    }
}
