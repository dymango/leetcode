package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dimmy
 */
public class GetMinimumDifference_530 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：
     * <p>
     * 1
     * \
     * 3
     * /
     * 2
     * <p>
     * 输出：
     * 1
     * <p>
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或    者 2 和 3）。
     *  
     * <p>
     * 提示：
     * <p>
     * 树中至少有 2 个节点。
     * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    List<Integer> values = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        Collections.sort(values);
        int minDif = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            minDif = Math.min(minDif, Math.abs(values.get(i) -  values.get(i - 1)));
        }

        return minDif;
    }

    public void dfs(TreeNode node) {
        values.add(node.val);
        if(node.left != null) dfs(node.left);
        if(node.right != null) dfs(node.right);
    }
}
