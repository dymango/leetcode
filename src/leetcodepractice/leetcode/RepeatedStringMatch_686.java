package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class RepeatedStringMatch_686 {

    /**
     * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
     * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：a = "abcd", b = "cdabcdab"
     * 输出：3
     * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
     * 示例 2：
     *
     * 输入：a = "a", b = "aa"
     * 输出：2
     * 示例 3：
     *
     * 输入：a = "a", b = "a"
     * 输出：1
     * 示例 4：
     *
     * 输入：a = "abc", b = "wxyz"
     * 输出：-1
     *  
     * abc bac
     *
     * "abc"
     * "cabcabca"
     *
     * 提示：
     *
     * 1 <= a.length <= 104
     * 1 <= b.length <= 104
     * a 和 b 由小写英文字母组成
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/repeated-string-match
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param a
     * @param b
     * @return
     */
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)) return 1;
        for (int i = 0; i < b.length(); i++) {
            if(!a.contains(String.valueOf(b.charAt(i)))) return -1;
        }

        String as = "";
        int count = 0;
        while(as.length() <= b.length() * 50) {
            as += a;
            count++;
            if(as.contains(b)) return count;
        }

        if(as.contains(b)) return count;
        else return -1;
    }
}
