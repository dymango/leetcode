package app.leetcode.tophundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class longestConsecutive_128 {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * <p>
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     *
     * @param nums
     * @return
     */
    Set<Integer> visited = new HashSet<>();

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int length = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 1;
        for (int num : nums) {
            countMap.put(num, 1);
        }

        for (int num : nums) {
            max = Math.max(max, get(countMap, num));
        }

        return max;
    }

    private int get(Map<Integer, Integer> countMap, int target) {
        if (visited.contains(target)) return countMap.get(target);
        int count = 0;
        if (countMap.containsKey(target)) {
            count = get(countMap, target - 1) + 1;
        }

        visited.add(target);
        countMap.put(target, count);
        return count;
    }
}
