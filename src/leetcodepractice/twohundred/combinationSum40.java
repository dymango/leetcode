package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class combinationSum40 {
    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * <p>
     * 注意：解集不能包含重复的组合。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return cal(candidates, 0, candidates.length - 1, target);
    }

    public List<List<Integer>> cal(int[] candidates, int start, int end, int target) {
        List<List<Integer>> r = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            var candidate = candidates[i];
            var remained = target - candidate;
            if (remained < 0) return r;
            if (remained == 0) {
                var l = new ArrayList<Integer>();
                l.add(candidate);
                r.add(l);
                continue;
            }
            var list = cal(candidates, i + 1, end, remained);
            if (list.isEmpty()) {
                continue;
            }

            for (List<Integer> integers : list) {
                integers.add(candidate);
                r.add(integers);
            }
        }

        return r;
    }


}
