package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class combine77 {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     *
     * @param n
     * @param k
     * @return
     */
    int K;
    List<List<Integer>> r;

    public List<List<Integer>> combine(int n, int k) {
        r = new ArrayList<>();
        K = k;
        combine(1, n, new ArrayList<>());
        return r;
    }

    public void combine(int start, int end, List<Integer> list) {
        if (list.size() == K) {
            r.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= end; i++) {
            list.add(i);
            combine(i + 1, end, list);
            list.removeLast();
        }
    }
}
