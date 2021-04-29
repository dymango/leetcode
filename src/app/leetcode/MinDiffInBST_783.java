package app.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author dimmy
 */
public class MinDiffInBST_783 {

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

    int min = Integer.MAX_VALUE;
    List<Integer> integers = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        recursion(root);
        return min;
    }

    private void recursion(TreeNode root) {
        if(root == null) return;
        recursion(root.left);
        if(integers.size() > 0) {
            min = Math.min(min, root.val - integers.get(integers.size() - 1));
        }
        integers.add(root.val);
        recursion(root.right);
    }
}
