package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class maxProduct_152 {

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * 测试用例的答案是一个 32-位 整数。
     * <p>
     * 子数组 是数组的连续子序列。
     * 2 3 -2 4
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tmin = min;
            min = Math.min(num, Math.min(max * num, min * num));
            max = Math.max(num, Math.max(max * num, tmin * num));
            r = Math.max(r, max);
        }

        return r;
    }

    public static void main(String[] args) {
        new maxProduct_152().maxProduct(new int[]{2,3,-2,4});
    }
}
