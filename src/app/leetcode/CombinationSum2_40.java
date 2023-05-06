package app.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class CombinationSum2_40 {

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * <p>
     * 注意：解集不能包含重复的组合。 
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     *  
     * <p>
     * 提示:
     * <p>
     * 1 <= candidates.length <= 100
     * 1 <= candidates[i] <= 50
     * 1 <= target <= 30
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candidates
     * @param target
     * @return
     */
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }

    private void backtracking(List<Integer> nums, int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(nums));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < candidates.length; i++) {
            if (!set.add(candidates[i])) continue;
            int nextSum = sum + candidates[i];
            if (nextSum > target) {
                return;
            }

            nums.add(candidates[i]);
            backtracking(nums, candidates, target, i + 1, nextSum);
            nums.remove(nums.size() - 1);
        }
    }
}
