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
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param preorder
     * @param inorder
     * @return
     */
    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, preorder.length, preorder, 0, inorder.length, inorder);
    }

    private static TreeNode buildTree(int preL, int preR, int[] preorder, int inL, int inR, int[] inorder) {
        if(preL >= preorder.length || inL >= inorder.length || preL > preR || inL > inR) return null;
        if(preL == preR) {
            return new TreeNode(preorder[preL]);
        }
        TreeNode node = new TreeNode(preorder[preL]);
        int ni = findIndex(preorder[preL], inorder);
        int wl = ni - inL;
        node.left = buildTree(preL + 1,  preL + wl, preorder, inL, inR - 1, inorder);
        node.right = buildTree(preL + wl + 1, preR, preorder, ni + 1, inR, inorder);
        return node;
    }

    private static int findIndex(int val, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if(val == inorder[i]) return i;
        }

        return 0;
    }
}
