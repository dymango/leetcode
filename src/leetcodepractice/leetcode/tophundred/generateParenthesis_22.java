package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class generateParenthesis_22 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * @param n
     * @return
     */
    int N;
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        N = n*2;
        generate(new ArrayList<>(), 0, 0);
        return result;
    }

    private void generate(List<Character> list, int lc, int rc) {
        if (list.size() == N) {
            if (lc == rc) result.add(new ArrayList<>(list).stream().map(String::valueOf).collect(Collectors.joining("")));
            return;
        }

        if (rc > lc) return;
        list.add('(');
        generate(list, lc + 1, rc);
        list.remove(list.size() - 1);

        list.add(')');
        generate(list, lc, rc + 1);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new generateParenthesis_22().generateParenthesis(3));
    }
}
