package app.leetcode;

/**
 * @author dimmy
 */
public class FindComplement_476 {

    /**
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 5
     * 输出: 2
     * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
     * 示例 2:
     *
     * 输入: 1
     * 输出: 0
     * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
     *  
     *
     * 注意:
     *
     * 给定的整数保证在 32 位带符号整数的范围内。
     * 你可以假定二进制数不包含前导零位。
     * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-complement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public static int findComplement(int num) {
//        String str = Integer.toBinaryString(num);
//        String newStr = "";
//        for (int i = 0; i < str.length(); i++) {
//            newStr += (str.charAt(i) == '0' ? "1" : "0");
//        }
//
//        return Integer.valueOf(newStr, 2);
        int maxBitNum = 0;
        int tmpNum = num;
        while (tmpNum > 0) {
            maxBitNum += 1;
            tmpNum >>= 1;
        }
        String str = Integer.toBinaryString(1 << maxBitNum);
        String str2 = Integer.toBinaryString((1 << maxBitNum) - 1);
        return num ^ ((1 << maxBitNum) - 1);

    }

    public static void main(String[] args) {
        System.out.println( findComplement(5));
    }

    /**
     * 二进制转十进制
     * @param number
     * @return
     */
    public static int binary2Decimal(String number) {
        return scale2Decimal(number, 2);
    }

    /**
     * 其他进制转十进制
     * @param number
     * @return
     */
    public static int scale2Decimal(String number, int scale) {
        checkNumber(number);
        if (2 > scale || scale > 32) {
            throw new IllegalArgumentException("scale is not in range");
        }
        // 不同其他进制转十进制,修改这里即可
        int total = 0;
        String[] ch = number.split("");
        int chLength = ch.length;
        for (int i = 0; i < chLength; i++) {
            total += Integer.valueOf(ch[i]) * Math.pow(scale, chLength - 1 - i);
        }
        return total;

    }

    /**
     * 二进制转十进制
     * @param number
     * @return
     */
    public static String decimal2Binary(int number) {
        return decimal2Scale(number, 2);
    }

    /**
     * 十进制转其他进制
     * @param number
     * @param scale
     * @return
     */
    public static String decimal2Scale(int number, int scale) {
        if (2 > scale || scale > 32) {
            throw new IllegalArgumentException("scale is not in range");
        }
        String result = "";
        while (0 != number) {
            result = number % scale + result;
            number = number / scale;
        }

        return result;
    }

    public static void checkNumber(String number) {
        String regexp = "^\\d+$";
        if (null == number || !number.matches(regexp)) {
            throw new IllegalArgumentException("input is not a number");
        }
    }
}
