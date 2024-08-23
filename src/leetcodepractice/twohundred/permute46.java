package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class permute46 {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, new boolean[nums.length]);
    }

    public List<List<Integer>> permute(int[] nums, boolean[] visited) {
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
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
