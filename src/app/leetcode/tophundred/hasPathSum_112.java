package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class hasPathSum_112 {

    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int left = targetSum - root.val;
        if (root.left == null && root.right == null) return left == 0;
        return hasPathSum(root.left, left) || hasPathSum(root.right, left);
    }
}
