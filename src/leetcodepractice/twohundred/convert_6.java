package leetcodepractice.twohundred;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

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
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 PAHNAYPALISHIRINGYIR
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * string convert(string s, int numRows);
     *
     * @param s
     * @param numRows
     * @return
     */
    @MainParam
    String s = "a";
    //PINALSIGYAHRPI
    @MainParam
    int r = 1;

    @MainMethod
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            if (i == 0 || i == numRows - 1) {
                while (index < s.length()) {
                    stringBuilder.append(s.charAt(index));
                    index += (((numRows - 1) * 2 - 1) + 1);
                }
            } else {
                int direct = 0;
                while (index < s.length()) {
                    stringBuilder.append(s.charAt(index));
                    if (direct == 0) {
                        index += ((numRows - (i + 1)) * 2);
                        direct = 1;
                    } else {
                        index += i + i ;
                        direct = 0;
                    }
                }
            }
        }

        return stringBuilder.toString();
    }
}
