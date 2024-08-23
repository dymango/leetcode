package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class maxSubArray50 {

    //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //
    //子数组
    //是数组中的一个连续部分。
    public int maxSubArray(int[] nums) {
        var length = nums.length;
        int[] max = new int[length];
        max[0] = nums[0];
        int pre = nums[0];
        int maxNum = max[0];
        for (int i = 1; i < length; i++) {
            int sum =  nums[i] + pre;
            var tm = Math.max(nums[i], sum);
            maxNum = Math.max(maxNum, tm);
            pre = tm;
        }

        return maxNum;
    }
}
