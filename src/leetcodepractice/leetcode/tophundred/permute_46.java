package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class permute_46 {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出：[[1]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     *
     * @param nums
     * @return
     */
    List<List<Integer>> r = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        listAll(new ArrayList<>(), nums, new HashSet<>());
        return r;
    }

    private void listAll(List<Integer> list, int[] nums, Set<Integer> visited) {
        if (list.size() == nums.length) {
            r.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited.add(i)) continue;
            list.add(nums[i]);
            listAll(list, nums, visited);
            list.remove(list.size() - 1);
            visited.remove(i);
        }
    }
}
