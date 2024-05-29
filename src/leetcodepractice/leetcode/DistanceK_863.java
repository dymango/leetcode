package leetcodepractice.leetcode;

import leetcodepractice.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dimmy
 */
public class DistanceK_863 {

    /**
     * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
     * <p>
     * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
     * 输出：[7,4,1]
     * 解释：
     * 所求结点为与目标结点（值为 5）距离为 2 的结点，
     * 值分别为 7，4，以及 1
     * <p>
     * <p>
     * <p>
     * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
     * 上面的输入仅仅是对这些对象进行了序列化描述。
     *  
     * <p>
     * 提示：
     * <p>
     * 给定的树是非空的。
     * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
     * 目标结点 target 是树上的结点。
     * 0 <= K <= 1000.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param target
     * @param k
     * @return
     * @CASE [0, null, 1, null, 2, null, 3]
     * 1
     * 2
     *
     * [0,1,null,3,2]
     * 2
     * 1
     */
    int K, T;
    List<Integer> list;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k == 0) return List.of(target.val);
        K = k;
        T = target.val;
        list = new ArrayList<>();
        getInstance(root);
        return list;
    }

    public Integer getInstance(TreeNode root) {
        if (root == null) return null;
        if (root.val == T) {
            int count = K;
            Queue<TreeNode> queue = new LinkedList<>();
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
            while (!queue.isEmpty()) {
                count--;
                if (count == 0) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        TreeNode poll = queue.poll();
                        list.add(poll.val);
                    }
                    break;
                }

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }

                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
            }
            return 0;
        }
        Integer leftInstance = getInstance(root.left);
        if (leftInstance != null) {
            if(leftInstance + 1== K) {
                list.add(root.val);
            } else {
                int count = K - leftInstance - 1;
                Queue<TreeNode> queue = new LinkedList<>();
                if (root.right != null) queue.offer(root.right);
                while (!queue.isEmpty()) {
                    count--;
                    if (count == 0) {
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            TreeNode poll = queue.poll();
                            list.add(poll.val);
                        }
                        break;
                    }

                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        TreeNode poll = queue.poll();
                        if (poll.left != null) {
                            queue.offer(poll.left);
                        }

                        if (poll.right != null) {
                            queue.offer(poll.right);
                        }
                    }
                }
            }
        }

        Integer rightInstance = getInstance(root.right);
        if (rightInstance != null) {
            if(rightInstance + 1 == K) list.add(root.val);
            else {
                int count = K - rightInstance - 1;
                Queue<TreeNode> queue = new LinkedList<>();
                if (root.left != null) queue.offer(root.left);
                while (!queue.isEmpty()) {
                    count--;
                    if (count == 0) {
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            TreeNode poll = queue.poll();
                            list.add(poll.val);
                        }
                        break;
                    }

                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        TreeNode poll = queue.poll();
                        if (poll.left != null) {
                            queue.offer(poll.left);
                        }

                        if (poll.right != null) {
                            queue.offer(poll.right);
                        }
                    }
                }
            }
        }

        if (leftInstance == null && rightInstance == null) return null;
        if (leftInstance != null) return leftInstance + 1;
        return rightInstance + 1;
    }
}
