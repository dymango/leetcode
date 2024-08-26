package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class buildTree105 {

    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode treeNode = new TreeNode(preorder[0]);
        if(preorder.length == 1) return treeNode;
        int leftTreeHeight = 0;
        int rightTreeHeight = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == treeNode.val) {
                leftTreeHeight = i;
                rightTreeHeight = inorder.length - i - 1;
            }
        }

        var leftPreorder = new int[leftTreeHeight];
        var leftInorder = new int[leftTreeHeight];
        var rightPreorder = new int[rightTreeHeight];
        var rightInorder = new int[rightTreeHeight];
        System.arraycopy(preorder, 1, leftPreorder, 0, leftTreeHeight);
        System.arraycopy(inorder, 0, leftInorder, 0, leftTreeHeight);
        System.arraycopy(preorder, 1 + leftTreeHeight, rightPreorder, 0, rightTreeHeight);
        System.arraycopy(inorder, 1 + leftTreeHeight, rightInorder, 0, rightTreeHeight);
        treeNode.left = buildTree(leftPreorder, leftInorder);
        treeNode.right = buildTree(rightPreorder, rightInorder);
        return treeNode;
    }
}
