package app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 *
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 *
 * 输入:
 *      1
 *     /
 *    2
 * 输出:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * 示例 2:
 *
 * 输入:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * 示例 3:
 *
 * 输入:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrintTree_655 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root);
        int w = (1<<h ) -1 ; // 2^h -1  二叉树的最大宽度，也是字符串数组的长度

        List<List<String>> res = new ArrayList<>();
        //先将res全部置为“”
        for(int i = 0 ; i < h ; i ++) {
            List<String> item = new ArrayList<>();
            for(int j = 0 ; j < w ; j++)
                item.add("");
            res.add(item);
        }

        //填充数字
        fill(root, res, 0, 0, w-1);
        return res;
    }

    //返回二叉树的高度
    int getHeight(TreeNode root) {
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /*
        实际上相当于是一个二分，在左子树去寻找相应的位置，满足
            根节点在区域中间，左孩子在左边的中间，右孩子在右边的中间
    */
    void fill(TreeNode node, List<List<String>> res , int h , int l , int r) {
        if(node == null) return;
        int mid = (l +r) /2;
        String s= res.get(h).get(mid);
        res.get(h).set(mid, Integer.toString(node.val));    //相应位置填上数字

        fill(node.left, res, h+1, l, mid-1);
        fill(node.right, res, h+1, mid+1, r);
    }
}
