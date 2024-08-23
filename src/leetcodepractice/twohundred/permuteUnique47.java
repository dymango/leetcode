package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class permuteUnique47 {

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return permute(nums, new boolean[nums.length]);
    }

    public List<List<Integer>> permute(int[] nums, boolean[] visited) {
        List<List<Integer>> r = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if(!set.add(nums[i])) continue;
            visited[i] = true;
            var list = permute(nums, visited);
            for (List<Integer> integers : list) {
                integers.add(0, nums[i]);
                r.add(integers);
            }

            if (list.isEmpty()) {
                var integers = new ArrayList<Integer>();
                integers.add(nums[i]);
                r.add(integers);
            }

            visited[i] = false;
        }

        return r;
    }
}
