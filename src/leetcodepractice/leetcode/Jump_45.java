package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class Jump_45 {

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     * <p>
     * 0 <= j <= nums[i] 
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 示例 2:
     * <p>
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     *  
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     * 题目保证可以到达 nums[n-1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        return count(nums, nums.length - 1);
    }

    public int count(int[] nums, int targetIndex) {
        if (targetIndex == 0) return 0;
        for (int i = 0; i < targetIndex; i++) {
            if (nums[i] + i >= targetIndex) {
                return count(nums, i) + 1;
            }
        }

        return 0;
    }
}
