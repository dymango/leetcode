package leetcodepractice.leetcode;

import java.util.List;

/**
 * @author dimmy
 */
public class MaxDepth_559 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /**
     * 给定一个 N 叉树，找到其最大深度。
     *
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     *
     * 例如，给定一个 3叉树 :
     *
     *  
     *
     *
     *
     *  
     *
     * 我们应返回其最大深度，3。
     *
     * 说明:
     *
     * 树的深度不会超过 1000。
     * 树的节点总不会超过 5000。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    static int maxDepth = Integer.MIN_VALUE;
    public static int maxDepth(Node root) {
        if(root == null) return 0;
        dfs(root, 1);
        return maxDepth;
    }

    public static void dfs(Node node, int depth) {
        if(node.children == null) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }

        for (Node n : node.children) {
            if(n == null) {
                maxDepth = Math.max(maxDepth, depth);
                return;
            } else {
                dfs(n, depth + 1);
            }
        }

        maxDepth = Math.max(maxDepth, depth);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(3);
        node.children = List.of(node2);
        System.out.println( maxDepth(node));

    }
}
