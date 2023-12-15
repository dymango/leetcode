package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class pathSum_113 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }

    private boolean dfs(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) return false;
        list.add(root.val);
        int left = targetSum - root.val;
        if (root.left == null && root.right == null) {
            boolean rightPath = left == 0;
            if (rightPath) {
                result.add(new ArrayList<>(list));
            }

            list.remove(list.size() - 1);
            return rightPath;
        }
        boolean rightPath = dfs(root.left, left, list);
        boolean rightPath2 = dfs(root.right, left, list);
        list.remove(list.size() - 1);
        return rightPath || rightPath2;
    }
}
