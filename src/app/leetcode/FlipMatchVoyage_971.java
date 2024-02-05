package app.leetcode;

import app.executor.Main;
import app.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class FlipMatchVoyage_971 {

    /**
     * 给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
     * <p>
     * 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
     * <p>
     * 通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下：
     * <p>
     * <p>
     * 请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。
     * <p>
     * 如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。
     *
     * @param root
     * @param voyage
     * @return
     */
    int index = -1;
    List<Integer> list = new ArrayList<>();

    @Main
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root.val != voyage[0]) return List.of(-1);
        boolean match = match(root, voyage);
        if (!match) return List.of(-1);
        return list;
    }


    private boolean match(TreeNode node, int[] voyage) {
        if (node == null) return true;
        index++;
        if (node.val != voyage[index]) {
            index--;
            return false;
        }

        boolean match = match(node.left, voyage);
        if (!match) {
            TreeNode t = node.left;
            node.left = node.right;
            node.right = t;
            list.add(node.val);
            boolean match1 = match(node.left, voyage);
            if (!match1) {
                index--;
                return false;
            }
        }

        return match(node.right, voyage);
    }
}
