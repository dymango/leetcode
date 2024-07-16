package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;
import leetcodepractice.leetcode.base.TreeNode;

/**
 * @author dimmy
 */
public class RecoverFromPreorder_1028 {

    /**
     * 我们从二叉树的根节点 root 开始进行深度优先搜索。
     * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
     * 如果节点只有一个子节点，那么保证该子节点为左子节点。
     * 给出遍历输出 S，还原树并返回其根节点 root。
     * <p>
     * 输入："1-2--3--4-5--6--7"
     * 输出：[1,2,5,3,4,6,7]
     * <p>
     * 1-2--3---4-5--6---7"
     * 输出：[1,2,5,3,null,6,null,4,null,7]
     *
     * @param traversal
     * @return
     */

    @MainParam
    String p = "1-401--349---90--88";

    @MainMethod
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal.isEmpty()) return null;
        if (!traversal.contains("-")) {
            return new TreeNode(Integer.parseInt(traversal));
        }

        int index = 0;
        while (traversal.charAt(index) != '-') index++;
        var v = Integer.parseInt(traversal.substring(0, index));
        var root = new TreeNode(v);
        var startV2 = findStartV2(traversal, index);
        var leftStart = startV2[0];
        var rightStart = startV2[1];
        if (leftStart != -1) {
            root.left = recoverFromPreorder(traversal.substring(leftStart, rightStart != -1 ? rightStart : traversal.length()));
        }
        if (rightStart != -1) {
            root.right = recoverFromPreorder(traversal.substring(rightStart));
        }

        return root;
    }

    private int[] findStartV2(String traversal, int start) {
        int s = start;
        var length = traversal.length();
        while (s < length && traversal.charAt(s) == '-') {
            s++;
        }

        int leftStart = s < traversal.length() ? s : -1;
        int deep = s - start;
        int td = 0;
        int rightStart = -1;
        while (s < length) {
            if (traversal.charAt(s) == '-') {
                td++;
            } else {
                if (td == deep) {
                    rightStart = s;
                    break;
                } else {
                    td = 0;
                }
            }
            s++;
        }

        return new int[]{leftStart, rightStart};
    }

    private int findStart(String traversal, int s, int deep) {
        int start = s;
        int td = 0;
        var length = traversal.length();
        while (start < length) {
            if (traversal.charAt(start) == '-') {
                td++;
            } else {
                if (td == deep) return start;
                else {
                    td = 0;
                }
            }

            start++;
        }

        return -1;
    }

    private int getDeep(String traversal) {
        int start = traversal.indexOf("-");
        var length = traversal.length();
        int size = 0;
        while (length > start && traversal.charAt(start) == '-') {
            start++;
            size++;
        }

        return size;
    }
}
