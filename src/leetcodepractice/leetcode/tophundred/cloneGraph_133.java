package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author dimmy
 */
public class cloneGraph_133 {

    /**
     * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
     * <p>
     * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
     * <p>
     * class Node {
     * public int val;
     * public List<Node> neighbors;
     * }
     * <p>
     * <p>
     * 测试用例格式：
     * <p>
     * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
     * <p>
     * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
     * <p>
     * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
     *
     * @param node
     * @return
     */
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Integer, Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    public Node clone(Node node) {
        if(node == null) return null;
        if (nodeMap.containsKey(node.val)) return nodeMap.get(node.val);
        Node newNode = new Node();
        newNode.val = node.val;
        newNode.neighbors = new ArrayList<>();
        nodeMap.put(node.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor));
        }

        return newNode;
    }
}
