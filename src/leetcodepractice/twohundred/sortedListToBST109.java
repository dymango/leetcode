package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;
import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class sortedListToBST109 {

    //给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为
    //12 34 5
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        var p = head;
        var p2 = head.next;
        var vir = new ListNode(-1);
        vir.next = head;
        var vp = vir;
        while (p2 != null && p2.next != null) {
            vp = vp.next;
            p = p.next;
            p2 = p2.next.next;
        }

        vp.next = null;
        TreeNode treeNode = new TreeNode(p.val);
        treeNode.left = sortedListToBST(vir.next);
        treeNode.right = sortedListToBST(p.next);
        return treeNode;
    }
}
