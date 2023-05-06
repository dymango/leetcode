package app.jianzhioffer;

import app.leetcode.base.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dimmy
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec_37 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);

        node2.left = node4;
        node.left = node2;
        node.right = node3;
        Codec_37 codec = new Codec_37();
        String serialize = codec.serialize(node);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        int i = 1;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        String pre = preOrder(root);
        String in = inOrder(root);
        if (in.startsWith(",")) in = in.substring(1);
        return pre + "&" + in;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] split = data.split("&");
        String[] split1 = split[0].split(",");
        String[] split2 = split[1].split(",");
        List<String> preMA = Arrays.stream(split1).map(s -> s.split("\\*")[1]).collect(Collectors.toList());
        List<String> inMA = Arrays.stream(split2).map(s -> s.split("\\*")[1]).collect(Collectors.toList());
        List<Integer> pre = Arrays.stream(split1).map(s -> Integer.parseInt(s.split("\\*")[0])).collect(Collectors.toList());
        List<Integer> in = Arrays.stream(split2).map(s -> Integer.parseInt(s.split("\\*")[0])).collect(Collectors.toList());
        int size = pre.size();
        return decrypt(pre, in, preMA, inMA, 0, size - 1, 0, size - 1);
    }

    private TreeNode decrypt(List<Integer> preValues, List<Integer> inValues, List<String> preMA, List<String> inMA, int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie) return null;
        int rootVal = preValues.get(ps);
        String rootMA = preMA.get(ps);
        TreeNode root = new TreeNode(rootVal);
        int index = is;
        while ((inValues.get(index) != rootVal || !inMA.get(index).equals(rootMA)) && index <= ie) index++;
        int leftLength = index - is;
        root.left = decrypt(preValues, inValues, preMA, inMA, ps + 1, ps + leftLength, is, index - 1);
        root.right = decrypt(preValues, inValues, preMA, inMA, ps + leftLength + 1, pe, index + 1, ie);
        return root;
    }


    private String preOrder(TreeNode node) {
        if (node == null) return "";
        StringBuilder s = new StringBuilder(node.val + "*" + node);
        String leftStr = preOrder(node.left);
        if (!leftStr.isEmpty()) s.append(",").append(leftStr);
        String rightStr = preOrder(node.right);
        if (!rightStr.isEmpty()) s.append(",").append(rightStr);
        return s.toString();
    }

    private String inOrder(TreeNode node) {
        if (node == null) return "";
        StringBuilder s = new StringBuilder();
        String leftStr = inOrder(node.left);
        if (!leftStr.isEmpty()) {
            if (!s.isEmpty()) s.append(",");
            s.append(leftStr);
        }
        if (s.isEmpty()) s.append(node.val).append("*").append(node);
        else s.append(",").append(node.val).append("*").append(node);
        String rightStr = inOrder(node.right);
        if (!rightStr.isEmpty()) s.append(",").append(rightStr);
        return s.toString();
    }
}
