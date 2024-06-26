package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class CountSegments_434 {

    /**
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     *
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     *
     * 示例:
     * @param s
     * @return
     */
    public int countSegments(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        return s.split("\\s+").length;
    }
}
