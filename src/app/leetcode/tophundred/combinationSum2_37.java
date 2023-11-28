package app.leetcode.tophundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class combinationSum2_37 {

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * 注意：解集不能包含重复的组合。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     *
     * @param candidates
     * @param target
     * @return
     */
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, 0, target, new ArrayList<>(), 0);
        return result;
    }

    private void backTracking(int[] candidates, int index, int target, List<Integer> list, int sum) {
        int length = candidates.length;
        for (int i = index; i < length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) continue;
            int temp = sum + candidates[i];
            list.add(candidates[i]);
            if (temp < target) {
                backTracking(candidates, i + 1, target, list, temp);
                list.remove(list.size() - 1);
            } else if (temp == target) {
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                break;
            } else {
                list.remove(list.size() - 1);
                break;
            }
        }
    }
}
