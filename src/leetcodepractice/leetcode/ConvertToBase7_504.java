package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class ConvertToBase7_504 {

    /**
     * 给定一个整数，将其转化为7进制，并以字符串形式输出。
     *
     * 示例 1:
     *
     * 输入: 100
     * 输出: "202"
     * 示例 2:
     *
     * 输入: -7
     * 输出: "-10"
     * 注意: 输入范围是 [-1e7, 1e7] 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/base-7
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public static String convertToBase7(int num) {
        String s = "";
        boolean flag = false;
        if (num < 0)
        {
            num = 0 - num;
            flag = true;
        }
        while (num / 7 != 0)
        {

            s = num % 7 + s;
            num /= 7;
        }
        s = num + s;
        if (flag)
            s = '-' + s;
        return s;
    }

    public static void main(String[] args) {
        convertToBase7(100);
    }
}
