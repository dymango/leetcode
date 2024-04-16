package app.leetcode;

import app.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class InsertIntoMaxTree_998 {

    /**
     * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
     * <p>
     * 给你最大树的根节点 root 和一个整数 val 。
     * <p>
     * 就像 之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的：
     * <p>
     * 如果 a 为空，返回 null 。
     * 否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。
     * root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。
     * root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
     * 返回 root 。
     * 请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。
     * <p>
     * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
     * <p>
     * 返回 Construct(b) 。
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> input = getInput(root);
        input.add(val);
        int[] nums = new int[input.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.get(i);
        }

        return buildTree(nums, 0, nums.length - 1);
    }

    private List<Integer> getInput(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>(getInput(root.left));
        list.add(root.val);
        list.addAll(getInput(root.right));
        return list;
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int index = start;
        int max = nums[start];
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = buildTree(nums, start, index - 1);
        node.right = buildTree(nums, index + 1, end);
        return node;
    }
}
