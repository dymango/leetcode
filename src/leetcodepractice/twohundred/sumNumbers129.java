package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class sumNumbers129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode node, int pre) {
        if(node == null) return 0;
        int num = pre * 10 + node.val;
        if(node.left == null && node.right == null) return num;
        return dfs(node.left, num) + dfs(node.right, num);
    }
}
