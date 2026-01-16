package leetcodepractice.leetcode;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class MaxLevelSum_1161 {

    /**
     * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
     * 返回总和 最大 的那一层的层号 x。如果有多层的总和一样大，返回其中 最小 的层号 x。
     *
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minLevel = 1;
        int level = 1;
        int total = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            var size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                var poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }

            if (sum > total) {
                total = sum;
                minLevel = level;
            }

            level++;
        }

        return minLevel;

    }

}
