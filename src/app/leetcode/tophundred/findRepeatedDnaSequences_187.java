package app.leetcode.tophundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class findRepeatedDnaSequences_187 {

    /**
     * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
     *
     * 例如，"ACGAATTCCG" 是一个 DNA序列 。
     * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
     *
     * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * 输出：["AAAAACCCCC","CCCCCAAAAA"]
     * 示例 2：
     *
     * 输入：s = "AAAAAAAAAAAAA"
     * 输出：["AAAAAAAAAA"]
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int start = 0;
        int end = start + 10;
        Map<String, Integer> map = new HashMap<>();
        while (end <= s.length()) {
            String substring = s.substring(start, end);
            map.merge(substring, 1, Integer::sum);
            start++;
            end++;
        }

        return map.entrySet().stream().filter(e -> e.getValue() >= 2).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
