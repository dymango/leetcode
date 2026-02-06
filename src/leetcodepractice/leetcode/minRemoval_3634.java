package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dimmy
 */
public class minRemoval_3634 {

    /**
     * 给你一个整数数组 nums 和一个整数 k。
     * 如果一个数组的 最大 元素的值 至多 是其 最小 元素的 k 倍，则该数组被称为是 平衡 的。
     * 你可以从 nums 中移除 任意 数量的元素，但不能使其变为 空 数组。
     * 返回为了使剩余数组平衡，需要移除的元素的 最小 数量。
     * 注意：大小为 1 的数组被认为是平衡的，因为其最大值和最小值相等，且条件总是成立。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 1  2  5
     * 输入：nums = [2,1,5], k = 2
     * <p>
     * 输出：1
     * <p>
     * 解释：
     * <p>
     * 移除 nums[2] = 5 得到 nums = [2, 1]。
     * 现在 max = 2, min = 1，且 max <= min * k，因为 2 <= 1 * 2。因此，答案是 1。
     *
     * @param nums
     * @param k
     * @return
     *
     * 69,186,86,137,156,189
     */
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        var list = new ArrayList<Integer>();
        for (var num : nums) {
            list.add(num);
        }

        if (nums.length == 1) return 0;
        int count = 0;
        while (list.size() >= 2 && list.getFirst() * k < list.getLast()) {
            var left = list.getLast() / list.get(1);
            var right = list.get(list.size() - 2) / list.getFirst();
            if (left < right) {
                list.removeFirst();
            } else {
                list.removeLast();
            }

            count++;
        }

        return count;
    }
}
