package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class recoverTree99 {


    Map<Integer, TreeNode> map = new HashMap<>();
    public boolean recoverTree(TreeNode root) {
        if (root == null) return true;
        map.put(root.val, root);
        return left(root.left, root.val, Long.MIN_VALUE) && left(root.right, Long.MAX_VALUE, root.val);
    }

    boolean left(TreeNode root, long max, long min) {
        if (root == null) return true;
        map.put(root.val, root);
        if (root.val >= max || root.val <= min) {

            return false;
        }
        return (root.left == null || (root.val > root.left.val && left(root.left, root.val, min)))
            && (root.right == null || (root.val < root.right.val && left(root.right, max, root.val)));
    }
}
