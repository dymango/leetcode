package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class longestCommonPrefix14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
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
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        int count = 0;
        while (index < strs[0].length()) {
            var c = strs[0].charAt(index);
            for (String str : strs) {
                if (index == str.length()) {
                    break;
                }
                if (str.charAt(index) == c) count++;
            }

            if (count != strs.length) return strs[0].substring(0, index);
            index++;
            count = 0;
        }

        return strs[0];
    }
}
