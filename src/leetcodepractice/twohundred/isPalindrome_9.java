package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class isPalindrome_9 {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * <p>
     * 回文数
     * 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 例如，121 是回文，而 123 不是。
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int num = 0;
        int temp = x;
        while (temp > 0) {
            var i = temp % 10;
            num = num * 10 + i;
            temp /= 10;
        }

        return num == x;
    }
}
