package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class postorderTraversal_145 {

    /**
     * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,null,2,3]
     * 输出：[3,2,1]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 树中节点的数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *
     *
     * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        if(root == null) return vals;
        vals.addAll(postorderTraversal(root.left));
        vals.addAll(postorderTraversal(root.right));
        vals.add(root.val);
        return vals;
    }
}
