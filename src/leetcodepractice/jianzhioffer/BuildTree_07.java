package leetcodepractice.jianzhioffer;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class BuildTree_07 {

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * <p>
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * 示例 2:
     * <p>
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 节点个数 <= 5000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    int[] PRE_ORDER;
    int[] IN_ORDER;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        PRE_ORDER = preorder;
        IN_ORDER = inorder;
        return buildTree(0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd) return null;
        if (pStart == pEnd) {
            return new TreeNode(PRE_ORDER[pStart]);
        }
        int center = PRE_ORDER[pStart];
        int indexIn = -1;
        for (int i = iStart; i <= iEnd; i++) {
            if (IN_ORDER[i] == center) {
                indexIn = i;
                break;
            }
        }

        int leftTreeLength = indexIn - iStart;
        TreeNode node = new TreeNode(center);
        node.left = buildTree(pStart + 1, pStart + leftTreeLength, iStart, indexIn - 1);
        node.right = buildTree(pStart+ leftTreeLength + 1, pEnd, indexIn + 1, iEnd);
        return node;
    }
}
