package leetcodepractice.tencent;

import java.util.PriorityQueue;

/**
 * @author dimmy
 */
public class FindKthLargest_215 {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *  
     *
     * 提示：
     *
     * 1 <= k <= nums.length <= 104
     * -104 <= nums[i] <= 104
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            priorityQueue.offer(num);
        }

        while (k-- > 1) {
            priorityQueue.poll();
        }

        return priorityQueue.peek();
    }
}
