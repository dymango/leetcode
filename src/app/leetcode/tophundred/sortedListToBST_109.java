package app.leetcode.tophundred;

import app.leetcode.base.ListNode;
import app.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class sortedListToBST_109 {

    /**
     * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
     * <p>
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        return buildTree(list, 0, list.size() - 1);
    }

    private TreeNode buildTree(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int middle = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(middle));
        node.left = buildTree(list, start, middle - 1);
        node.right = buildTree(list, middle + 1, end);
        return node;
    }
}
