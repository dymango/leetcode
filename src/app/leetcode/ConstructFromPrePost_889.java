package app.leetcode;

import app.leetcode.base.TreeNode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author dimmy
 */
public class ConstructFromPrePost_889 {

    /**
     * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
     * 如果存在多个答案，您可以返回其中 任何 一个。
     * <p>
     * 示例 1：
     * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
     * 输出：[1,2,3,4,5,6,7]
     * <p>
     * 示例 2:
     * 输入: preorder = [1], postorder = [1]
     * 输出: [1]
     * <p>
     * 提示：
     * <p>
     * 1 <= preorder.length <= 30
     * 1 <= preorder[i] <= preorder.length
     * preorder 中所有值都 不同
     * postorder.length == preorder.length
     * 1 <= postorder[i] <= postorder.length
     * postorder 中所有值都 不同
     * 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param preorder
     * @param postorder
     * @return
     */

    public TreeNode constructFromPrePostV2(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) return root;

        int L = 0;
        for (int i = 0; i < N; ++i)
            if (post[i] == pre[1])
                L = i+1;

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L+1),
            Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L+1, N),
            Arrays.copyOfRange(post, L, N-1));
        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode treeNode = new TreeNode(preorder[0]);
        int subLeftRoot = 1;
        int subRightEnd = postorder.length - 1;
        if(subLeftRoot >= preorder.length || subRightEnd < 0) return treeNode;
        int subLeftEnd = 0, subRightStart = 0;
        for (int i = 0; i <= postorder.length; i++) {
            if (postorder[i] == preorder[subLeftRoot]) {
                subLeftEnd = subLeftRoot + i;
                subRightStart = i + 1;
                break;
            }
        }

        treeNode.left = buildTree(preorder, postorder, subLeftRoot, subLeftEnd, 0, subRightStart - 1);
        treeNode.right = buildTree(preorder, postorder, subLeftEnd + 1, preorder.length, subRightStart, subRightEnd);
        return treeNode;
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        if(leftStart >= preorder.length || rightEnd < 0) return null;
        TreeNode treeNode = new TreeNode(preorder[leftStart]);
        int subLeftRoot = leftStart + 1;
        int subRightEnd = rightEnd - 1;
        if(subLeftRoot >= preorder.length || subRightEnd < 0) return treeNode;
        int subLeftEnd = 0, subRightStart = 0;
        for (int i = rightStart; i <= rightEnd; i++) {
            if (postorder[i] == preorder[subLeftRoot]) {
                subLeftEnd = subLeftRoot + i - rightStart;
                subRightStart = i + 1;
                break;
            }
        }

        if (leftEnd - leftStart <= 1 || rightEnd - rightStart <= 1) return treeNode;
        treeNode.left = buildTree(preorder, postorder, subLeftRoot, subLeftEnd, rightStart, subRightStart - 1);
        treeNode.right = buildTree(preorder, postorder, subLeftEnd + 1, leftEnd, subRightStart, subRightEnd);
        return treeNode;
    }
}
