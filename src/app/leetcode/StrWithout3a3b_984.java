package app.leetcode;

import app.executor.MainMethod;

/**
 * @author dimmy
 */
public class StrWithout3a3b_984 {

    /**
     * 给定两个整数 a 和 b ，返回 任意 字符串 s ，要求满足：
     * <p>
     * s 的长度为 a + b，且正好包含 a 个 'a' 字母与 b 个 'b' 字母；
     * 子串 'aaa' 没有出现在 s 中；
     * 子串 'bbb' 没有出现在 s 中。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：a = 1, b = 2
     * 输出："abb"
     * 解释："abb", "bab" 和 "bba" 都是正确答案。
     * 示例 2：
     * <p>
     * 输入：a = 4, b = 1
     * 输出："aabaa"
     *
     * @param a
     * @param b
     * @return 1/2;
     * <1：3
     * <p>
     * 我们定义 A, B：待写的 'a' 与 'b' 的数量。
     * <p>
     * 设当前还需要写入字符串的 'a' 与 'b' 中较多的那一个为 x，如果我们已经连续写了两个 x 了，下一次我们应该写另一个字母。否则，我们应该继续写 x。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode.cn/problems/string-without-aaa-or-bbb/solutions/3598/bu-han-aaa-huo-bbb-de-zi-fu-chuan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    @MainMethod
    public String strWithout3a3b(int a, int b) {
        int remainA = a;
        int remainB = b;
        boolean fillA = a >= b;
        StringBuilder result = new StringBuilder();
        while (remainA + remainB > 0) {
            if (fillA) {
                boolean serial = !result.isEmpty() && result.charAt(result.length() - 1) == 'a';
                result.append('a');
                remainA -= 1;
                if(serial) fillA = false;
                else {
                    fillA = remainA >= remainB;
                }
            } else {
                boolean serial = !result.isEmpty() && result.charAt(result.length() - 1) == 'b';
                result.append('b');
                remainB -= 1;
                if(serial) fillA = true;
                else {
                    fillA = remainA >= remainB;
                }
            }
        }

        return result.toString();
    }
}
