package app.tencent;

import app.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class MergeTwoLists_21 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * 示例 1：
     * <p>
     * <p>
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * <p>
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     *  
     * <p>
     * 提示：
     * <p>
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        ListNode l1pointer = l1;
        ListNode l2pointer = l2;
        while (l1pointer != null || l2pointer != null) {
            ListNode n;
            if (l1pointer != null && l2pointer != null) {
                int temp;
                if (l1pointer.val <= l2pointer.val) {
                    temp = l1pointer.val;
                    l1pointer = l1pointer.next;
                } else {
                    temp = l2pointer.val;
                    l2pointer = l2pointer.next;
                }

                n = new ListNode(temp);
            } else if (l1pointer != null) {
                n = new ListNode(l1pointer.val);
                l1pointer = l1pointer.next;
            } else {
                n = new ListNode(l2pointer.val);
                l2pointer = l2pointer.next;
            }

            pointer.next = n;
            pointer = pointer.next;
        }

        return head.next;
    }
}
