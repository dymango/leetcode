package app.leetcode.tophundred;

import app.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class recoverTree_99 {

    List<TreeNode> treeNodes = new ArrayList<>();
    TreeNode pre = null;
    List<Integer> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        recursive(root);
        TreeNode treeNode = treeNodes.get(0);
        TreeNode treeNode1 = treeNodes.get(1);
        int t = treeNode.val;
        treeNode.val = treeNode1.val;
        treeNode1.val = t;
    }

    private void recursive(TreeNode node) {
        if(node == null) return;
        recursive(node.left);
        if (!list.isEmpty()) {
            if(treeNodes.isEmpty()) {
                if (list.get(list.size() - 1) > node.val) {
                    treeNodes.add(pre);
                    treeNodes.add(node);
                }
            } else {
                if (list.get(list.size() - 1) > node.val) {
                    treeNodes.remove(treeNodes.size() - 1);
                    treeNodes.add(node);
                }
            }

        }
        list.add(node.val);
        pre = node;
        recursive(node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(2);

        treeNode3.left = treeNode4;
        treeNode.left= treeNode2;
        treeNode.right= treeNode3;
        new recoverTree_99().recoverTree(treeNode);
    }
}
