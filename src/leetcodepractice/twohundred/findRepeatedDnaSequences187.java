package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class findRepeatedDnaSequences187 {

    /**
     * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
     * <p>
     * 例如，"ACGAATTCCG" 是一个 DNA序列 。
     * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
     * <p>
     * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> r = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            var substring = s.substring(i, i + 10);
            if (!set.add(substring)) {
                r.add(substring);
            }
        }

        return new ArrayList<>(r);
    }

}
