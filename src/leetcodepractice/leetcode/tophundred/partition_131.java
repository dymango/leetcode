package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class partition_131 {

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     * <p>
     * 回文串 是正着读和反着读都一样的字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     * <p>
     * 输入：s = "a"
     * 输出：[["a"]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 16
     * s 仅由小写英文字母组成
     *
     * @param s
     * @return
     */
    Map<String, List<List<String>>> cache = new HashMap<>();

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) return new ArrayList<>();
        if (cache.containsKey(s)) return cache.get(s);
        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String subString = s.substring(0, i + 1);
            if (isPalindromicStrings(subString)) {
                List<List<String>> split = partition(s.substring(i + 1));
                if (i == s.length() - 1) {
                    results.add(List.of(subString));
                } else if (!split.isEmpty()) {
                    for (List<String> strings : split) {
                        ArrayList<String> r = new ArrayList<>();
                        r.add(subString);
                        r.addAll(strings);
                        results.add(r);
                    }
                }
            }
        }

        cache.put(s, results);
        return results;
    }

    private boolean isPalindromicStrings(String str) {
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
