package app.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class subsets_78 {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     */

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0, new ArrayList<>());
        return result;
    }

    private void backTracking(int[] nums, int index, List<Integer> integers) {
        result.add(new ArrayList<>(integers));
        if (index >= nums.length) return;
        for (int i = index; i < nums.length; i++) {
            integers.add(nums[i]);
            backTracking(nums, i + 1, integers);
            integers.remove(integers.size() - 1);
        }
    }
}
