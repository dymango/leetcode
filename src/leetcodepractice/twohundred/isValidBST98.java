package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

public class isValidBST98 {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 有效 二叉搜索树定义如下:
     * <p>
     * 节点的左
     * 子树
     * 只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return left(root.left, root.val, Long.MIN_VALUE) && left(root.right, Long.MAX_VALUE, root.val);
    }

    boolean left(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return (root.left == null || (root.val > root.left.val && left(root.left, root.val, min)))
            && (root.right == null || (root.val < root.right.val && left(root.right, max, root.val)));
    }
}
