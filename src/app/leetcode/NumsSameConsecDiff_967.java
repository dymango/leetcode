package app.leetcode;

import app.executor.MainMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class NumsSameConsecDiff_967 {

    /**
     * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
     * <p>
     * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。
     * <p>
     * 你可以按 任何顺序 返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3, k = 7
     * 输出：[181,292,707,818,929]
     * 解释：注意，070 不是一个有效的数字，因为它有前导零。
     * 示例 2：
     * <p>
     * 输入：n = 2, k = 1
     * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
     * 示例 3：
     * <p>
     * 输入：n = 2, k = 0
     * 输出：[11,22,33,44,55,66,77,88,99]
     * 示例 4：
     * <p>
     * 输入：n = 2, k = 2
     * 输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
     *
     * @param n
     * @param k
     * @return
     */
    @MainMethod
    public int[] numsSameConsecDiff(int n, int k) {
        List<String> r = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            List<String> generate = generate(1, n, k, i);
            if (generate.isEmpty()) continue;
            String str = String.valueOf(i);
            for (String s : generate) {
                r.add(str + s);
            }
        }

        int[] result = new int[r.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(r.get(i));
        }

        return result;
    }

    private List<String> generate(int index, int n, int k, int pre) {
        if (index >= n) return new ArrayList<>();
        List<String> r = new ArrayList<>();
        int i1 = pre + k;
        if (i1 >= 0 && i1 <= 9) {
            List<String> generate = generate(index + 1, n, k, i1);
            String str = String.valueOf(i1);
            if (generate.isEmpty()) {
                r.add(str);
            } else {
                for (String s : generate) {
                    r.add(str + s);
                }
            }
        }

        int i2 = pre - k;
        if(i2 == i1) return r;
        if (i2 >= 0 && i2 <= 9) {
            List<String> generate = generate(index + 1, n, k, i2);

            String str = String.valueOf(i2);
            if (generate.isEmpty()) {
                r.add(str);
            } else {
                for (String s : generate) {
                    r.add(str + s);
                }
            }

        }

        return r;
    }
}
