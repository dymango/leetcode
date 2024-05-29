package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class WordBreak_140 {

    /**
     * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
     * 注意：词典中的同一个单词可能在分段中被重复使用多次。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     * 输出:["cats and dog","cat sand dog"]
     * 示例 2：
     * <p>
     * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
     * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
     * 解释: 注意你可以重复使用字典中的单词。
     * 示例 3：
     * <p>
     * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * 输出:[]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 20
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 10
     * s 和 wordDict[i] 仅有小写英文字母组成
     * wordDict 中所有字符串都 不同
     *
     * @param s
     * @param wordDict
     * @return
     */
    Set<String> strSet = new HashSet<>();
    Map<Integer, List<String>> cache = new HashMap<>();

    public static void main(String[] args) {
        new WordBreak_140().wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        strSet = new HashSet<>(wordDict);
        return generate(s, 0);
    }

    private List<String> generate(String str, int start) {
        if (cache.containsKey(start)) return cache.get(start);
        if (start >= str.length()) return List.of("");
        List<String> result = new ArrayList<>();
        for (int i = start + 1; i <= str.length(); i++) {
            String substring = str.substring(start, i);
            if (strSet.contains(substring)) {
                List<String> generate = generate(str, i);
                generate.forEach(s -> {
                    if (!s.isEmpty()) {
                        result.add(substring + " " + s);
                    } else {
                        result.add(substring);
                    }
                });
            }
        }

        cache.put(start, result);
        return result;
    }
}
