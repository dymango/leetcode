package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class AddOneRow_623 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
     *
     * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
     *
     * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
     *
     * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
     *
     * 示例 1:
     *[1,4,null,2,6,3,1,5]
     * 输入:
     * 二叉树如下所示:
     *        4
     *      /   \
     *     2     6
     *    / \   /
     *   3   1 5
     *
     * v = 1
     *
     * d = 2
     *
     * 输出:
     *        4
     *       / \
     *      1   1
     *     /     \
     *    2       6
     *   / \     /
     *  3   1   5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-one-row-to-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param v
     * @param d
     * @return
     */
    int targetTier;
    int newNodeValue;
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        targetTier = d;
        newNodeValue = v;
        if(d == 1) {
            TreeNode node = new TreeNode(newNodeValue);
            node.left = root;
            return node;
        }

        recursion(root, 1);
        return root;
    }

    public TreeNode recursion(TreeNode root, int tier) {
        if(root == null) return null;
        root.left = recursion(root.left, tier + 1);
        root.right = recursion(root.right, tier + 1);
        if(tier == targetTier - 1) {
            TreeNode newLeft = new TreeNode(newNodeValue);
            TreeNode newRight = new TreeNode(newNodeValue);
            if(root.left != null) {
                newLeft.left = root.left;
            }

            if(root.right != null) {
                newRight.right = root.right;
            }

            root.left = newLeft;
            root.right = newRight;
        }

        return root;
    }
}
