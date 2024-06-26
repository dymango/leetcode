package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class ConvertBST_538 {

    public static class TreeNode {
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
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     *
     * 提醒一下，二叉搜索树满足下列约束条件：
     *
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
     * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
     * 示例 2：
     *
     * 输入：root = [0,null,1]
     * 输出：[1,null,1]
     * 示例 3：
     *
     * 输入：root = [1,0,2]
     * 输出：[3,3,2]
     * 示例 4：
     *
     * 输入：root = [3,2,4,1]
     * 输出：[7,9,4,10]
     *  
     *
     * 提示：
     *
     * 树中的节点数介于 0 和 104 之间。
     * 每个节点的值介于 -104 和 104 之间。
     * 树中的所有值 互不相同 。
     * 给定的树为二叉搜索树。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        recursion(root, 0);
        return root;
    }

    /**
     *
     * @param node
     * @return 大于或等于node.val的值之和。
     */
    public static int recursion(TreeNode node, Integer parent) {
        if(node == null) return 0;
        int right = recursion(node.right, parent);
        node.val = right + node.val;
        return recursion(node.left, node.val);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(3);
        TreeNode t9 = new TreeNode(8);
        t7.right = t9;
        t5.right = t8;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t.left = t2;
        t.right = t3;
        convertBST(t);
    }
}
