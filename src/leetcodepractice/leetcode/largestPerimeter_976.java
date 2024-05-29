package leetcodepractice.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class largestPerimeter_976 {

    /**
     * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,1,2]
     * 输出：5
     * 解释：你可以用三个边长组成一个三角形:1 2 2。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,1,10]
     * 输出：0
     * 解释：
     * 你不能用边长 1,1,2 来组成三角形。
     * 不能用边长 1,1,10 来构成三角形。
     * 不能用边长 1、2 和 10 来构成三角形。
     * 因为我们不能用任何三条边长来构成一个非零面积的三角形，所以我们返回 0。
     *
     * @param nums
     * @return
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = length - 1; i >= 2; i--) {
            int j = i - 1;
            int k = j - 1;
            if (nums[i] + nums[j] > nums[k] && nums[j] + nums[k] > nums[i] && nums[i] + nums[k] > nums[j]) {
                return nums[i] + nums[j] + nums[k];
            }
        }

        return 0;
    }
}
