package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author dimmy
 */
public class diffWaysToCompute241 {
    /**
     * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
     * <p>
     * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
     * <p>
     * <p>
     * 输入：expression = "2*3-4*5"
     * 输出：[-34,-14,-10,-10,10]
     * 解释：
     * (2*(3-(4*5))) = -34
     * ((2*3)-(4*5)) = -14
     * ((2*(3-4))*5) = -10
     * (2*((3-4)*5)) = -10
     * (((2*3)-4)*5) = 10
     *
     * @param expression
     * @return
     */
    public static void main(String[] args) {
        new diffWaysToCompute241().diffWaysToCompute("2*3-4*5");
    }

    List<Integer>[][] map;

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> numbers = new ArrayList<>();
        List<String> symbols = new ArrayList<>();
        map = new List[expression.length()][expression.length()];
        var start = 0;
        var end = 0;
        while (end < expression.length()) {
            var c = expression.charAt(end);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                var n = expression.substring(start, end);
                var s = expression.substring(end, end + 1);
                numbers.add(Integer.parseInt(n));
                symbols.add(s);
                end++;
                start = end;
            } else {
                if (end == expression.length() - 1) {
                    var n = expression.substring(start, end + 1);
                    numbers.add(Integer.parseInt(n));
                    break;
                }
                end++;
            }
        }

        var list = calculateComponent(numbers, symbols, 0, numbers.size() - 1);
        return list;
    }

    private List<Integer> calculateComponent(List<Integer> numbers, List<String> symbols, int start, int end) {
        if (start > end) {
            return new ArrayList<>();
        }
        if (start == end) {
            return List.of(numbers.get(start));
        }

        if (map[start][end] != null) {
            return map[start][end];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            var left = calculateComponent(numbers, symbols, start, i);
            var right = calculateComponent(numbers, symbols, i + 1, end);
            if (left.isEmpty()) {
                list.addAll(right);
            } else if (right.isEmpty()) {
                list.addAll(left);
            } else {
                for (Integer l : left) {
                    for (Integer r : right) {
                        var c = symbols.get(i);
                        if (Objects.equals(c, "+")) {
                            list.add(l + r);
                        } else if (Objects.equals(c, "-")) {
                            list.add(l - r);
                        } else if (Objects.equals(c, "*")) {
                            list.add(l * r);
                        } else {
                            list.add(l / r);
                        }
                    }
                }
            }
        }

        map[start][end] = list;
        return list;
    }
}
