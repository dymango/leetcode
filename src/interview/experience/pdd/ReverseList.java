package interview.experience.pdd;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class ReverseList {

    //12345
    //21345

    public ListNode reverse(ListNode listNode) {
        ListNode virtualNode = new ListNode(-1);
        ListNode pointer = listNode;
        ListNode temp = null;
        while (pointer != null) {
            temp = virtualNode.next;
            virtualNode.next = pointer;
            pointer = pointer.next;
            virtualNode.next.next = temp;
        }

        return virtualNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode.next = listNode2;
        ListNode reverse = new ReverseList().reverse(listNode);
        int i = 1;
    }
}
