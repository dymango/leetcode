package leetcodepractice.leetcode;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class AllPossibleFBT_894 {

    /**
     * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
     * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
     * <p>
     * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：n = 7
     * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
     * 示例 2：
     * <p>
     * 输入：n = 3
     * 输出：[[0,0,0]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/all-possible-full-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            return List.of(new TreeNode(0));
        }

        List<TreeNode> result = new ArrayList<>();
        int size = n - 1;
        for (int i = 1; i <= size; i += 2) {
            List<TreeNode> leftTree = allPossibleFBT(i);
            List<TreeNode> rightTree = allPossibleFBT(size - i);
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftTree.get(j);
                    root.right = rightTree.get(k);
                    result.add(root);
                }
            }
        }

        return result;
    }

    private List<TreeNode> dfs(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            return List.of(new TreeNode(0));
        }

        List<TreeNode> result = new ArrayList<>();
        int size = n - 1;
        for (int i = 1; i <= size; i += 2) {
            List<TreeNode> leftTree = dfs(i);
            List<TreeNode> rightTree = dfs(size - i);
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftTree.get(j);
                    root.right = rightTree.get(k);
                    result.add(root);
                }
            }
        }

        return result;
    }
}
