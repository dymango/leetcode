package interview.prepare.temp;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class Algorithm {

    // 1 2345
    //21345
    //32145
    public ListNode reverseNode(ListNode node) {
        ListNode rn = null;
        var pointer = node;
        while (pointer != null) {
            ListNode next = pointer.next;
            pointer.next = rn;
            rn = pointer;
            pointer = next;
        }

        return rn;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        ListNode listNode = new Algorithm().reverseNode(n1);
        int i = 1;
    }
}
