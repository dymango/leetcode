package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class lowestCommonAncestor235 {

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isParent(root, p) && isParent(root, q)) {
            if (root.val > p.val && root.val > q.val && isParent(root.left, p) && isParent(root.left, q)) return lowestCommonAncestor(root.left, p, q);
            else if (root.val < p.val && root.val < q.val && isParent(root.right, p) && isParent(root.right, q)) return lowestCommonAncestor(root.right, p, q);
            return root;
        }

        return root;
    }

    private boolean isParent(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        return isParent(root.left, node) || isParent(root.right, node);
    }
}
