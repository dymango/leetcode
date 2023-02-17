package app.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class SmallestRangeII_910 {

    /**
     * 给你一个整数数组 nums，和一个整数 k 。
     * <p>
     * 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
     * <p>
     * nums 的 分数 是 nums 中最大元素和最小元素的差值。
     * <p>
     * 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1], k = 0
     * 输出：0
     * 解释：分数 = max(nums) - min(nums) = 1 - 1 = 0 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,10], k = 2
     * 输出：6
     * 解释：将数组变为 [2, 8] 。分数 = max(nums) - min(nums) = 8 - 2 = 6 。
     * 示例 3：
     * <p>
     * 输入：nums = [1,3,6], k = 3
     * 输出：3
     * 解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3 。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 104
     * 0 <= k <= 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/smallest-range-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestRangeII(int[] nums, int k) {
        /**
         * nums.sort()
         *  n, ans = len(nums), nums[len(nums)-1] - nums[0] # 注意这里有个特殊情况，就是我们压根“不切这一刀”，而是把整个数组全部上移或下移，这也是一种策略。这种策略下的差值是 A[len - 1] - A[0]
         *  for i in range(n-1): # [0,n-2]
         *      imax = max(nums[i]+k, nums[n-1]-k)
         *      imin = min(nums[0]+k, nums[i+1]-k)
         *      ans = min(ans, imax - imin)
         *  return ans
         *
         */
        Arrays.sort(nums);
        int length = nums.length;
        int dif = nums[length - 1] - nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int max = Math.max(nums[i] + k, nums[length - 1] - k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            dif = Math.min(dif, max - min);
        }

        return dif;
    }
}
