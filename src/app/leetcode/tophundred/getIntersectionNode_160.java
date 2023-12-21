package app.leetcode.tophundred;

import app.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class getIntersectionNode_160 {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * <p>
     * 图示两个链表在节点 c1 开始相交：
     * <p>
     * ：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ap = headA;
        ListNode bp = headB;
        int arount = 0;
        int brount = 0;
        while (arount < 2 && brount < 2) {
            if (ap == null) {
                ap = headB;
                arount++;
            }

            if (bp == null) {
                bp = headA;
                brount++;
            }

            if (ap == bp) {
                return ap;
            }

            ap = ap.next;
            bp = bp.next;
        }

        return null;
    }

}
