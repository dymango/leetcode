package app.leetcode;

/**
 * @author dimmy
 */
public class MaxProduct_152 {

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * 测试用例的答案是一个 32-位 整数。
     * 子数组 是数组的连续子序列。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * <p>
     * <p>limited public beta. You will be notified by email when you are accepted into the beta program. Joining the waitlist does not guarantee access.
     * 提示:
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -10 <= nums[i] <= 10
     * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
     *
     * @param nums
     * @return [-3,-1,-1]
     * <p>
     * [-2,3,-4]
     */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = nums[0];
        min[0] = nums[0];
        int result = max[0];
        for (int i = 1; i < length; i++) {
            int total = nums[i] * max[i - 1];
            int total2 = nums[i] * min[i - 1];
            max[i] = Math.max(nums[i], Math.max(total, total2));
            min[i] = Math.min(nums[i], Math.min(total, total2));
            result = Math.max(result, Math.max(min[i], max[i]));
        }

        return result;
    }
}
