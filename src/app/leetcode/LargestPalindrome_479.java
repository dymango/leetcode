package app.leetcode;

import java.util.PriorityQueue;

/**
 * @author dimmy
 */
public class LargestPalindrome_479 {
    /**
     * 你需要找到由两个 n 位数的乘积组成的最大回文数。
     *
     * 由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。
     *
     * 示例:
     *
     * 输入: 2
     *
     * 输出: 987
     *
     * 解释: 99 x 91 = 9009, 9009 % 1337 = 987
     *
     * 说明:
     *
     * n 的取值范围为 [1,8]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-palindrome-product
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static int largestPalindrome(int n) {
        String ss = "1";
        for (int i = 1; i < n; i++) {
            ss += "0";
        }

        int start = Integer.parseInt(ss);
        String es = "";
        for (int i = 0; i < n; i++) {
            es += "9";
        }

        int max = Integer.MIN_VALUE;
        int end = Integer.parseInt(es);
        for (int i = end; i >= start; i--) {
            for (int j = end; j >= start; j--) {
                int product;
                if((product = i*j) > max && isPalindromicNumber(product)) {
                    max = Math.max(max, i*j);
                }
            }
        }


        return max%1337;
    }

    public static boolean isPalindromicNumber(int number) {
        String str = String.valueOf(number);
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println( largestPalindrome2(8));

    }

    public static int largestPalindrome2(int n) {
        if(n == 1) return 9;
        long max = (long)Math.pow(10,n) - 1;
        for(long i = max - 1; i > max / 10; i--){
            String s1 = String.valueOf(i);
            long rev = Long.parseLong(s1 + new StringBuilder(s1).reverse().toString());
            for(long x = max; x * x >= rev; x --){
                if(rev % x == 0) return (int)(rev % 1337);
            }
        }

        return -1;
    }
}
