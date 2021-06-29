package app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class AmbiguousCoordinates_816 {

    /**
     * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
     * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
     * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
     *
     * 示例 1:
     * 输入: "(123)"
     * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
     * 示例 2:
     * 输入: "(00011)"
     * 输出:  ["(0.001, 1)", "(0, 0.011)"]
     * 解释:
     * 0.0, 00, 0001 或 00.01 是不被允许的。
     * 示例 3:
     * 输入: "(0123)"
     * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
     * 示例 4:
     * 输入: "(100)"s
     * 输出: [(10, 0)]
     * 解释:
     * 1.0 是不被允许的。
     *  
     *
     * 提示:
     *
     * 4 <= S.length <= 12.
     * S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ambiguous-coordinates
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static List<String> ambiguousCoordinates(String s) {
        s = s.replace("(", "");
        s = s.replace(")", "");

        int splitIndex = 1;

        List<String> result = new ArrayList<>();
        while (splitIndex < s.length()) {
            List<String> left = generate(s.substring(0, splitIndex));
            List<String> right = generate(s.substring(splitIndex));
            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
            splitIndex++;
        }

        return result;
    }

    private static List<String> generate(String s) {
        List<String> strings = new ArrayList<>();
        if(s.equals("0")) {
            strings.add("0");
            return strings;
        }

        if(s.length() == 1) {
            strings.add(s);
            return strings;
        }

        if(s.startsWith("0") && s.endsWith("0")) return strings;
        String point = ".";
        int index = 1;
        while (index < s.length()) {
            String start = s.substring(0, index);
            String end = s.substring(index);
            if(end.endsWith("0")) {
                index++;
                continue;
            }


            if(start.startsWith("0") && start.length() >= 2) {
                index++;
                continue;
            }

            strings.add(start + point + end);
            index++;
        }

        if(!s.startsWith("0") && s.length() > 1) strings.add(s);
        return strings;
    }

    public static void main(String[] args) {
//        ambiguousCoordinates("(123)");
        ambiguousCoordinates("(00011)");
    }
}
