package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class convertToTitle_168 {

    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     * <p>
     * 例如：
     * <p>
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * <p>
     * 示例 1：
     * <p>
     * 输入：columnNumber = 1
     * 输出："A"
     * 示例 2：
     * <p>
     * 输入：columnNumber = 28
     * 输出："AB"
     * 示例 3：
     * <p>
     * 输入：columnNumber = 701
     * 输出："ZY"
     * 示例 4：
     * <p>
     * 输入：columnNumber = 2147483647
     * 输出："FXSHRXW"
     *
     * @param columnNumber
     * @return
     */
    String[] charArr = new String[]{"Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
            return charArr[columnNumber];
        }

        int mod = columnNumber % 26;
        int n = (columnNumber - (mod == 0 ? 26 : mod)) / 26;
        return convertToTitle(n) + charArr[mod];
    }

}
