package app.jianzhioffer;

/**
 * @author dimmy
 */
public class TwoSum_55 {

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     * <p>
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     *  
     * <p>
     * 限制：
     * <p>
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return new int[]{nums[start], nums[end]};
            } else if (sum > target) end--;
            else start++;
        }

        return new int[0];
    }
}
