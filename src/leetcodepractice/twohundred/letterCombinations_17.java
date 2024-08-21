package leetcodepractice.twohundred;

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
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     * <p>
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     *
     * @param digits
     * @return
     */
    private final Map<Integer, List<Character>> map = initMap();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        var c = digits.charAt(0);
        var characters = map.get(c - '0');
        List<String> r = new ArrayList<>();
        var remain = letterCombinations(digits.substring(1));
        for (Character character : characters) {
            if(remain.isEmpty()) {
                r.add(String.valueOf(character));
            } else {
                remain.forEach(s -> {
                    r.add(character + s);
                });
            }
        }

        return r;
    }

    public static void main(String[] args) {
        new letterCombinations_17().letterCombinations("23");
    }

    private Map<Integer, List<Character>> initMap() {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
        return map;
    }
}
