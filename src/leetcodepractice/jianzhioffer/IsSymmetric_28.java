package leetcodepractice.jianzhioffer;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class IsSymmetric_28 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMatch(root.left, root.right);
    }

    public boolean isMatch(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null) return false;
        if(node2 == null) return false;
        if(node1.val != node2.val) return false;
        return isMatch(node1.left, node2.right) && isMatch(node1.right, node2.left);
    }
}

