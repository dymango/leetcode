package leetcodepractice.leetcode.tophundred;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class threeSumClosest_16 {

    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * 返回这三个数的和。
     * 假定每组输入只存在恰好一个解。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     * <p>
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int first = 0;
        int length = nums.length;
        int dif = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        while (first < length - 2) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int second = first + 1;
            while (second < length - 1) {
                int num = nums[second] + nums[first];
                int third = second + 1;
                while (third < length) {
                    int sum = nums[third] + num;
                    if (sum == target) return sum;
                    if (Math.abs(sum - target) < dif) {
                        dif = Math.min(dif, Math.abs(sum - target));
                        result = sum;
                    }

                    third++;
                }

                second++;
            }

            first++;
        }

        return result;
    }

    public int threeSumClosestV2(int[] nums, int target) {
        Arrays.sort(nums);
        int best = Integer.MAX_VALUE;
        int length = nums.length;
        for (int first = 0; first < length; first++) {
            int second = first + 1;
            int third = length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(best - target)) best = sum;
                if (sum > target) {
                    third--;
                } else {
                    second++;
                }
            }
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(new threeSumClosest_16().threeSumClosestV2(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
        System.out.println(new threeSumClosest_16().threeSumClosestV2(new int[]{-1, 2, 1, -4}, 1));
    }
}
