package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDuplicateSubtrees_652 {


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

    Set<String> trees;
    List<TreeNode> ans;
    Set<String> added;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        trees = new HashSet<>();
        added = new HashSet<>();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public String lookup(TreeNode node) {
        if (node == null) return "null";
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        if(trees.contains(serial)) {
            if(!added.contains(serial)) {
                ans.add(node);
                added.add(serial);
            }
        }

        trees.add(serial);
        return serial;
    }
}
