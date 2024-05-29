package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class ReverseOnlyLetters_917 {

    /**
     * 给你一个字符串 s ，根据下述规则反转字符串：
     * 所有非英文字母保留在原有位置。
     * 所有英文字母（小写或大写）位置反转。
     * 返回反转后的 s 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ab-cd"
     * 输出："dc-ba"
     * 示例 2：
     * <p>
     * 输入：s = "a-bC-dEf-ghIj"
     * 输出："j-Ih-gfE-dCba"
     * 示例 3：
     * <p>
     * 输入：s = "Test1ng-Leet=code-Q!"
     * 输出："Qedo1ct-eeLg=ntse-T!"
     *  
     * <p>
     * 提示
     * <p>
     * 1 <= s.length <= 100
     * s 仅由 ASCII 值在范围 [33, 122] 的字符组成
     * s 不含 '\"' 或 '\\'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-only-letters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    //"a-bC-dEf-ghIj"
    //输出：
    //"jIhg-fEd-Cb-a"
    //预期结果：
    //"j-Ih-gfE-dCba"
    public String reverseOnlyLetters(String s) {
        int start = 0;
        int length = s.length();
        int end = length - 1;
        char[] originChars = s.toCharArray();
        char[] targetChars = s.toCharArray();
        while (true) {
            while (end >= 0) {
                if (isAvailableChar(targetChars[end])) break;
                end--;
            }

            while (start < length) {
                if (isAvailableChar(originChars[start])) break;
                start++;
            }

            if (start >= length || end < 0) return String.valueOf(targetChars);
            targetChars[end] = originChars[start];
            start++;
            end--;
        }
    }

    private boolean isAvailableChar(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}
