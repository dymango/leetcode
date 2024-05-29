package leetcodepractice.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dimmy
 */
public class Codec_297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }


//    public static void main(String[] args) {
//        Codec_297 codec_297 = new Codec_297();
//        TreeNode node = new TreeNode(3);
//        TreeNode node2 = new TreeNode(9);
//        TreeNode node3 = new TreeNode(20);
//        TreeNode node4 = new TreeNode(15);
//        TreeNode node5 = new TreeNode(7);
////        3(1,3) 9(0,0) 20(1,1) 15(0,0) 7(0,0)
//        node.left = node2;
//        node3.left = node4;
//        node3.right = node5;
//        node.right = node3;
//        System.out.println(codec_297.serialize(node));
//        TreeNode deserialize = codec_297.deserialize(codec_297.serialize(node));
//        int j = 1;
//    }
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if(root == null) return "";
//        String str = dfs(root);
//        return str.substring(0, str.length() - 1);
//    }
//
//    private String dfs(TreeNode root) {
//        if(root == null) return "";
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(root.val).append("(").append(countTree(root.left)).append(",")
//            .append(countTree(root.right)).append(")/")
//            .append(dfs(root.left))
//            .append(dfs(root.right));
//        return stringBuilder.toString();
//    }
//
//    private int countTree(TreeNode root) {
//        if(root == null) return 0;
//        return 1 + countTree(root.left) + countTree(root.right);
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if(data.equals("")) return null;
//        String[] split = data.split("/");
//        return recursion(split, 0, split.length - 1);
//    }
//
//    private TreeNode recursion(String[] split, int start, int end) {
//        if(start > end || start >= split.length) return null;
//        String nodeStr = split[start];
//        int leftBracketIndex = nodeStr.indexOf("(");
//        int val = Integer.parseInt(nodeStr.substring(0, leftBracketIndex));
//        String scope = nodeStr.substring(leftBracketIndex + 1, nodeStr.indexOf(")"));
//        String[] positionArr = scope.split(",");
//        int left = Integer.parseInt(positionArr[0]);
//        TreeNode node = new TreeNode(val);
//        node.left = recursion(split, start + 1, start + left);
//        node.right = recursion(split, start + left + 1, end);
//        return node;
//    }
}
