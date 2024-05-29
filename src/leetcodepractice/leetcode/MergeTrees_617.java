package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MergeTrees_617 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * <p>
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * Tree 1                     Tree 2
     * 1                         2
     * / \                       / \
     * 3   2                     1   3
     * /                           \   \
     * 5                             4   7
     * 输出:
     * 合并后的树:
     * 3
     * / \
     * 4   5
     * / \   \
     * 5   4   7
     * 注意: 合并必须从两个树的根节点开始。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param t1
     * @param t2
     * @return
     *
     * [1, 2, null, 3]
     * [1,null,2,null,3]
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return t1;
        TreeNode node = new TreeNode((t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0));
        if((t1 != null && t1.left != null) || (t2 != null && t2.left != null)) {
            node.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        }

        if((t1 != null && t1.right != null) || (t2 != null && t2.right != null)) {
            node.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right: null);
        }

        return node;
    }
}
