package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class subsetsWithDup_90 {

    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     *
     * @param nums
     * @return
     */
    List<List<Integer>> r = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrace(nums, new ArrayList<>(), 0);
        return r;
    }

    private void backTrace(int[] nums, List<Integer> list, int index) {
        r.add(new ArrayList<>(list));
        if (index >= nums.length) return;
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!visited.add(nums[i])) continue;
            list.add(nums[i]);
            backTrace(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
