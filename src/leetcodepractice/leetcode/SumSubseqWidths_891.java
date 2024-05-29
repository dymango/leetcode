package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class SumSubseqWidths_891 {
    /**
     * 一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。
     * 给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。由于答案可能非常大，请返回对 109 + 7 取余 后的结果。
     * 子序列 定义为从一个数组里删除一些（或者不删除）元素，但不改变剩下元素的顺序得到的数组。例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7] 的一个子序列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,1,3]
     * 输出：6
     * 解释：子序列为 [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3] 。
     * 相应的宽度是 0, 0, 0, 1, 1, 2, 2 。
     * 宽度之和是 6 。
     * 示例 2：
     * <p>
     * 输入：nums = [2]
     * 输出：0
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sum-of-subsequence-widths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    int[] NUMS;
    long sum = 0;

    public int sumSubseqWidths(int[] nums) {
        NUMS = nums;
        Arrays.sort(NUMS);
        for (int i = 2; i <= nums.length; i++) {
            backTracking(i, new ArrayList<>(), 0);
        }

        return (int) sum;
    }

    private void backTracking(int size, List<Integer> list, int index) {
        if (size == list.size()) {
            int gap = gap(list);
            sum += gap;
            sum %= 10000000009L;
            return;
        }

        if (index >= NUMS.length) return;

        for (int i = index; i < NUMS.length; i++) {
            list.add(NUMS[i]);
            backTracking(size, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private int gap(List<Integer> list) {
        return Math.abs(list.get(list.size() - 1) - list.get(0));
    }
}
