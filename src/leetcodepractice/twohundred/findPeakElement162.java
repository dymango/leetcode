package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class findPeakElement162 {

    /**
     * 峰值元素是指其值严格大于左右相邻值的元素。
     * <p>
     * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * <p>
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     * <p>
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int left = (index - 1 >= 0 ? nums[index - 1] : Integer.MIN_VALUE);
            int right = (index + 1 < nums.length ? nums[index + 1] : Integer.MIN_VALUE);
            if(left < nums[index] && right < nums[index]) return index;

            if(right < nums[index]) index+=2;
            else index++;
        }

        return 0;
    }
}
