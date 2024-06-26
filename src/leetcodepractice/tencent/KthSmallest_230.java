package leetcodepractice.tencent;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dimmy
 */
public class KthSmallest_230 {

    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     *
     * 示例 1：
     *
     *
     * 输入：root = [3,1,4,null,2], k = 1
     * 输出：1
     * 示例 2：
     *
     *
     * 输入：root = [5,3,6,2,4,null,null,1], k = 3
     * 输出：3
     *  
     *
     *  
     *
     * 提示：
     *
     * 树中的节点数为 n 。
     * 1 <= k <= n <= 104
     * 0 <= Node.val <= 104
     *  
     *
     * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param k
     * @return
     */
    List<Integer> nums = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return nums.get(k-1);
    }

    private void dfs(TreeNode node) {
        if(node == null) return;
        dfs(node.left);
        nums.add(node.val);
        dfs(node.right);
    }

    public int kthSmallestV2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
