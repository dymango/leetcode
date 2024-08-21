package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class lengthOfLongestSubstring3 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
     * 子串
     * 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        boolean[] visited = new boolean[130];
        int start = 0;
        int end = start;
        int max = Integer.MIN_VALUE;
        while (end < s.length()) {
            var ec = s.charAt(end);
            var sc = s.charAt(start);
            if (visited[ec]) {
                visited[sc] = false;
                start++;
            } else {
                visited[ec] = true;
                max = Math.max(max, end - start + 1);
                end++;
            }
        }

        return max;
    }
}
