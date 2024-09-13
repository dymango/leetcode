package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.TreeNode;

public class flatten114 {
    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * <p>
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        build(root);
    }

    public TreeNode build(TreeNode root) {
        if(root == null) return null;
        var p = root.left;
        var p2 = root.right;
        root.left = null;
        root.right = build(p);
        var tp = root;
        while (tp.right != null) {
            tp = tp.right;
        }

        tp.right = build(p2);
        return root;
    }
}
