package app.leetcode;

/**
 * @author dimmy
 */
public class KthSmallestPrimeFraction_786 {

    /**
     * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
     * <p>
     * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
     * <p>
     * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：arr = [1,2,3,5], k = 3
     * 输出：[2,5]
     * 解释：已构造好的分数,排序后如下所示:
     * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
     * 很明显第三个最小的分数是 2/5
     * 示例 2：
     * <p>
     * 输入：arr = [1,7], k = 1
     * 输出：[1,7]
     *  
     * <p>
     * 提示：
     * <p>
     * 2 <= arr.length <= 1000
     * 1 <= arr[i] <= 3 * 104
     * arr[0] == 1
     * arr[i] 是一个 素数 ，i > 0
     * arr 中的所有数字 互不相同 ，且按 严格递增 排序
     * 1 <= k <= arr.length * (arr.length - 1) / 2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] kthSmallestPrimeFraction(int[] primes, int K) {
        double lo = 0, hi = 1;
        int[] ans = new int[]{0, 1};

        while (hi - lo > 1e-9) {
            double mi = lo + (hi - lo) / 2.0;
            int[] res = under(mi, primes);
            if (res[0] < K) {
                lo = mi;
            } else {
                ans[0] = res[1];
                ans[1] = res[2];
                hi = mi;
            }
        }
        return ans;
    }

    public int[] under(double x, int[] primes) {
        // Returns {count, numerator, denominator}
        int numer = 0, denom = 1, count = 0, i = -1;
        for (int j = 1; j < primes.length; ++j) {
            // For each j, find the largest i so that primes[i] / primes[j] < x
            // It has to be at least as big as the previous i, so reuse it ("two pointer")
            while (primes[i + 1] < primes[j] * x) ++i;

            // There are i+1 fractions: (primes[0], primes[j]),
            // (primes[1], primes[j]), ..., (primes[i], primes[j])
            count += i + 1;
            if (i >= 0 && numer * primes[j] < denom * primes[i]) {
                numer = primes[i];
                denom = primes[j];
            }
        }
        return new int[]{count, numer, denom};
    }

    public int[] kthSmallestPrimeFractionV2(int[] A, int K) {
        // 因为分数是在(0,1)范围内，所以在此范围使用二分查找
        double lo = 0, hi = 1, mid;
        int p = 0, q = 1;
        int i, j;
        int count;
        // 因为是在小数内使用二分查找，无法像在整数范围内那样通过 mid+1和边界判断来终止循环
        // 所以此处根据count来结束循环
        while (true) {
            mid = (lo + hi) / 2;
            count = 0;
            p = 0;
            for (i = 0; i < A.length; i++) {
                j = 0;
                while (j < A.length - 1 - i && mid >= (double) A[i] / A[A.length - 1 - j]) {
                    j++;
                }
                count += j;
                // 重点：p/q是比 mid小的数中的最大值(所有行)
                if (j > 0 && ((double) p / q) < ((double) A[i] / A[A.length - j])) {
                    p = A[i];
                    q = A[A.length - j];
                }
            }
            if (count > K) hi = mid;
            else if (count < K) lo = mid;
            else return new int[]{p, q};
        }
    }
}
