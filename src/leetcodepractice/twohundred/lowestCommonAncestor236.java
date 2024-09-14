package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class lowestCommonAncestor236 {
    Map<TreeNode, Boolean> pp = new HashMap<>();
    Map<TreeNode, Boolean> qp = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isPParent(root, p) && isQParent(root, q)) {
            if (isPParent(root.left, p) && isQParent(root.left, q)) return lowestCommonAncestor(root.left, p, q);
            else if (isPParent(root.right, p) && isQParent(root.right, q)) return lowestCommonAncestor(root.right, p, q);
            return root;
        }

        return root;
    }

    private boolean isPParent(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        if (pp.containsKey(root)) return pp.get(root);
        var is = isPParent(root.left, node) || isPParent(root.right, node);
        pp.put(root, is);
        return is;
    }

    private boolean isQParent(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        if (qp.containsKey(root)) return qp.get(root);
        var is = isQParent(root.left, node) || isQParent(root.right, node);
        qp.put(root, is);
        return is;
    }
}
