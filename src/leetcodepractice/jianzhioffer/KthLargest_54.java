package leetcodepractice.jianzhioffer;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class KthLargest_54 {
    /**
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     * 示例 1:
     *
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 4
     * 示例 2:
     *
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 4
     *  
     *
     * 限制：
     *
     * 1 ≤ k ≤ 二叉搜索树元素个数
     *
     * @param root
     * @param k
     * @return
     */
    List<Integer> list = new ArrayList<>();
    int K;
    public int kthLargest(TreeNode root, int k) {
        K = k;
        dfs(root);
        return list.get(k - 1);
    }

    private void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        list.add(root.val);
        if(list.size() > K) return;
        dfs(root.left);
    }
}
