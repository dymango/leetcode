package app.leetcode;

/**
 * @author dimmy
 */
public class IsOneBitCharacter_717 {

    /**
     * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
     *
     * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
     *
     * 示例 1:
     *
     * 输入:
     * bits = [1, 0, 0]
     * 输出: True
     * 解释:
     * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
     * 示例 2:
     *
     * 输入:
     * bits = [1, 1, 1, 0]
     * 输出: False
     * 解释:
     * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
     * 注意:
     *
     * 1 <= len(bits) <= 1000.
     * bits[i] 总是0 或 1.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 我们可以对 \mathrm{bits}bits 数组从左到右扫描来判断最后一位是否为一比特字符。当扫描到第 ii 位时，如果 \mathrm{bits}[i]=1bits[i]=1，那么说明这是一个两比特字符，将 ii 的值增加 2。如果 \mathrm{bits}[i]=0bits[i]=0，那么说明这是一个一比特字符，将 ii 的值增加 1。
     *
     * 如果 ii 最终落在了 \mathrm{bits}.\mathrm{length}-1bits.length−1 的位置，那么说明最后一位一定是一比特字符。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/solution/1bi-te-yu-2bi-te-zi-fu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        return false;
    }
}
