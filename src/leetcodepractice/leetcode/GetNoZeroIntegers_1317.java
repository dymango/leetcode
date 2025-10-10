package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class GetNoZeroIntegers_1317 {

    /**
     * 「无零整数」是十进制表示中 不含任何 0 的正整数。
     * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [a, b]，满足：
     * a 和 b 都是无零整数
     * a + b = n
     *
     * 题目数据保证至少有一个有效的解决方案。
     * 如果存在多个有效解决方案，你可以返回其中任意一个。
     *
     * @param n
     * @return
     */
    public int[] getNoZeroIntegers(int n) {

        for (int i = 1; i < n; i++) {
            var left = n - i;
            var c = String.valueOf(i).contains("0");
            var c2 = String.valueOf(left).contains("0");
            if(!c&&!c2) return new int[]{i, left};
        }

        return null;
    }

}
