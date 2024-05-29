package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class SuperpalindromesInRange_906 {
    public static void main(String[] args) {
        SuperpalindromesInRange_906 superpalindromesInRange_906 = new SuperpalindromesInRange_906();
//        int i = superpalindromesInRange_906.superpalindromesInRange("4", "1000");
        int i = superpalindromesInRange_906.superpalindromesInRange("40000000000000000",
            "50000000000000000");
        System.out.println(i);
    }

    /**
     * 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
     * 现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
     * <p>
     * 示例：
     * 输入：L = "4", R = "1000"
     * 输出：4
     * 解释：
     * 4，9，121，以及 484 是超级回文数。
     * <p>
     * 注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。
     * 提示：
     * <p>
     * 1 <= len(L) <= 18
     * 1 <= len(R) <= 18
     * L 和 R 是表示 [1, 10^18) 范围的整数的字符串。
     * int(L) <= int(R)
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/super-palindromes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param left
     * @param right
     * @return
     */

    int superpalindromesInRange(String left, String right) {
        int res = 0;
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);

        // 先判断偶数的情况 ABCCBA
        for (int i = 1; i < 100000; ++i) {
            String s = String.valueOf(i);
            String s2 = new StringBuilder(s).reverse().toString();
            long m = Long.parseLong(s + s2);
            m *= m;
            // 超过范围提前结束遍历
            if (m > r) {
                break;
            } else if (m >= l && check(m)) {
                ++res;
            }
        }

        // 再判断奇数的情况 ABCBA
        for (int i = 1; i < 100000; ++i) {
            String s = String.valueOf(i);
            String s2 = new StringBuilder(s).reverse().substring(1);
            long m = Long.parseLong(s + s2);
            m *= m;
            // 超过范围提前结束遍历
            if (m > r) {
                break;
            } else if (m >= l && check(m)) {
                ++res;
            }
        }

        return res;
    }


    private boolean check(long n) {
        String str = String.valueOf(n);
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            char sc = str.charAt(start);
            char ec = str.charAt(end);
            if (sc != ec) return false;
            start++;
            end--;
        }

        return true;
    }
}
