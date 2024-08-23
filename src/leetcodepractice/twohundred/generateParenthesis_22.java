package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class generateParenthesis_22 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 8
     * <p>
     * ["()()()()","(()())()","(()(()))","()()(())","(())()()","(((())))","()((()))","()(())()","()(()())","(()()())","((()()))","((()))()","((())())"]
     * 预期结果
     * ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
     *
     * @param n
     * @return
     */
    Map<Integer, List<String>> map = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (map.containsKey(n)) return map.get(n);
        if (n == 1) return List.of("()");
        var set = new HashSet<String>();
        for (int i = 1; i <= n / 2; i++) {
            var list = generateParenthesis(i);
            var list1 = generateParenthesis(n - i);
            for (String s : list) {
                for (String string : list1) {
                    set.add(s + string);
                    set.add(string + s);
                }
            }

            if (i == 1) {
                for (String parenthesis : list1) {
                    set.add("(" + parenthesis + ")");
                }
            }
        }

        var strings = new ArrayList<>(set);
        map.put(n, strings);
        return strings;
    }
}
