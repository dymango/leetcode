package leetcodepractice.leetcode;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class isCompleteTree_958 {

    /**
     * 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2h 个节点。
     *
     * conclusion： 难点在于判断中间层是否全部填充，以及如何判断当前层是最后一层
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean preRowFulled = true;
        while (!queue.isEmpty()) {
            if (!preRowFulled) return false;
            boolean lastLevel = true;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    preRowFulled = false;
                    for (int j = i + 1; j < size; j++) {
                        TreeNode poll1 = queue.poll();
                        if (poll1 != null) return false;
                    }
                } else {
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                    if (poll.left != null || poll.right != null) lastLevel = false;
                }
            }

            if(lastLevel) break;
        }

        return true;
    }
}
