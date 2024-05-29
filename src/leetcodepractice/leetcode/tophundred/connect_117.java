package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class connect_117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     * <p>
     * struct Node {
     * int val;
     * Node *left;
     * Node *right;
     * Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * <p>
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * @param root
     * @return
     */

    public Node connect(Node root) {
        if (root == null) return null;
        connectLeft(root.left, root.right);
        connectRight(root.right, null);
        return root;
    }

    private void connectLeft(Node root, Node next) {
        if (root == null) return;
        root.next = next;
        Node nextNode = null;
        if (next != null) {
            if (next.left != null) nextNode = next.left;
            else if (next.right != null) nextNode = next.right;
        }

        connectLeft(root.left, root.right != null ? root.right : nextNode);
        connectRight(root.right, nextNode);
    }

    private void connectRight(Node root, Node next) {
        if (root == null) return;
        root.next = next;
        Node nextNode = null;
        if (next != null) {
            if (next.left != null) nextNode = next.left;
            else if (next.right != null) nextNode = next.right;
        }

        connectLeft(root.left, root.right != null ? root.right : next);
        connectRight(root.right, nextNode);
    }
}
