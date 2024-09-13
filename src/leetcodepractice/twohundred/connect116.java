package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class connect116 {

    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * <p>
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * @param root
     * @return
     */
    Map<Integer, List<Node>> map = new HashMap<>();

    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if(pre != null) pre.next = poll;
                pre = poll;

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
        }

        return root;
    }



    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}
