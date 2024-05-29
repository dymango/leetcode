package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class FindBottomLeftValue_513 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个二叉树，在树的最后一行找到最左边的值。
     * 树的最后一行最左边的值等于左子树与右子树中深度较大一方的最左边的值
     *
     * 示例 1:
     *
     * 输入:
     *
     *     2
     *    / \
     *   1   3
     *
     * 输出:
     * 1
     *  
     *
     * 示例 2:
     *
     * 输入:
     *
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     *        /
     *       7
     *
     * 输出:
     * 7
     *  
     *
     * 注意: 您可以假设树（即给定的根节点）不为 NULL。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        return find(root)[0];
    }

    public int[] find(TreeNode root) {
        int[] result = new int[2];
        if(root == null) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }

        if(root.left == null && root.right == null) {
            result[0] = root.val;
            result[1] = 1;
            return result;
        }

        int[] left = find(root.left);
        int[] right = find(root.right);
        if(left[1] > right[1] || left[1] == right[1]) {
            result[0] = left[0];
            result[1] = left[1] + 1;
        } else if(left[1] < right[1]) {
            result[0] = right[0];
            result[1] = right[1] + 1;
        }

        return result;
    }
}
