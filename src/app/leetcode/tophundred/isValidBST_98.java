package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class isValidBST_98 {

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) return;
        dfs(treeNode.left);
        list.add(treeNode.val);
        dfs(treeNode.right);
    }

    private boolean validLeft(TreeNode root, int max, int val) {
        if (root == null) return true;
        if (root.val >= max || root.val >= val) return false;
        return validLeft(root.left, root.val, val) && validRight(root.right, root.val, val);
    }

    private boolean validRight(TreeNode root, int min, int val) {
        if (root == null) return true;
        if (root.val <= min || root.val <= val) return false;
        return validLeft(root.left, root.val, val) && validRight(root.right, root.val, val);
    }
}
