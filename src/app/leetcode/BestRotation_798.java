package app.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class BestRotation_798 {

    /**
     * 给定一个数组 A，我们可以将它按一个非负整数 K 进行轮调，这样可以使数组变为 A[K], A[K+1], A{K+2], ... A[A.length - 1], A[0], A[1], ..., A[K-1] 的形式。
     * 此后，任何值小于或等于其索引的项都可以记作一分。
     * <p>
     * 例如，如果数组为 [2, 4, 1, 3, 0]，我们按 K = 2 进行轮调后，它将变成 [1, 3, 0, 2, 4]。这将记作 3 分，
     * 因为 1 > 0 [no points], 3 > 1 [no points], 0 <= 2 [one point], 2 <= 3 [one point], 4 <= 4 [one point]。
     * <p>
     * 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调索引 K。如果有多个答案，返回满足条件的最小的索引 K。
     *
     * @param nums
     * @return
     */
    public int bestRotation(int[] nums) {
        int l = nums.length;
        int[] value = new int[l];
        int max = Integer.MIN_VALUE;
        int r = 0;
        for (int i = 0; i < l; i++) {
            value[i] = nums[i] - i;
        }

        for (int i = 0; i < l; i++) {
            int c = 0;
            int[] temp = Arrays.copyOf(value, l);
            for (int j = i; j < l; j++) {
                temp[j] += i;
                if (temp[j] <= 0) c++;
            }

            for (int j = 0; j < i; j++) {
                temp[j] -= (l - i);
                if (temp[j] <= 0) c++;
            }

            if (c > max) {
                max = c;
                r = i;
            }
        }

        return r;
    }

}
