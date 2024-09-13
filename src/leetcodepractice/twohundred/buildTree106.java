package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class buildTree106 {
    //[9,3,15,20,7]
    //postorder =
    //[9,15,7,20,3]


    //给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        var postorderLength = postorder.length;
        TreeNode treeNode = new TreeNode(postorder[postorderLength - 1]);
        if (inorder.length == 1) return treeNode;
        int lth = 0;
        int rth = 0;
        for (int i = inorder.length - 1; i >= 0; i--) {
            if (inorder[i] == treeNode.val) {
                lth = i;
                rth = inorder.length - i - 1;
            }
        }
        int[] linorder = new int[lth];
        int[] lpostorder = new int[lth];
        int[] rinorder = new int[rth];
        int[] rpostorder = new int[rth];
        System.arraycopy(postorder, 0, lpostorder, 0, lth);
        System.arraycopy(inorder, 0, linorder, 0, lth);

        System.arraycopy(postorder, lth, rpostorder, 0, rth);
        System.arraycopy(inorder, lth + 1, rinorder, 0, rth);
        treeNode.left = buildTree(linorder, lpostorder);
        treeNode.right = buildTree(rinorder, rpostorder);
        return treeNode;
    }
}
