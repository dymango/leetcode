package app.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author dimmy
 */
public class FindMode_501 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     * <p>
     * 假定 BST 有如下定义：
     * <p>
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 例如：
     * 给定 BST [1,null,2,2],
     * <p>
     * 1
     * \
     * 2
     * /
     * 2
     * 返回[2].
     * <p>
     * 提示：如果众数超过1个，不需考虑输出顺序
     * <p>
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     * <p>
     * 通过次数42,377提交次
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    static Map<Integer, Integer> countMap = new HashMap<>();
    public static int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e:
        countMap.entrySet()) {
            int value = e.getValue();
            if(value >= max) {
                max = value;
            }
        }

        for (Map.Entry<Integer, Integer> e:
                countMap.entrySet()) {
            int value = e.getValue();
            if(value == max) {
                result.add(e.getKey());
            }
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }

    public  static void dfs(TreeNode node) {
        if(node == null) return;
        Integer v = countMap.get(node.val);
        v = (v == null ? 1 : v + 1);
        countMap.put(node.val, v);
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        findMode(treeNode);
    }
}
