package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class InsertIntoBST_701 {

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
     * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
     *
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [4,2,7,1,3], val = 5
     * 输出：[4,2,7,1,3,5]
     * 解释：另一个满足题目要求可以通过的树是：
     *
     * 示例 2：
     *
     * 输入：root = [40,20,60,10,30,50,70], val = 25
     * 输出：[40,20,60,10,30,50,70,null,null,25]
     * 示例 3：
     *
     * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
     * 输出：[4,2,7,1,3,5]
     *  
     *
     * 4,2,7,1,3,8,6
     *
     * 4213786
     * 1234876
     *  
     *
     * 提示：
     *
     * 给定的树上的节点数介于 0 和 10^4 之间
     * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
     * -10^8 <= val <= 10^8
     * 新值和原始二叉搜索树中的任意节点值都不同
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        recursion(root, val);
        return root;
    }

    private void recursion(TreeNode root, int val) {
        if(root == null) return;
        if(root.val > val) {
            if(root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            insertIntoBST(root.left, val);
        }

        if(root.val < val) {
            if(root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            insertIntoBST(root.right, val);
        }
    }
}
