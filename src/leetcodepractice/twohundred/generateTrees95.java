package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class generateTrees95 {

    /**
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            if (left.isEmpty() && right.isEmpty()) {
                return List.of(new TreeNode(i));
            }
            if (!left.isEmpty() && !right.isEmpty()) {
                for (TreeNode ln : left) {
                    for (TreeNode rn : right) {
                        TreeNode r = new TreeNode(i);
                        r.left = ln;
                        r.right = rn;
                        treeNodes.add(r);
                    }
                }
            } else if (left.isEmpty()) {
                for (TreeNode rn : right) {
                    TreeNode r = new TreeNode(i);
                    r.right = rn;
                    treeNodes.add(r);
                }
            } else {
                for (TreeNode rn : left) {
                    TreeNode r = new TreeNode(i);
                    r.left = rn;
                    treeNodes.add(r);
                }
            }

        }

        return treeNodes;
    }
}
