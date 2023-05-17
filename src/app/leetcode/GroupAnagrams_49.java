package app.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author dimmy
 */
public class GroupAnagrams_49 {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 示例 2:
     * <p>
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     * <p>
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] 仅包含小写字母
     *
     * @param strs
     * @return
     */
    public static void main(String[] args) {
        new GroupAnagrams_49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (visited[i]) continue;
            List<String> list = new ArrayList<>();
            visited[i] = true;
            list.add(str);
            int[] strCount = new int[26];
            for (int j = 0; j < str.length(); j++) {
                strCount[str.charAt(j) - 97]++;
            }

            //["eat","tea","tan","ate","nat","bat"]
            tag:
            for (int j = 0; j < strs.length; j++) {
                String nStr = strs[j];
                if (i == j || visited[j] || str.length() != nStr.length()) continue;
                if (Objects.equals(nStr, "") && Objects.equals(str, "")) {
                    list.add(nStr);
                    visited[j] = true;
                    continue;
                }

                int[] nStrCount = new int[26];
                for (int k = 0; k < nStr.length(); k++) {
                    int c = nStr.charAt(k) - 97;
                    nStrCount[c]++;
                    if (nStrCount[c] > strCount[c]) continue tag;
                }

                boolean match = true;
                for (int k = 0; k < 26; k++) {
                    if (strCount[k] != nStrCount[k]) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    visited[j] = true;
                    list.add(nStr);
                }
            }

            result.add(list);
        }

        return result;
    }
}
