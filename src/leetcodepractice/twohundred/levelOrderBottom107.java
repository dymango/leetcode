package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dimmy
 */
public class levelOrderBottom107 {

    /**
     * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * @param root
     * @return [3, 9, 20, null, null, 15, 7]
     */

    public static void main(String[] args) {
        var treeNode = new TreeNode(3);
        var treeNode2 = new TreeNode(9);
        var treeNode3 = new TreeNode(20);
        var treeNode4 = new TreeNode(15);
        var treeNode5 = new TreeNode(7);
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        new levelOrderBottom107().levelOrderBottom(treeNode);
    }

    //[-8,-6,7,6,null,null,null,null,5]
    //
    //添加到测试用例
    //输出
    //[[5],[6,7],[-6],[-8]]
    //预期结果
    //[[5],[6],[-6,7],[-8]]
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> r = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            var list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                var poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }

            r.addFirst(list);
        }

        return r;
    }
}
