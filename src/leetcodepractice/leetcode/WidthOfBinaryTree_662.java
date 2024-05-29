package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author dimmy
 * 层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 *
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * [1,3,2,5,3,null,9]
 */
public class WidthOfBinaryTree_662 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class MyNode {
        public TreeNode node;
        public int index;

        public MyNode(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }

        public static MyNode build(TreeNode node, int index) {
            return new MyNode(node, index);
        }
    }

    /**
     *          1
     *        /   \
     *       3     2
     *      / \     \
     *     5   3     9
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = Integer.MIN_VALUE;
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(MyNode.build(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            Integer start = null;
            Integer end = null;
            for (int i = 0; i < size; i++) {
                MyNode node = queue.poll();
                if(start == null) {
                    start = node.index;
                }

                end = node.index;

                if(node.node.left != null ) queue.offer(MyNode.build(node.node.left, 2*node.index));
                if(node.node.right != null ) queue.offer(MyNode.build(node.node.right, 2*node.index + 1));
            }

            maxWidth = Math.max(end - start + 1, maxWidth);
        }

        return maxWidth;
    }

    Map<Integer, Integer> left;
    int ans;
    public int widthOfBinaryTreev2(TreeNode root) {
        ans = 0;
        left = new HashMap();
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
