package app.leetcode;

/**
 * @author dimmy
 */
public class CanJump_55 {

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * <p>
     * 示例 1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * <p>
     * 示例 2：
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *  
     * 提示：
     * 1 <= nums.length <= 3 * 104
     * 0 <= nums[i] <= 105
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        return find(nums, nums.length - 1);
    }

    private boolean find(int[] nums, int index) {
        if (index == -1) return false;
        if (index == 0) return true;
        int left = -1;
        for (int i = 0; i < index; i++) {
            if (nums[i] + i >= index) {
                left = i;
                break;
            }
        }

        return find(nums, left);
    }

    public boolean canJumpV2(int[] nums) {
        int left = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= left) {
                left = i;
            }
        }

        return left == 0;
    }
}
