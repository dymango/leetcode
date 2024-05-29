package leetcodepractice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 案例 1:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 *  
 * <p>
 * 案例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * 输出: False
 *  
 * [0,-2,3,null,-1,null,4]
 * -2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BST_653 {


    private Set<Integer> va;

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

    public Set<Integer> values = new HashSet<>();
    public Set<Integer> repeatNumSet = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        for (Integer v: values) {
            if(values.contains(k - v)) {
                if(v == k - v) {
                    if(repeatNumSet.contains(v)) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public void dfs(TreeNode root) {
        if(root == null) return;
        if(values.contains(root.val)) repeatNumSet.add(root.val);
        values.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
