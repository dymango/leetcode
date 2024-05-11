package app.leetcode;

import app.executor.MainMethod;
import app.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author dimmy
 */
public class DistributeCoins_979 {

    /**
     * 给你一个有 n 个结点的二叉树的根结点 root ，其中树中每个结点 node 都对应有 node.val 枚硬币。整棵树上一共有 n 枚硬币。
     * <p>
     * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。移动可以是从父结点到子结点，或者从子结点移动到父结点。
     * <p>
     * 返回使每个结点上 只有 一枚硬币所需的 最少 移动次数。
     *
     * @param root
     * @return 题目中要求求出移动步数，设 dfs(a)\textit{dfs}(a)dfs(a) 表示若使得以 aaa 为根节点的子树满足每个节点均只有一个金币时，节点 aaa 的父节点需要从节点 aaa 「拿走」的金币数目，我们可以定义如下：
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/distribute-coins-in-binary-tree/solutions/2339545/zai-er-cha-shu-zhong-fen-pei-ying-bi-by-e4poq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int distributeCoins(TreeNode root) {
        Stack<List<TreeNode>> stack = new Stack<>();
        Map<TreeNode, TreeNode> parentNodeMap = new HashMap<>();
        //自底向上遍历, 0枚硬币就
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                nodes.add(poll);
                if (poll.left != null) {
                    parentNodeMap.put(poll.left, poll);
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    parentNodeMap.put(poll.right, poll);
                    queue.offer(poll.right);
                }
            }

            stack.push(nodes);
        }

        int step = 0;
        while (!stack.isEmpty()) {
            List<TreeNode> nodes = stack.pop();
            for (TreeNode node : nodes) {
                if (node.val == 0) {
                    step += 1;
                    TreeNode treeNode = parentNodeMap.get(node);
                    treeNode.val -= 1;
                } else if (node.val == 1) {
                } else if (node.val > 1) {
                    int dif = node.val - 1;
                    step += dif;
                    TreeNode treeNode = parentNodeMap.get(node);
                    treeNode.val += dif;
                } else {
                    int need = Math.abs(node.val - 1);
                    step += need;
                    TreeNode treeNode = parentNodeMap.get(node);
                    treeNode.val -= need;
                }
            }
        }

        return step;
    }


    int step = 0;

    @MainMethod
    public int distributeCoinsV2(TreeNode root) {
        dfs(root);
        return step;
    }

    private int dfs(TreeNode root) {
        int coins = 0;
        if (root.val == 0) coins = -1;
        else {
            coins = root.val - 1;
        }

        if (root.left != null) {
            int n = dfs(root.left);
            step += Math.abs(n);
            coins += n;
        }


        if (root.right != null) {
            int n = dfs(root.right);
            step += Math.abs(n);
            coins += n;
        }


        return coins;
    }
}
