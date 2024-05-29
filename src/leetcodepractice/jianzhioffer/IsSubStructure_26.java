package leetcodepractice.jianzhioffer;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class IsSubStructure_26 {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * <p>
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * <p>
     * 例如:
     * 给定的树 A:
     * <p>
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 B：
     * <p>
     *    4 
     *   /
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     * <p>
     * 示例 1：
     * <p>
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 示例 2：
     * <p>
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     * 限制：
     * <p>
     * 0 <= 节点个数 <= 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param A
     * @param B
     * @return
     */
    TreeNode subTree;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A != null && B == null) return false;
        if (A == null && B != null) return false;
        if (A == null && B == null) return false;
        subTree = B;
        return dfs(A);
    }

    private boolean dfs(TreeNode treeNode) {
        if (treeNode == null) return false;
        if (treeNode.val == subTree.val) {
            boolean match = check(treeNode, subTree);
            if (match) return true;
        }
        boolean leftMatch = dfs(treeNode.left);
        if (leftMatch) return true;
        return dfs(treeNode.right);
    }

    private boolean check(TreeNode treeNode, TreeNode subTree) {
        if (treeNode == null && subTree == null) return true;
        if (subTree == null) return true;
        if (treeNode == null) return false;
        if (treeNode.val != subTree.val) return false;
        boolean checkLeftTree = check(treeNode.left, subTree.left);
        if (!checkLeftTree) return false;
        return check(treeNode.right, subTree.right);
    }
}
