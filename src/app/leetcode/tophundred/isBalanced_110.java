package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class isBalanced_110 {

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * <p>
     * 本题中，一棵高度平衡二叉树定义为：
     * <p>
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * @param root
     * @return
     */
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int height = height(node.left);
        int height1 = height(node.right);
        if (Math.abs(height - height1) > 1) result = false;
        return Math.max(height, height1) + 1;
    }
}
