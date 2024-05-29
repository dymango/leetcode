package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class IsMonotonic_896 {

    /**
     * 如果数组是单调递增或单调递减的，那么它是 单调 的。
     * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
     * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,2,3]
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：nums = [6,5,4,4]
     * 输出：true
     * 示例 3：
     * <p>
     * 输入：nums = [1,3,2]
     * 输出：false
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -105 <= nums[i] <= 105
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/monotonic-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public boolean isMonotonic(int[] nums) {
        boolean increase = false;
        boolean decrease = false;
        for (int i = 1; i < nums.length; i++) {
            int dif = nums[i] - nums[i - 1];
            if (dif == 0) continue;
            if (dif < 0) {
                decrease = true;
                if (increase) return false;
            } else {
                increase = true;
                if (decrease) return false;
            }
        }

        return true;
    }
}
