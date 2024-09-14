package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class kthSmallest_230 {

    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        var count = count(root.left);
        if (count == k - 1) return root.val;
        if (count >= k) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - count - 1);
        }
    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        int n = 1;
        if (root.left != null) {
            n += count(root.left);
        }
        if (root.right != null) {
            n += count(root.right);
        }

        return n;
    }
}
