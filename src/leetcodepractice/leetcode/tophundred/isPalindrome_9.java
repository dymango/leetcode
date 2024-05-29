package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class isPalindrome_9 {

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     * <p>
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     * <p>
     * <p>
     * 提示：
     * <p>
     * -231 <= x <= 231 - 1
     * <p>
     * <p>
     * 进阶：你能不将整数转为字符串来解决这个问题吗？
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    public boolean isPalindromeV2(int x) {
        if (x < 0) return false;
        int num = 0;
        int origin = x;
        while (x > 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return num == origin;
    }

    public static void main(String[] args) {
        new isPalindrome_9().isPalindromeV2(121);
    }
}
