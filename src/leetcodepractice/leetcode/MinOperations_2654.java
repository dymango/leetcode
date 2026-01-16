package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MinOperations_2654 {

    /**
     * 给你一个下标从 0 开始的 正 整数数组 nums 。你可以对数组执行以下操作 任意 次：
     * 选择一个满足 0 <= i < n - 1 的下标 i ，将 nums[i] 或者 nums[i+1] 两者之一替换成它们的最大公约数。
     * 请你返回使数组 nums 中所有元素都等于 1 的 最少 操作次数。如果无法让数组全部变成 1 ，请你返回 -1 。
     *
     * 两个正整数的最大公约数指的是能整除这两个数的最大正整数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,6,3,4]
     * 输出：4
     * 解释：我们可以执行以下操作：
     * - 选择下标 i = 2 ，将 nums[2] 替换为 gcd(3,4) = 1 ，得到 nums = [2,6,1,4] 。
     * - 选择下标 i = 1 ，将 nums[1] 替换为 gcd(6,1) = 1 ，得到 nums = [2,1,1,4] 。
     * - 选择下标 i = 0 ，将 nums[0] 替换为 gcd(2,1) = 1 ，得到 nums = [1,1,1,4] 。
     * - 选择下标 i = 2 ，将 nums[3] 替换为 gcd(1,4) = 1 ，得到 nums = [1,1,1,1] 。
     * 示例 2：
     *
     * 输入：nums = [2,10,6,14]
     * 输出：-1
     * 解释：无法将所有元素都变成 1 。
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt1 = 0;
        for (int x : nums) {
            if (x == 1) cnt1++;
        }
        if (cnt1 > 0) {
            return n - cnt1;
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; // 不用继续扩展更长的区间
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
