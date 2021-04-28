package app.leetcode;

/**
 * @author dimmy
 */
public class IsSubtree_572 {


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
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     * <p>
     * 示例 1:
     * 给定的树 s:
     * <p>
     * 3
     * / \
     * 4   5
     * / \
     * 1   2
     * 给定的树 t：
     * <p>
     * 4
     * / \
     * 1   2
     * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
     * <p>
     * 示例 2:
     * 给定的树 s：
     * <p>
     * 3
     * / \
     * 4   5
     * / \
     * 1   2
     * /
     * 0
     * 给定的树 t：
     * <p>
     * 4
     * / \
     * 1   2
     * 返回 false。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    boolean isMatch = false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        dfs(s, t);
        return isMatch;
    }

    public void dfs(TreeNode s, TreeNode t) {
        if(isMatch) return;
        if(s == null) return;
        if(s.val == t.val) {
           isMatch = (isMatch || equal(s, t));
        }

        dfs(s.left, t);
        dfs(s.right, t);
    }

    public boolean equal(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }

        if(t1 != null && t2 != null && t1.val == t2.val) {
            return equal(t1.left, t2.left) && equal(t1.right, t2.right);
        }

        return false;
    }
}
