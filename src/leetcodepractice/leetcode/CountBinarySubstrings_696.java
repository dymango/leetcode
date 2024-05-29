package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class CountBinarySubstrings_696 {

    /**
     * 给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
     *
     * 重复出现的子串要计算它们出现的次数。
     *
     *  
     *
     * 示例 1 :
     *
     * 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     *
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     *
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     * 示例 2 :
     *
     * 输入: "10101"
     * 输出: 4
     * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
     *  
     *
     * 提示：
     *
     * s.length 在1到50,000之间。
     * s 只包含“0”或“1”字符。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-binary-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static int countBinarySubstrings(String s) {
        int[] sameCharInLeft = new int[s.length()];
        sameCharInLeft[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) sameCharInLeft[i] = sameCharInLeft[i - 1] + 1;
            else sameCharInLeft[i] = 1;
        }

        int count = 0;
        for (int i = 2; i <= s.length(); i+=2) {
            for (int j = 0; j < s.length() - i + 1; j++) {
                int left = j;
                char ls = s.charAt(left);
                int right = j + i - 1;
                char rs = s.charAt(right);
                if(ls == rs) continue;
                int halfWindow = i/2;
                int leftEnd = left + halfWindow - 1;
                if(sameCharInLeft[leftEnd] >= halfWindow && sameCharInLeft[right] == halfWindow) count++;

            }
        }

        return count;
    }

    public static int countBinarySubstringsV2(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int left = i;
            int right = i + 1;
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if(s.charAt(left) == s.charAt(right)) continue;
            while (left >= 0 && right <s.length()) {
                if(s.charAt(left) == lc && s.charAt(right) == rc) {
                    count++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        countBinarySubstringsV2("00110011");
    }
}
