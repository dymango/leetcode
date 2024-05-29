package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class maxSubArray_53 {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     * <p>
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * <p>
     * <p>
     * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            sum = Math.max(num, num + sum);
            max = Math.max(max, sum);
        }

        return max;
    }
}
