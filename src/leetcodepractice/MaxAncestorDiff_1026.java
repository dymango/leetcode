package leetcodepractice;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.List;

/**
 * @author dimmy
 */
public class MaxAncestorDiff_1026 {

    /**
     * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
     * <p>
     * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
     *
     * @param root
     * @return [1, null, 2, null, 0, 3]
     */

    public int maxAncestorDiffV3(TreeNode root) {
       return search(root, root.val, root.val);
    }

    private int search(TreeNode node, int min, int max) {
        if(node == null) return 0;
        int result = Math.max(Math.abs(max - node.val), Math.abs(min - node.val));
        int mi = Math.min(min, node.val);
        int ma = Math.max(max, node.val);
        var leftV = search(node.left, mi, ma);
        var rightV = search(node.right, mi, ma);
        result = Math.max(leftV, result);
        result = Math.max(rightV, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(3);
        n3.left = n4;
        n2.right = n3;
        n1.right = n2;
        var i = new MaxAncestorDiff_1026().maxAncestorDiff(n1);
        int a = 1;
    }

    int max = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        recursive(root);
        return max;
    }

    public List<Integer> recursive(TreeNode root) {
        if (root == null) return List.of();
        var leftDif = recursive(root.left);
        var rightDif = recursive(root.right);
        int max = 0;
        int min = 0;

        if (root.left != null && root.right != null) {
            var leftSum = root.val - root.left.val;
            var rightSum = root.val - root.right.val;
            max = Math.max(leftSum, rightSum);
            min = Math.min(leftSum, rightSum);
            for (Integer n : leftDif) {
                max = Math.max(max, leftSum + n);
                min = Math.min(min, leftSum + n);
            }

            for (Integer n : rightDif) {
                max = Math.max(max, rightSum + n);
                min = Math.min(min, rightSum + n);
            }
        } else if (root.left != null) {
            var leftSum = root.val - root.left.val;
            max = leftSum;
            min = leftSum;
            for (Integer n : leftDif) {
                max = Math.max(max, leftSum + n);
                min = Math.min(min, leftSum + n);
            }
        } else if (root.right != null) {
            var rightSum = root.val - root.right.val;
            max = rightSum;
            min = rightSum;
            for (Integer n : rightDif) {
                max = Math.max(max, rightSum + n);
                min = Math.min(min, rightSum + n);
            }
        }


        this.max = Math.max(this.max, Math.max(Math.abs(max), Math.abs(min)));
        return List.of(max, min);
    }

    public int maxAncestorDiffV2(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mi, int ma) {
        if (root == null) {
            return 0;
        }
        int diff = Math.max(Math.abs(root.val - mi), Math.abs(root.val - ma));
        mi = Math.min(mi, root.val);
        ma = Math.max(ma, root.val);
        diff = Math.max(diff, dfs(root.left, mi, ma));
        diff = Math.max(diff, dfs(root.right, mi, ma));
        return diff;
    }


}
