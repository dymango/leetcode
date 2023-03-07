package app.leetcode;

/**
 * @author dimmy
 */
public class MaxSubarraySumCircular_918 {

    /**
     * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
     * <p>
     * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
     * <p>
     * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,-2,3,-2]
     * 输出：3
     * 解释：从子数组 [3] 得到最大和 3
     * 示例 2：
     * <p>
     * 输入：nums = [5,-3,5]
     * 输出：10
     * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
     * 示例 3：
     * <p>
     * 输入：nums = [3,-2,2,-3]
     * 输出：3
     * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
     *  
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104​​​​​​​
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-sum-circular-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int length = nums.length;
        int max = Math.max(nums[length - 1], nums[0]);
        int rightMax = nums[length - 1];
        int rightSum = nums[length - 1];
        int[] rightTagArr = new int[length];
        rightTagArr[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightSum += nums[i];
            rightTagArr[i] = Math.max(rightSum, rightTagArr[i + 1]);
            rightMax = Math.max(rightMax + nums[i], nums[i]);
            max = Math.max(max, rightMax);
        }


        int leftMax = nums[0];
        int leftSum = nums[0];
        for (int i = 1; i < length; i++) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax + nums[i], nums[i]);
            if(i < length - 1) {
                max = Math.max(leftSum + rightTagArr[i + 1], Math.max(max, leftMax));
            }
        }

        return max;
    }
}
