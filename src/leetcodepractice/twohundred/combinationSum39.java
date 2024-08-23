package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class combinationSum39 {

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * <p>
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * <p>
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return cal(candidates, 0, candidates.length - 1, target);
    }

    public List<List<Integer>> cal(int[] candidates, int start, int end, int target) {
        List<List<Integer>> r = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            var candidate = candidates[i];
            var remained = target - candidate;
            if (remained < 0) return r;
            if (remained == 0) {
                var l = new ArrayList<Integer>();
                l.add(candidate);
                r.add(l);
                continue;
            }
            var list = cal(candidates, i, end, remained);
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
