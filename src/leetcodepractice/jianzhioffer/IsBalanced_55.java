package leetcodepractice.jianzhioffer;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class IsBalanced_55 {

    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 给定二叉树 [3,9,20,null,null,15,7]
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回 true 。
     * <p>
     * 示例 2:
     * <p>
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     * <p>
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     * 返回 false 。
     * <p>
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 树的结点个数 <= 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return depth;
    }

    public boolean isBalancedV2(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
