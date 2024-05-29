package leetcodepractice.jianzhioffer;

/**
 * @author dimmy
 */
public class FirstUniqChar_50 {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * <p>
     * 示例 1:
     * <p>
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * 示例 2:
     * <p>
     * 输入：s = ""
     * 输出：' '
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= s 的长度 <= 50000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        int[] visited = new int[256];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            visited[chars[i]]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if(visited[chars[i]] == 1)return chars[i];
        }

        return ' ';
    }
}
