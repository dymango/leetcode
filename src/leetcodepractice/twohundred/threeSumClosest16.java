package leetcodepractice.twohundred;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class threeSumClosest16 {
    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * <p>
     * 返回这三个数的和。
     * <p>
     * 假定每组输入只存在恰好一个解。
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        var length = nums.length;
        int result = 0;
        int dif = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int start = i + 1;
            int end = length - 1;
            while (start < end) {
                var sum = nums[i] + nums[start] + nums[end];
                if(sum == target) return sum;
                else if(sum > target) {
                    end--;
                } else {
                    start++;
                }

                var abs = Math.abs(sum - target);
                if(abs < dif) {
                    dif = abs;
                    result = sum;
                }
            }
        }

        return result;
    }
}
