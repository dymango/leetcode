package leetcodepractice.leetcode.tophundred;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class longestCommonPrefix_14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int targetLength = Integer.MAX_VALUE;
        for (String str : strs) {
            targetLength = Math.min(targetLength, str.length());
        }

        int start = 1;
        int end = targetLength;
        int last = 0;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            String str = strs[0].substring(0, middle);
            boolean allMatch = Arrays.stream(strs).allMatch(s -> s.substring(0, middle).equals(str));
            if (allMatch) {
                last = middle;
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        if (last == 0) return "";
        return strs[0].substring(0, last);
    }

    public static void main(String[] args) {
        System.out.println(new longestCommonPrefix_14().longestCommonPrefix(new String[]{"flower", "flower", "flower", "flower"}));
    }
}
