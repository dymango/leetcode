package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class BitwiseComplement_1009 {
    /**
     * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
     *
     * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
     *
     * 给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：5
     * 输出：2
     * 解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
     * 示例 2：
     *
     * 输入：7
     * 输出：0
     * 解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。
     * 示例 3：
     *
     * 输入：10
     * 输出：5
     * 解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
     *
     * @param n
     * @return
     */
    public int bitwiseComplement(int n) {
        String binaryString = Integer.toBinaryString(n);
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if(c == '1') newStr.append("0");
            else if(c == '0') newStr.append("1");
        }

        return Integer.parseInt(newStr.toString(), 2);
    }
}
