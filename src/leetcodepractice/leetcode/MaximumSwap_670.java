package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MaximumSwap_670 {

    /**
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *
     * 示例 1 :
     *
     * 输入: 2736
     * 输出: 7236
     * 解释: 交换数字2和数字7。
     * 示例 2 :
     *
     * 输入: 9973
     * 输出: 9973
     * 解释: 不需要交换。
     * 注意:
     *
     * 给定数字的范围是 [0, 108]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-swap
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int lastIndex = i;
            int max = chars[i];
            boolean find = false;
            for (int j = chars.length - 1; j > i; j--) {
                if(chars[j] > max) {
                    max = chars[j];
                    lastIndex = j;
                    find = true;
                }
            }

            if(find) {
                int temp = chars[i];
                chars[i] = (char)max;
                chars[lastIndex] = (char)temp;
                return Integer.valueOf(String.valueOf(chars));
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(9973));
    }
}
