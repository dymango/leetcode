package app.leetcode;

/**
 * @author dimmy
 */
public class BuildTree_105 {

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

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     * <p>
     * 例如，给出
     * <p>
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //find root node
        //generate left tree
        //generate right tree
        TreeNode treeNode = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return treeNode;
    }

    public static TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        //find root node
        //generate left tree
        //generate right tree
        if(pEnd >= preorder.length || pStart >= preorder.length || iEnd >= inorder.length || iStart >= inorder.length) return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        Integer rootIndexInOrder = null;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndexInOrder = i;
                break;
            }
        }

        if (rootIndexInOrder == null) return null;
        int nextPEnd = pStart + rootIndexInOrder - iStart;
        int nextPStart = pStart + 1;
        root.left = buildTree(preorder, nextPStart, pEnd, inorder, iStart, rootIndexInOrder - 1);
        root.right = buildTree(preorder, nextPEnd + 1, pEnd, inorder, rootIndexInOrder + 1, iEnd);
        return root;
    }
}
