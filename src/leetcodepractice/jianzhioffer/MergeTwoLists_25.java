package leetcodepractice.jianzhioffer;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class MergeTwoLists_25 {

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * <p>
     * 示例1：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 限制：
     * <p>
     * 0 <= 链表长度 <= 1000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int headValue;
         if (l1.val > l2.val) {
                headValue = l2.val;
                l2 = l2.next;
            } else {
                headValue = l1.val;
                l1= l1.next;
        }
        ListNode listNode = new ListNode(headValue);
        ListNode pointer = listNode;
        while (l1 != null || l2 != null) {
            int nodeValue;
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    nodeValue = l2.val;
                    l2 = l2.next;
                } else {
                    nodeValue = l1.val;
                    l1 = l1.next;
                }
            } else if (l1 != null) {
                nodeValue = l1.val;
                l1 = l1.next;
            } else {
                nodeValue = l2.val;
                l2 = l2.next;
            }

            pointer.next = new ListNode(nodeValue);
            pointer = pointer.next;
        }

        return listNode;
    }
}
