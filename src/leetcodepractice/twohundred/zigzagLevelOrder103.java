package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dimmy
 */
public class zigzagLevelOrder103 {
    /**
     * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> r = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean tag = true;
        while (!queue.isEmpty()) {
            var size = queue.size();
            var list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                var poll = queue.poll();
                if (tag) {
                    list.add(poll.val);
                } else {
                    list.addFirst(poll.val);
                }

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }

            r.add(list);
            tag = !tag;
        }

        return r;
    }

}
