package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class myAtoi8 {

    /**
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
     * <p>
     * 函数 myAtoi(string s) 的算法如下：
     * <p>
     * 空格：读入字符串并丢弃无用的前导空格（" "）
     * 符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
     * 转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
     * 舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
     * 返回整数作为最终结果。
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        s = s.trim();
        var charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            var c = charArray[i];
            if (c != '-' && c != '+' && (c < '0' || c > '9')) return 0;
            if ((c == '-' || c == '+') && i > 0 && (charArray[i - 1] == '-' || charArray[i - 1] == '+')) return 0;
            if (c >= '0' && c <= '9') {
                long result = 0;
                int tag = 0;
                if (i - 1 < 0 || s.charAt(i - 1) == '+') tag = 2;
                else if (s.charAt(i - 1) == '-') tag = 1;
                int start = i;
                while (start < s.length()) {
                    if (charArray[start] >= '0' && charArray[start] <= '9') {
                        long newR = result * 10 + (charArray[start] - 48);
                        long temp = tag == 1 ? -newR : newR;
                        if (temp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                        if (temp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                        result = newR;
                    } else {
                        break;
                    }

                    start++;
                }

                return (int) (tag == 1 ? -result : result);
            }
        }

        return 0;
    }
}
