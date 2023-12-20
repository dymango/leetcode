package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class preorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> vals = new ArrayList<>();
        if (root == null) {
            return vals;
        }

        vals.add(root.val);
        vals.addAll(preorderTraversal(root.left));
        vals.addAll(preorderTraversal(root.right));
        return vals;
    }
}
