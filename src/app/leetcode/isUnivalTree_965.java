package app.leetcode;

import app.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class isUnivalTree_965 {

    /**
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     * <p>
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     *
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null) {
            return root.val == root.left.val && root.val == root.right.val && isUnivalTree(root.left) && isUnivalTree(root.right);
        }
        if (root.left != null) return root.val == root.left.val && isUnivalTree(root.left);
        return root.val == root.right.val && isUnivalTree(root.right);
    }
}
