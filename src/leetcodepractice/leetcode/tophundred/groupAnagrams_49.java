package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class groupAnagrams_49 {
    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     * <p>
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
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> r = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] cArr = new int[26];
            for (int i1 = 0; i1 < str.toCharArray().length; i1++) {
                cArr[str.charAt(i1) - 97]++;
            }

            map.put(i, cArr);
        }

        for (int i = 0; i < strs.length; i++) {
            if (visited.contains(i)) continue;
            ArrayList<String> strings = new ArrayList<>();
            String str = strs[i];
            visited.add(i);
            strings.add(str);
            int[] ints1 = map.get(i);
            tag:
            for (int j = i + 1; j < strs.length; j++) {
                String str1 = strs[j];
                if (visited.contains(j) || str.length() != str1.length()) continue;
                int[] ints = map.get(j);
                for (int k = 0; k < 26; k++) {
                    if (ints[k] != ints1[k]) {
                        continue tag;
                    }
                }

                strings.add(str1);
                visited.add(j);
            }

            r.add(strings);
        }

        return r;
    }

    public static void main(String[] args) {
        new groupAnagrams_49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

}
