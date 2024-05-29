package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class isSymmetric_101 {

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode node, TreeNode node2) {
        if(node == null && node2 == null) return true;
        if(node == null || node2 == null) return false;
        if(node.val != node2.val) return false;
        return compare(node.left, node2.right) && compare(node.right, node2.left);
    }
}
