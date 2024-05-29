package leetcodepractice.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class CountOfAtoms_726 {

    /**
     * 给定一个化学式formula（作为字符串），返回每种原子的数量。
     * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
     * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
     * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
     * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
     * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * formula = "H2O"
     * 输出: "H2O"
     * 解释:
     * 原子的数量是 {'H': 2, 'O': 1}。
     * 示例 2:
     * <p>
     * 输入:
     * formula = "Mg(OH)2"
     * 输出: "H2MgO2"
     * 解释:
     * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
     * 示例 3:
     * <p>
     * 输入:
     * formula = "K4(ON(SO3)2)2"
     * 输出: "K4N2O14S4"
     * 解释:
     * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
     * 注意:
     * <p>
     * 所有原子的第一个字母为大写，剩余字母都是小写。
     * formula的长度在[1, 1000]之间。
     * formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
     * <p>
     * "(B2O39He17BeBe49)39"
     * <p>
     * "B78BeBe1911He663O1521"
     * "B78Be1950He663O1521"
     * <p>
     * "((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"
     * "672B588Be9772C3556H5250He42Li14910N24290O686"
     * "B18900Be18984C4200H5446He1386Li33894N50106O22638"
     * "B18900Be18984C4200H5446He1386Li33894N50106O22638"
     * <p>
     * "((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"
     * "672B588Be9772C3556H5250He42Li14910N24290O686"
     * "B18900Be18984C4200H5446He1386Li33894N50106O22638"
     *
     * @return
     */
    public static void main(String[] args) {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(countOfAtoms("Mg(OH)2"));
        System.out.println(countOfAtoms("H2O"));
        System.out.println(countOfAtoms("(H)"));
        System.out.println(countOfAtoms("H50"));
        System.out.println(countOfAtoms("(B2O39He17BeBe49)39"));
        System.out.println(countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
    }

    public static String countOfAtoms(String formula) {
        return build(formula).entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).map(entry -> entry.getKey() + (entry.getValue() > 1 ? entry.getValue() : "")).collect(Collectors.joining(""));
    }

    private static Map<String, Integer> build(String formula) {
        Map<String, Integer> numMap = new HashMap<>();
        char[] formulaChars = formula.toCharArray();
        Stack<Character> chars = new Stack<>();
        Stack<Character> nums = new Stack<>();
        for (int i = 0; i < formula.length(); i++) {
            if (formulaChars[i] >= 65 && formulaChars[i] <= 90) {
                chars.push(formulaChars[i]);
                if (i + 1 >= formula.length() || formulaChars[i + 1] == 40 || isCapital(formulaChars[i + 1])) {
                    StringBuilder str = new StringBuilder();
                    while (!chars.isEmpty()) {
                        str.insert(0, chars.pop());
                    }

                    numMap.merge(str.toString(), 1, Integer::sum);
                }
            } else if (formulaChars[i] >= 97 && formulaChars[i] <= 122) {
                chars.push(formulaChars[i]);
                if (i + 1 >= formula.length() || formulaChars[i + 1] == 40 || isCapital(formulaChars[i + 1])) {
                    StringBuilder str = new StringBuilder();
                    while (!chars.isEmpty()) {
                        str.insert(0, chars.pop());
                    }

                    numMap.merge(str.toString(), 1, Integer::sum);
                }
            } else if (formulaChars[i] >= 48 && formulaChars[i] <= 57) {
                nums.push(formulaChars[i]);
                if (i + 1 >= formula.length() || formulaChars[i + 1] < 48 || formulaChars[i + 1] > 57) {
                    StringBuilder str = new StringBuilder();
                    while (!chars.isEmpty()) {
                        str.insert(0, chars.pop());
                    }

                    StringBuilder num = new StringBuilder();
                    while (!nums.isEmpty()) {
                        num.insert(0, nums.pop());
                    }

                    numMap.merge(str.toString(), Integer.valueOf(num.toString()), Integer::sum);
                }
            } else if (formulaChars[i] == 40) {
                int start = i + 1;
                int end = i + 1;
                int bracket = 1;
                while (bracket != 0) {
                    if (formulaChars[end] == 40) bracket++;
                    else if (formulaChars[end] == 41) bracket--;
                    if (bracket != 0) end++;
                }

                Map<String, Integer> nmap = build(formula.substring(start, end));
                start = end + 1;
                end = end + 1;
                while (end < formula.length() && formulaChars[end] >= 48 && formulaChars[end] <= 57) end++;
                int multiple = start == end ? 1 : Integer.parseInt(formula.substring(start, end));
                nmap.entrySet().forEach(entry -> numMap.merge(entry.getKey(), entry.getValue() * multiple, Integer::sum));
                i = end - 1;
            }
        }

        return numMap;
    }

    private static boolean isCapital(char c) {
        return c >= 65 && c <= 90;
    }
}
