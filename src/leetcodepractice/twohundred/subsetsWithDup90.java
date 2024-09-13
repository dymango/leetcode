package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class subsetsWithDup90 {

    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
     * 子集
     * （幂集）。
     *
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * @param nums
     * @return
     */
    List<List<Integer>> r = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        r.add(new ArrayList<>());
        cal(nums, 0, new ArrayList<>());
        return r;
    }

    void cal(int[] nums, int start, List<Integer> list) {
        if(!list.isEmpty()) {
            r.add(new ArrayList<>(list));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if(!set.add(nums[i])) continue;
            list.add(nums[i]);
            cal(nums, i + 1, list);
            list.removeLast();
        }
    }
}
