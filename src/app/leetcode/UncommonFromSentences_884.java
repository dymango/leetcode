package app.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author dimmy
 */
public class UncommonFromSentences_884 {
    /**
     * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
     * <p>
     * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
     * <p>
     * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
     * 输出：["sweet","sour"]
     * 示例 2：
     * <p>
     * 输入：s1 = "apple apple", s2 = "banana"
     * 输出：["banana"]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s1.length, s2.length <= 200
     * s1 和 s2 由小写英文字母和空格组成
     * s1 和 s2 都不含前导或尾随空格
     * s1 和 s2 中的所有单词间均由单个空格分隔
     *
     * @param s1
     * @param s2
     * @return
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.merge(s, 1, Integer::sum);
        }

        for (String s : s2.split(" ")) {
            map.merge(s, 1, Integer::sum);
        }

        List<String> r = new ArrayList<>();
        map.forEach((s, integer) -> {
            if (integer == 1) r.add(s);
        });

        return r.toArray(new String[0]);
    }
}
