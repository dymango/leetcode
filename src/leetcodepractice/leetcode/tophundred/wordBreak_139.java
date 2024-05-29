package leetcodepractice.leetcode.tophundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class wordBreak_139 {

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     * <p>
     * 示例 1：
     * <p>
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     * 示例 2：
     * <p>
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     * 注意，你可以重复使用字典中的单词。
     * 示例 3：
     * <p>
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 300
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 20
     * s 和 wordDict[i] 仅由小写英文字母组成
     * wordDict 中的所有字符串 互不相同
     *
     * @param s
     * @param wordDict
     * @return
     */
    Map<String, Boolean> cache = new HashMap<>();
    Set<String> dic;

    public boolean wordBreak(String s, List<String> wordDict) {
        dic = new HashSet<>(wordDict);
        return match(s);
    }

    private boolean match(String str) {
        if(str.isEmpty()) return true;
        if (cache.containsKey(str)) return cache.get(str);
        boolean result = false;
        for (int i = 0; i < str.length(); i++) {
            String substring = str.substring(0, i + 1);
            if (!dic.contains(substring)) continue;
            boolean match = match(str.substring(i + 1));
            if (match) {
                result = true;
                break;
            }
        }

        cache.put(str, result);
        return result;
    }
}
