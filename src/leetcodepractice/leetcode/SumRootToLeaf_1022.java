package leetcodepractice.leetcode;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class SumRootToLeaf_1022 {


    /**
     * 代码
     * 测试用例
     * 测试结果
     * 测试结果
     * 1022. 从根到叶的二进制数之和
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
     * <p>
     * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     * <p>
     * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
     * <p>
     * 1,0,1,0,1,0,1
     *
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        var list = new ArrayList<Integer>();
        list.add(root.val);
        if(root.left == null && root.right == null) {
            return Integer.parseInt(list.stream().map(String::valueOf).collect(Collectors.joining()), 2);
        }
        return recursive(root.left, list) + recursive(root.right, list);
    }

    public int recursive(TreeNode node, List<Integer> list) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            var val = Integer.parseInt(list.stream().map(String::valueOf).collect(Collectors.joining()), 2);
            list.removeLast();
            return val;
        }

        list.add(node.val);
        var leftSum = recursive(node.left, list);
        var rightSum = recursive(node.right, list);
        list.removeLast();
        return leftSum + rightSum;
    }
}
