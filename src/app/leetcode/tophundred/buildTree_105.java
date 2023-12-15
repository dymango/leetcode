package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class buildTree_105 {

    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    int[] PRE;
    int[] IN;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        PRE = preorder;
        IN = inorder;
        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int root = PRE[preStart];
        TreeNode treeNode = new TreeNode(root);
        int leftTreeLength = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (IN[i] == root) {
                leftTreeLength = i - inStart;
                break;
            }
        }

        TreeNode leftTree = build(preStart + 1, preStart + leftTreeLength, inStart, inStart + leftTreeLength - 1);
        TreeNode rightTree = build(preStart + leftTreeLength + 1, preEnd, inStart + leftTreeLength + 1, inEnd);
        treeNode.left = leftTree;
        treeNode.right = rightTree;
        return treeNode;
    }
}
