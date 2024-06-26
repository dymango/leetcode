package leetcodepractice.tencent;

/**
 * @author dimmy
 */
public class LongestCommonPrefix_14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *  
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
     * <p>
     * 提示：
     * <p>
     * 0 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        int max = Integer.MAX_VALUE;
        for (String str : strs) {
            max = Math.min(max, str.length());
        }
        while (index < max) {
            boolean stop = false;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != strs[i - 1].charAt(index)) {
                    stop = true;
                    break;
                }
            }

            if (stop) {
                return strs[0].substring(0, index);
            }

            index++;
        }

        return strs[0].substring(0, index);
    }
}
