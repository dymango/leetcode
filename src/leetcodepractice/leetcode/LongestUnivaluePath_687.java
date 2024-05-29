package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class LongestUnivaluePath_687 {

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

    /**
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * <p>
     * 5
     * / \
     * 4   5
     * / \   \
     * 1   1   5
     * 输出:
     * <p>
     * 2
     * 示例 2:
     * <p>
     * 输入:
     * <p>
     * 1
     * / \
     * 4   5
     * / \   \
     * 4   4   5
     * 输出:
     * <p>
     * 2
     * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
     * <p>
     * 链接：https://leetcode-cn.com/problems/longest-univalue-path
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * [1,null,1,1,1,1,1,1]
     * @param root
     * @return
     */
    int max = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        recursion(root);
        return max - 1;
    }

    private int recursion(TreeNode node) {
        if(node == null) return 0;
        int nv = node.val;
        int leftTreeValue = recursion(node.left);
        int rightTreeValue = recursion(node.right);
        if(node.left != null && node.left.val == nv && node.right != null && node.right.val == nv) {
            max = Math.max(max, leftTreeValue + rightTreeValue + 1);
        }

        int ml = 1;
        if(node.left != null && node.left.val == nv) {
            ml = Math.max(leftTreeValue + 1, ml);
        }

        if(node.right != null && node.right.val == nv) {
            ml = Math.max(rightTreeValue + 1, ml);
        }

        max = Math.max(max, ml);
        return ml;
    }
}

