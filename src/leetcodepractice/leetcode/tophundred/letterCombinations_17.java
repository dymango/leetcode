package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class letterCombinations_17 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * @param digits
     * @return
     */
    private final List<String> result = new ArrayList<>();
    private final Map<Character, List<String>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("q", "p", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));
        get(0, digits, new ArrayList<>());
        return result;
    }

    private void get(int index, String digits, List<String> list) {
        if (index >= digits.length()) {
            result.add(String.join("", new ArrayList<>(list)));
            return;
        }

        char c = digits.charAt(index);
        List<String> strings = map.get(c);
        for (String string : strings) {
            list.add(string);
            get(index + 1, digits, list);
            list.remove(list.size() - 1);
        }
    }
}
