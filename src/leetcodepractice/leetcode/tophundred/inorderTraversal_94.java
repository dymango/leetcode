package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class inorderTraversal_94 {
    List<Integer> r = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return r;
    }

    private void dfs(TreeNode node) {
        if(node == null) return;
        dfs(node.left);
        r.add(node.val);
        dfs(node.right);
    }
}
