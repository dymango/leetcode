package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;
import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class bstFromPreorder_1008 {
    @MainParam
    int[] param = new int[]{4,2};

    /**
     * 给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
     * <p>
     * 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
     * <p>
     * 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大于 Node.val。
     * <p>
     * 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
     *
     * @param preorder 输入：preorder = [8,5,1,7,10,12]
     * @return
     */
    @MainMethod
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        int spiltIndex = preorder.length;
        int root = preorder[0];
        if (preorder.length == 1) return new TreeNode(root);
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] > root) {
                spiltIndex = i;
                break;
            }
        }

        TreeNode node = new TreeNode(root);
        int[] leftArr = new int[spiltIndex - 1];
        System.arraycopy(preorder, 1, leftArr, 0, leftArr.length);
        node.left = bstFromPreorder(leftArr);
        int[] rightArr = new int[preorder.length - spiltIndex];
        System.arraycopy(preorder, spiltIndex, rightArr, 0, rightArr.length);
        node.right = bstFromPreorder(rightArr);
        return node;
    }
}
