package leetcodepractice.twohundred;

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
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true
     * <p>
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     *
     * @param s
     * @param wordDict
     * @return
     */

    Set<String> set;
    Map<String, Boolean> cache = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return match(s);
    }

    boolean match(String s) {
        if(s.isEmpty()) return true;
        if (cache.containsKey(s)) return cache.get(s);
        for (int i = 0; i < s.length(); i++) {
            var substring = s.substring(0, i + 1);
            if (!set.contains(substring)) continue;
            var match = match(s.substring(i + 1));
            if (match) {
                cache.put(s, true);
                return true;
            }
        }

        cache.put(s, false);
        return false;
    }
}
