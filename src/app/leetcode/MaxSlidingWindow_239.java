package app.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dimmy
 */
public class MaxSlidingWindow_239 {

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     * <p>
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     * 通过次数
     * 489.1K
     * 提交次数
     * 989.6K
     * 通过率
     * 49.4%
     *
     * @param nums
     * @param k
     * @return
     */
    public static void main(String[] args) {
//        new MaxSlidingWindow_239().maxSlidingWindow(new int[]{7,2,4}, 2);
        int[] ints = new MaxSlidingWindow_239().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        int o = 1;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> r = new ArrayList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offer(i);
        }

        for (int i = k - 1; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offer(i);
            int left = i - k + 1;
            while (queue.peekFirst() < left) {
                queue.pollFirst();
            }

            if (!queue.isEmpty()) result[i - k + 1] = nums[queue.peekFirst()];
        }

        return result;
    }
}
