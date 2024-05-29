package leetcodepractice.jianzhioffer;

/**
 * @author dimmy
 */
public class LengthOfLongestSubstring_48 {

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * <p>
     * <p>
     * 示例1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     * <p>
     * <p>
     * 提示：
     * <p>
     * s.length <= 40000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring_48().lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int[] visited = new int[256];
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        while (end < s.length()) {
            if (start == end) {
                visited[s.charAt(start)]++;
                max = Math.max(max, 1);
                end++;
                continue;
            }

            char current = s.charAt(end);
            if (visited[current] > 0) {
                while (start < end) {
                    visited[s.charAt(start)]--;
                    start++;
                    if (visited[current] == 0) break;
                }
            }

            visited[current]++;
            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;
    }
}
