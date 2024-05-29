package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class PlusOne_66 {

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     * 示例 2：
     * <p>
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     * 示例 3：
     * <p>
     * 输入：digits = [0]
     * 输出：[1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= digits.length <= 100
     * 0 <= digits[i] <= 9
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int v = 1;
        int length = digits.length;
        int[] newDigits = new int[length + 1];
        for (int i = 0; i < newDigits.length - 1; i++) {
            newDigits[i] = digits[length - 1 - i] + v;
            if (newDigits[i] >= 10) {
                newDigits[i] = 0;
                v = 1;
            } else {
                v = 0;
            }
        }

        if (v == 1) newDigits[newDigits.length - 1] = 1;
        int size = v == 1 ? newDigits.length : length;
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = newDigits[size -  1 -i];
        }
        return result;
    }
}
