package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class Preorder_589 {

    class Node {
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
    }

    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     *
     * 例如，给定一个 3叉树 :
     *
     *  
     *
     *
     *
     *  
     *
     * 返回其前序遍历: [1,3,5,6,2,4]。
     *
     *  
     *
     * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    List<Integer> result;
    public List<Integer> preorder(Node root) {
        result = new ArrayList<>();
        recursion(root);
        return result;
    }

    public void recursion(Node node) {
        if(node == null) return;
        List<Node> childrens = node.children;
        for (Node c: childrens) {
            recursion(c);
        }

        result.add(node.val);
    }
}
