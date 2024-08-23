package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class canJump55 {

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(i > max) return false;
            max = Math.max(max, nums[i] + i);
            if(max >= nums.length - 1) return true;
        }

        return false;
    }
}
