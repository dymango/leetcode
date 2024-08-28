package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class maxProduct152 {

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
     * 子数组
     * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * 测试用例的答案是一个 32-位 整数。
     *
     * @param nums
     * @return
     */
    public static void main(String[] args) {
        new maxProduct152().maxProduct(new int[]{-4, -3, -2});
    }

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int r = max;
        for (int i = 1; i < nums.length; i++) {
            var a = max * nums[i];
            var b = min * nums[i];
            int ma = Math.max(nums[i], Math.max(a, b));
            int mi = Math.min(nums[i], Math.min(a, b));
            max = ma;
            min = mi;
            r = Math.max(r, max);
        }

        return r;
    }
}
