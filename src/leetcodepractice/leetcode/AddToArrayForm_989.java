package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class AddToArrayForm_989 {

    /**
     * 整数的 数组形式  num 是按照从左到右的顺序表示其数字的数组。
     * 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
     * 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
     * <p>
     * 示例 1：
     * 输入：num = [1,2,0,0], k = 34
     * 输出：[1,2,3,4]
     * 解释：1200 + 34 = 1234
     * <p>
     * 示例 2：
     * 输入：num = [2,7,4], k = 181
     * 输出：[4,5,5]
     * 解释：274 + 181 = 455
     * <p>
     * 示例 3：
     * 输入：num = [2,1,5], k = 806
     * 输出：[1,0,2,1]
     * 解释：215 + 806 = 1021
     *
     * @param num
     * @param k
     * @return
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = k;
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int tn = n % 10;
            num[i] = num[i] + tn + carry;
            carry = num[i] / 10;
            num[i] %= 10;
            n /= 10;
        }

        List<Integer> r = new ArrayList<>();
        if (n != 0 || carry != 0) {
            int e = n + carry;
            while (e > 0) {
                int i = e % 10;
                r.add(0, i);
                e /= 10;
            }

        }
        for (int i : num) {
            r.add(i);
        }


        return r;
    }
}
