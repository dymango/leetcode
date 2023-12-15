package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class buildTree_106 {

    int[] IN;
    int[] POST;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        IN = inorder;
        POST = postorder;
        return generate(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode generate(int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd) return null;
        int root = POST[postEnd];
        TreeNode treeNode = new TreeNode(root);
        int leftTreeLength = 0;
        int s = inStart;
        int e = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (IN[i] == root) {
                leftTreeLength = i - inStart;
                break;
            }
        }

        TreeNode leftTree = generate(inStart, inStart + leftTreeLength - 1, postStart, postStart + leftTreeLength - 1);
        TreeNode rightTree = generate(inStart + leftTreeLength + 1, inEnd, postStart + leftTreeLength, postEnd - 1);
        treeNode.left = leftTree;
        treeNode.right = rightTree;
        return treeNode;
    }

}
