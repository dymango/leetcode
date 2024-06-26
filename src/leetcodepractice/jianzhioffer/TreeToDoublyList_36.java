package leetcodepractice.jianzhioffer;

/**
 * @author dimmy
 */
public class TreeToDoublyList_36 {

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     *
     * @param root
     * @return
     */
    Node parent;

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        Node head = root, tail = root;
        while (head.left != null) head = head.left;
        while (tail.right != null) tail = tail.right;
        head.left = tail;
        tail.right = head;
        return head;
    }

    void dfs(Node node) {
        if (node == null) return;
        dfs(node.left);
        if (parent != null) {
            node.left = parent;
            parent.right = node;
        }

        parent = node;
        dfs(node.right);
    }


    public static void main(String[] args) {
        Node node = new TreeToDoublyList_36().treeToDoublyList(new Node(1, null, null));
        int i = 1;
    }
}
