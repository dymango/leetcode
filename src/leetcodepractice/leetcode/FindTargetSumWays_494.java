package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class FindTargetSumWays_494 {

    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     *
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     *
     *  
     *
     * 示例：
     *
     * 输入：nums: [1, 1, 1, 1, 1], S: 3
     * 输出：5
     * 解释：
     *
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     *
     * 一共有5种方法让最终目标和为3。
     *  
     *
     * 提示：
     *
     * 数组非空，且长度不会超过 20 。
     * 初始的数组的和不会超过 1000 。
     * 保证返回的最终结果能被 32 位整数存下。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/target-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static int count = 0;
    static int target;
    public static int findTargetSumWays(int[] nums, int S) {
        target= S;
        dfs(nums, 0, 0);
        return count;
    }

    public static void dfs(int[] nums, int index, int sum) {
        if(index >= nums.length) {
            if(sum == target) count++;
            return;
        }
        dfs(nums, index + 1, sum+nums[index]);
        dfs(nums, index + 1, sum-nums[index]);
    }

    public static void main(String[] args) {
        findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
