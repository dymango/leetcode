package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class isSameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
