package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class pathSum113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root.left == null && root.right == null && root.val == targetSum) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(root.val);
            list.add(l);
            return list;
        }
        List<List<Integer>> leftPaths = pathSum(root.left, targetSum - root.val);
        for (List<Integer> leftPath : leftPaths) {
            leftPath.addFirst(root.val);
            list.add(leftPath);
        }

        List<List<Integer>> rightPaths = pathSum(root.right, targetSum - root.val);
        for (List<Integer> path : rightPaths) {
            path.addFirst(root.val);
            list.add(path);
        }

        return list;
    }
}
