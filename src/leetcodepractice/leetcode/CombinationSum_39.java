package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class CombinationSum_39 {

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     * <p>
     * 示例 1：
     * <p>
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * 示例 2：
     * <p>
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     * <p>
     * 输入: candidates = [2], target = 1
     * 输出: []
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= candidates.length <= 30
     * 2 <= candidates[i] <= 40
     * candidates 的所有元素 互不相同
     * 1 <= target <= 40
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candidates
     * @param target
     * @return
     */
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }

    private void backtracking(List<Integer> nums, int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int nextSum = sum + candidates[i];
            if (nextSum > target) {
                return;
            }

            nums.add(candidates[i]);
            backtracking(nums, candidates, target, i, nextSum);
            nums.remove(nums.size() - 1);
        }
    }
}
