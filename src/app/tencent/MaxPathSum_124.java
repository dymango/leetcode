package app.tencent;

import app.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class MaxPathSum_124 {

    /**
     * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     * 路径和 是路径中各节点值的总和。
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    int maxPathValueSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return maxPathValueSum;
    }

    public int recursion(TreeNode node) {
        if(node == null) return 0;
        int max = node.val;
        int left = recursion(node.left);
        max += left;
        int right = recursion(node.right);
        max += right;
        maxPathValueSum = Math.max(maxPathValueSum, max);
        if(max < 0) return 0;
        return Math.max(node.val + left, node.val + right);
    }

    //[5,4,8,11,null,13,4,7,2,null,null,null,1]
}
