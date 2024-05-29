package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class sumNumbers_129 {

    /**
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     * <p>
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     * <p>
     * 叶节点 是指没有子节点的节点。
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        List<String> list = get(root);
        return list.stream().mapToInt(Integer::valueOf).sum();
    }

    private List<String> get(TreeNode root) {
        if (root == null) return List.of();
        if (root.left == null && root.right == null) return List.of(String.valueOf(root.val));
        List<String> list = get(root.left);
        List<String> list2 = get(root.right);
        List<String> sums = new ArrayList<>();
        list.forEach(str -> sums.add(root.val + str));
        list2.forEach(str -> sums.add(root.val + str));
        return sums;
    }

    public int sumNumbersV2(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
