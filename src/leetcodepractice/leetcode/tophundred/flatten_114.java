package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class flatten_114 {

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * <p>
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        get(root);
    }

    private TreeNode get(TreeNode root) {
        if (root == null) return null;
        TreeNode treeNode = get(root.left);
        TreeNode treeNode2 = get(root.right);
        root.left = null;
        if (treeNode != null) {
            TreeNode p = treeNode;
            while (true) {
                if (p.right == null) {
                    p.right = treeNode2;
                    break;
                }
                p = p.right;
            }

            root.right = treeNode;
        } else {
            root.right = treeNode2;
        }

        return root;
    }
}
