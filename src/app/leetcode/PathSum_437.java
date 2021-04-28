package app.leetcode;


import java.util.Stack;

/**
 * @author dimmy
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum_437 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static Stack<Integer> stack = new Stack<>();
    static int sum = 0;
    static int target = 0;
    static int count = 0;
    public static int pathSum(TreeNode root, int s) {
        target = s;
        if(root != null) recursion(root);
        return count;
    }

    public static void recursion(TreeNode node) {
        sum = node.val;
        if(sum == target) count++;
        dfs(node);
        if(node.left != null) recursion(node.left);
        if(node.right != null) recursion(node.right);
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(10);
        TreeNode r2 = new TreeNode(5);
        TreeNode r3 = new TreeNode(-3);
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(2);
        TreeNode r6 = new TreeNode(11);
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        r.left = r2;
        r.right = r3;
        pathSum(r, 8);
    }

    public static void dfs(TreeNode node) {
        if(node.left != null){
            stack.push(node.left.val);
            sum+=node.left.val;
            if(sum == target) count++;
            dfs(node.left);
            sum -= node.left.val;
        }


        if(node.right != null) {
            sum+=node.right.val;
            if(sum == target) count++;
            dfs(node.right);
            sum -= node.right.val;
        }
    }
}
