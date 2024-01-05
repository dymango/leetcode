package app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class repeatedNTimes_961 {

    /**
     * 给你一个整数数组 nums ，该数组具有以下属性：
     * <p>
     * nums.length == 2 * n.
     * nums 包含 n + 1 个 不同的 元素
     * nums 中恰有一个元素重复 n 次
     * 找出并返回重复了 n 次的那个元素。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,3]
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：nums = [2,1,2,5,3,2]
     * 输出：2
     * 示例 3：
     * <p>
     * 输入：nums = [5,1,5,2,5,3,5,4]
     * 输出：5
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= n <= 5000
     * nums.length == 2 * n
     * 0 <= nums[i] <= 104
     * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
     *
     * @param nums
     * @return
     */
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer merge = map.merge(num, 1, Integer::sum);
            if (merge > 1) return num;
        }

        return -1;
    }
}
