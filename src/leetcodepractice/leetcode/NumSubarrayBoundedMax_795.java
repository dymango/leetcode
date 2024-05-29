package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class NumSubarrayBoundedMax_795 {

    /**
     * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
     *
     * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
     *
     * 例如 :
     * 输入:
     * A = [2, 1, 4, 3]
     * L = 2
     * R = 3
     * 输出: 3
     * 解释: 满足条件的子数组: [2], [2, 1], [3].
     * 注意:
     *
     * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
     * 数组 A 的长度范围在[1, 50000]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param left
     * @param right
     * @return
     *
     *
     * 根据以下步骤推导出解决方案：
     *
     * 其实我们只关心数组中的元素是否小于 L，大于 R，或者位于 [L, R] 之间。假设一个元素小于 L 标记为 0，位于 [L, R] 之间标记为 1，大于 R 标记为 2。
     *
     * 我们希望找出不包含 2 且至少包含一个 1 的子数组数量。因此可以看作是所有的 2 将数组拆分为仅包含 0 或 1 的子数组。例如在数组 [0, 0, 1, 2, 2, 1, 0, 2, 0]，2 将数组拆分为 [0, 0, 1]、[1, 0] 和 [0] 三个子数组。
     *
     * 接下来，需要计算每个只包含 0 或 1 的数组中，至少包含一个 1 的子数组数量。那么问题可以转换为先找出所有的子数组，再从中减去只包含 0 的子数组。
     *
     * 例如，[0, 0, 1] 有 6 个子数组，其中 3 个子数组只包含 0，3 个子数组至少包含一个 1；[1, 0] 有 3 个子数组，其中 1 个子数组只包含 0，2 个子数组至少包含一个 1；[0] 只有 1 个子数组，且这个子数组只包含 0。因此数组 A = [0, 0, 1, 2, 2, 1, 0, 2, 0] 中不包含 2，且至少包含一个 1 的子数组的数量是 3 + 2 + 0 = 5。
     *
     * 算法
     *
     * 假设 count(B) 用于计算所有元素都小于等于 B 的子数组数量。根据上面分析，本题答案为 count(R) - count(L-1)。
     *
     * 那么如何计算 count(B)？使用 cur 记录在 B 的左边，小于等于 B 的连续元素数量。当找到一个这样的元素时，在此位置上结束的有效子数组的数量为 cur + 1。当遇到一个元素大于 B 时，则在此位置结束的有效子数组的数量为 0。
     *
     * JavaPython
     *
     * class Solution {
     *     public int numSubarrayBoundedMax(int[] A, int L, int R) {
     *         return count(A, R) - count(A, L-1);
     *     }
     *
     *     public int count(int[] A, int bound) {
     *         int ans = 0, cur = 0;
     *         for (int x: A) {
     *             cur = x <= bound ? cur + 1 : 0;
     *             ans += cur;
     *         }
     *         return ans;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 N 是 A 的长度。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum/solution/qu-jian-zi-shu-zu-ge-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int length = nums.length;
        int count = 0;
        int[] max = new int[length];
        for (int i = 0; i < nums.length; i++) {
            max[i] = nums[i];
            if(max[i] >= left && max[i] <= right) count++;
            for (int j = i + 1; j < nums.length; j++) {
                max[j] = Math.max(max[j - 1], nums[j]);
                if(max[j] >= left && max[j] <= right) count++;
            }
        }

        return count;
    }

    public int numSubarrayBoundedMaxV2(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int bound) {
        int count = 0;
        int ans = 0;
        for (int num : nums) {
            if(num <= bound) {
                count += 1;
                ans += count;
            } else {
                count = 0;
            }
        }

        return ans;
    }
}
