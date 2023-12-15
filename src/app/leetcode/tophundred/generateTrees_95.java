package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class generateTrees_95 {
    /**
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     * <p>
     * [[1,2,null,3],[1,3,null,2],[2,1,3],[3,1,null,2],[3,2,null,1]]
     * 预期结果
     * [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }


    private List<TreeNode> generate(int start, int end) {
        if (start > end) return new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            int n = i;
            List<TreeNode> leftNodes = generate(start, n - 1);
            List<TreeNode> rightNodes = generate(n + 1, end);
            if(leftNodes.isEmpty()) leftNodes.add(null);
            if(rightNodes.isEmpty()) leftNodes.add(null);
            leftNodes.forEach(treeNode -> {
                rightNodes.forEach(treeNode1 -> {
                    TreeNode r = new TreeNode(n);
                    r.left = treeNode;
                    r.right = treeNode1;
                    nodes.add(r);
                });
            });
        }

        return nodes;
    }

    public static void main(String[] args) {
        new generateTrees_95().generateTrees(3);
    }
}
