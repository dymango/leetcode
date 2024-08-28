package leetcodepractice.twohundred;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class reverseWords151 {

    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * <p>
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * <p>
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * <p>
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        var split = s.trim().split(" ");
        var collect = Arrays.stream(split).filter(s1 -> !s1.trim().isEmpty()).collect(Collectors.toList());
        Collections.reverse(collect);
        return String.join(" ", collect);
    }
}
