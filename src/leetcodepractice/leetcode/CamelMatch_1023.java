package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class CamelMatch_1023 {
    /**
     * 给你一个字符串数组 queries，和一个表示模式的字符串 pattern，请你返回一个布尔数组 answer 。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
     * <p>
     * 如果可以将小写字母插入模式串 pattern 得到待查询项 queries[i]，那么待查询项与给定模式串匹配。可以在任何位置插入每个字符，也可以不插入字符。
     * <p>
     * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
     * 输出：[true,false,true,true,false]
     * 示例：
     * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
     * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
     * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
     *
     * @param queries
     * @param pattern
     * @return ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
     * pattern =
     * "FoBa"
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> r = new ArrayList<>();
        for (String query : queries) {
            var charArray = query.toCharArray();
            int patindex = 0;
            boolean match = true;
            for (char c : charArray) {
                if (c >= 'A' && c <= 'Z') {
                    if (patindex < pattern.length() && c == pattern.charAt(patindex)) {
                        patindex++;
                    } else {
                        match = false;
                        break;
                    }
                } else {
                    if (patindex < pattern.length() && c == pattern.charAt(patindex)) {
                        patindex++;
                    }
                }
            }

            if (match && patindex == pattern.length()){
                r.add(true);
            } else {
                r.add(false);
            }
        }
        return r;
    }
}
