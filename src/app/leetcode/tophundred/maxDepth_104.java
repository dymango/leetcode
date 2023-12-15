package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class maxDepth_104 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }
}
