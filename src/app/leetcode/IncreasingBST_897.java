package app.leetcode;

import app.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class IncreasingBST_897 {

    /**
     * 给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [5,1,7]
     * 输出：[1,null,5,null,7]
     *  
     * <p>
     * 提示：
     * <p>
     * 树中节点数的取值范围是 [1, 100]
     * 0 <= Node.val <= 1000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/increasing-order-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        TreeNode left = increasingBST(root.left);
        TreeNode right = increasingBST(root.right);
        node.right = right;
        TreeNode pointer = left;
        while (pointer != null && pointer.right != null) {
            pointer = pointer.right;
        }

        if (pointer != null) pointer.right = node;
        return left == null ? node : left;
    }
}
