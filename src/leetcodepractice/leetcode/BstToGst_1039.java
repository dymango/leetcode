package leetcodepractice.leetcode;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class BstToGst_1039 {
    /**
     * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
     * 提醒一下， 二叉搜索树 满足下列约束条件：
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     *
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {
        calculate(root, 0);
        return root;
    }

    public int calculate(TreeNode node, int additional) {
        if(node == null) return 0;
        var right = calculate(node.right, additional);
        var left = calculate(node.left, right + node.val + additional);
        var pre = node.val;
        node.val += right + additional;
        return pre + left + right;
    }

    public static void main(String[] args) {
        var n = new TreeNode(4);
        var n2 = new TreeNode(1);
        var n3= new TreeNode(6);
        var n4 = new TreeNode(0);
        var n5 = new TreeNode(2);
        var n6 = new TreeNode(5);
        var n7 = new TreeNode(7);
        var n8 = new TreeNode(3);
        var n9 = new TreeNode(8);

        n7.right = n9;
        n3.left = n6;
        n3.right = n7;
        n.right = n3;
        n5.right = n8;
        n2.left = n4;
        n2.right = n5;
        n.left = n2;

        new BstToGst_1039().bstToGst(n);
    }
}
