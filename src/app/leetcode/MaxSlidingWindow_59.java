package app.leetcode;

import java.util.PriorityQueue;

/**
 * @author dimmy
 */
public class MaxSlidingWindow_59 {

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     * <p>
     * 示例:
     * <p>
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * <p>
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     *  
     * <p>
     * 提示：
     * <p>
     * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        //[1,3,1,2,0,5]
        //3
        int[] ints = new MaxSlidingWindow_59().maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        int i = 1;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(1);
        priorityQueue.offer(9);
        priorityQueue.offer(6);
        priorityQueue.offer(3);
        int a = 1;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(200, (o1, o2) -> {
            if (o1.number > o2.number) return -1;
            return 1;
        });

        int start = 0;
        int length = nums.length;
        int[] r = new int[length - k + 1];
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new Node(nums[i], i));
        }
        while (start + k - 1 < length) {
            while (!priorityQueue.isEmpty()) {
                Node peek = priorityQueue.peek();
                if (peek.index < start) priorityQueue.poll();
                else break;
            }

            r[start] = priorityQueue.peek().number;
            start++;
            if (start + k - 1 < length) priorityQueue.offer(new Node(nums[start + k - 1], start + k - 1));
        }

        return r;
    }


    public static class Node {
        public int number;
        public int index;

        public Node(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }
}
