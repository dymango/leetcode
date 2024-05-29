package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class sortedArrayToBST_108 {

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * <p>
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     * @param nums
     * @return
     */
    int[] NUMS;

    public TreeNode sortedArrayToBST(int[] nums) {
        NUMS = nums;
        return buildTree(0, nums.length - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end) return null;
        int middle = start + (end - start) / 2;
        TreeNode node = new TreeNode(NUMS[middle]);
        node.left = buildTree(start, middle - 1);
        node.right = buildTree(middle + 1, end);
        return node;
    }
}
