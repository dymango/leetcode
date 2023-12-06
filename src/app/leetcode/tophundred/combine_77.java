package app.leetcode.tophundred;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class combine_77 {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 4, k = 2
     * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * 示例 2：
     * <p>
     * 输入：n = 1, k = 1
     * 输出：[[1]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 20
     * 1 <= k <= n
     *
     * @param n
     * @param k
     * @return
     */
    List<List<Integer>> result = new ArrayList<>();
    int K;
    int N;

    public List<List<Integer>> combine(int n, int k) {
        K = k;
        N = n;
        backTracking(1, new HashSet<>(), new ArrayList<>());
        return result;
    }

    private void backTracking(int n, Set<Integer> visited, List<Integer> list) {
        if (list.size() == K) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = n; i <= N; i++) {
            if (visited.contains(i)) continue;
            list.add(i);
            visited.add(i);
            backTracking(i + 1, visited, list);
            list.remove(list.size() - 1);
            visited.remove(i);
        }
    }
}
