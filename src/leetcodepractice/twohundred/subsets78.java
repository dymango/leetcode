package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class subsets78 {
    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
     * 子集
     * （幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * @param nums
     * @return
     */

    List<List<Integer>> r;

    public List<List<Integer>> subsets(int[] nums) {
        r = new ArrayList<>();
        r.add(new ArrayList<>());
        subsets(nums, 0, nums.length -1, new ArrayList<>());
        return r;
    }

    public void subsets(int[] nums, int start, int end, List<Integer> list) {
        if (!list.isEmpty()) {
            r.add(new ArrayList<>(list));
        }

        for (int i = start; i <= end; i++) {
            list.add(nums[i]);
            subsets(nums, i + 1, end, list);
            list.removeLast();
        }
    }
}
