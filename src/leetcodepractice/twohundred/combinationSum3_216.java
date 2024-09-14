package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dimmy
 */
public class combinationSum3_216 {

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * <p>
     * 只使用数字1到9
     * 每个数字 最多使用一次
     * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     *
     * @param k
     * @param n
     * @return
     */
    List<List<Integer>> r;

    public List<List<Integer>> combinationSum3(int k, int n) {
        r = new ArrayList<>();
        backtrace(new LinkedList<>(), k, n, 1, 0);
        return r;
    }

    void backtrace(List<Integer> list, int k, int n, int cur, int sum) {
        if (list.size() == k) {
            if (sum == n) {
                r.add(new ArrayList<>(list));
            }

            return;
        }

        for (int i = cur; i <= 9; i++) {
            list.add(i);
            backtrace(list, k, n, i + 1, sum+i);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        var list = new ArrayList<Node>();
        list.add(new Node(10));
        var newList = new ArrayList<>(list);
        list.get(0).value = 100;
        System.out.println(newList.get(0).value);
    }

    public static class Node {
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
