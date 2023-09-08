package app.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class SubsetsWithDup_90 {

    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
     *
     * @param nums
     * @return
     */
    List<List<Integer>> result = new ArrayList<>();


    public static void main(String[] args) {
        List<List<Integer>> lists = new SubsetsWithDup_90().subsetsWithDup(new int[]{1, 2, 2});
        int i = 1;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        collect(0, nums, new ArrayList<>());
        result.add(new ArrayList<>());
        return result;
    }

    private void collect(int start, int[] nums, List<Integer> list) {
        if (!list.isEmpty()) result.add(new ArrayList<>(list));
        if (start >= nums.length) return;
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!set.add(nums[i])) continue;
            list.add(nums[i]);
            collect(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }
}
