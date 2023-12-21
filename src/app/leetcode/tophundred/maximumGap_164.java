package app.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class maximumGap_164 {

    /**
     * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
     * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
     * <p>
     * 示例 1:
     * 输入: nums = [3,6,9,1,2, 20]
     * 输出: 3
     * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
     * <p>
     * 示例 2:
     * 输入: nums = [10]
     * 输出: 0
     * 解释: 数组元素个数小于 2，因此返回 0。
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 105
     * 0 <= nums[i] <= 109
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        List<List<Node>> buckets = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            buckets.add(new ArrayList<>());
        }

        List<Node> nodes = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nodes.add(new Node(num, i));
        }

        int max = 0;
        while (true) {
            boolean cal = false;
            for (Node node : nodes) {
                int val = node.val;
                int remain = val % 10;
                buckets.get(remain).add(node);
                cal = true;
            }

            if (!cal) break;
            List<Node> tempNodes = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                List<Node> sortedNodes = buckets.get(i);
                for (Node sortedNode : sortedNodes) {
                    if (sortedNode.val < 10) {
                        int n = nums[sortedNode.index];
                        max = Math.max(max, n - (!result.isEmpty() ? result.get(result.size() - 1) : 0));
                        result.add(n);
                    } else {
                        sortedNode.val /= 10;
                        tempNodes.add(sortedNode);
                    }
                }

                sortedNodes.clear();
            }

            nodes = tempNodes;
        }

        return max;
    }


    public static class Node {
        public int val;
        public int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
//        new maximumGap_164().maximumGap(new int[]{3,6,9,1});
        new maximumGap_164().maximumGap(new int[]{15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740});
    }
}
