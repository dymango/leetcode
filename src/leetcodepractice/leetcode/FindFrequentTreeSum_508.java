package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class FindFrequentTreeSum_508 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
     *
     * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
     *
     *  
     *
     * 示例 1：
     * 输入:
     *
     *   5
     *  /  \
     * 2   -3
     * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
     *
     * 示例 2：
     * 输入：
     *
     *   5
     *  /  \
     * 2   -5
     * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
     *
     *  
     *
     * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public static int[] findFrequentTreeSum(TreeNode root) {
        if(root != null) {
            increase(recursion(root));
        }

        int[] result = new int[numList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = numList.get(i);
        }

        return result;
    }

    static int max = 0;
    static List<Integer> numList = new ArrayList<>();
    static  Map<Integer, Integer> numCountMap = new HashMap<>();
    public static int recursion(TreeNode node) {
        int sum = 0;
        if(node.left != null) {
            int leftSum = recursion(node.left);
            increase(leftSum);
            sum += leftSum;
        }

        if(node.right != null) {
            int rightSum = recursion(node.right);
            increase(rightSum);
            sum += rightSum;
        }

        return node.val + sum;
    }

    public static void increase(int num) {
        Integer count = numCountMap.get(num);
        count = count == null ? 1 : count + 1;
        numCountMap.put(num, count == null ? 1 : count + 1);
        if(count > max) {
            max = count;
            numList.clear();
            numList.add(num);
        }
        else if(count == max) {
            numList.add(num);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-3);
        node.left = node2;
        node.right = node3;
        findFrequentTreeSum(node);
    }
}
