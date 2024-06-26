package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class lowestCommonAncestor_235 {

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
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
        if (root == null) return null;
        if (root == p || root == q) return root;
        if (hasChild(root.left, p) && hasChild(root.right, q)
            || hasChild(root.left, q) && hasChild(root.right, p)) return root;
        TreeNode treeNode = lowestCommonAncestor(root.left, p, q);
        if (treeNode != null) return treeNode;
        return lowestCommonAncestor(root.right, p, q);
    }

    private boolean hasChild(TreeNode root, TreeNode q) {
        if (root == null) return false;
        if (root == q) return true;
        return hasChild(root.left, q) || hasChild(root.right, q);
    }

    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val) return p;
        if (root.val == q.val) return q;
        if (root.val >= p.val && root.val <= q.val
            || root.val >= q.val && root.val <= p.val) {
            return root;
        }

        return lowestCommonAncestorV2(p.val < root.val && q.val < root.val ? root.left : root.right, p, q);
    }
}
