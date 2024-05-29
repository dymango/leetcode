package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class titleToNumber_171 {

    /**
     * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
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
     *
     * "FXSHRXW"
     *
     * 添加到测试用例
     * 输出
     * 272
     * 预期结果
     * 2147483647
     * @param columnTitle
     * @return
     */
    String[] charArr = new String[]{"Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public int titleToNumber(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }


    public static void main(String[] args) {
        System.out.println('A' - 65);
    }
}
