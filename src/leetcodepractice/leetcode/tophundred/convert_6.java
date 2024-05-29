package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class convert_6 {

    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * <p>
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     * <p>
     * 输入：s = "A", numRows = 1
     * 输出："A"
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder stringBuilder = new StringBuilder(16);
        for (int i = 0; i < numRows; i++) {
            int index = i;
            int direction = 0;
            while (index < s.length()) {
                stringBuilder.append(s.charAt(index));
                if (i == 0 || i == numRows - 1) {
                    index += numRows - 1 + numRows - 2 + 1;
                } else {
                    if (direction == 0) {
                        index += numRows - i - 1 + numRows - i - 1;
                        direction = 1;
                    } else {
                        index += i + i - 1 + 1;
                        direction = 0;
                    }
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new convert_6().convert("AB", 1));
    }
}
