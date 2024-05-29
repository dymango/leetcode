package leetcodepractice.leetcode;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class SmallestFromLeaf_988 {

    /**
     * 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
     * <p>
     * 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
     * <p>
     * 注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
     * <p>
     * 例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。
     * 节点的叶节点是没有子节点的节点。
     *
     * @param root
     * @return
     */
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new ArrayList<>());
        return result;
    }

    String result = null;

    private void dfs(TreeNode treeNode, List<Integer> values) {
        if (treeNode == null) return;
        values.add(treeNode.val);
        StringBuilder stringBuilder = new StringBuilder();
        if (treeNode.left == null && treeNode.right == null) {
            for (int i = values.size() - 1; i >= 0; i--) {
                stringBuilder.append((char) ('a' + values.get(i)));
            }

            String r = stringBuilder.toString();
            if (result == null || r.compareTo(result) < 0) result = r;
            values.remove(values.size() - 1);
            return;
        }

        dfs(treeNode.left, values);
        dfs(treeNode.right, values);

        values.remove(values.size() - 1);
    }
}
