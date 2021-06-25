package app.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class LargestSumOfAverages_1346 {

    /**
     * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
     * 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
     * <p>
     * 示例:
     * 输入:
     * A = [9,1,2,3,9]
     * K = 3
     * 输出: 20
     * 解释:
     * A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
     * 我们也可以把 A 分成[9, 1], [2], [3, 9].
     * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
     * 说明:
     * <p>
     * 1 <= A.length <= 100.
     * 1 <= A[i] <= 10000.
     * 1 <= K <= A.length.
     * 答案误差在 10^-6 内被视为是正确的。
     *
     * @param nums
     * @param k
     * @return
     */
    static int[] prefixSum;
    static int[] globalNumArr;
    static int K;
    static double max = Double.MIN_VALUE;
    static double[][] visited;
    static List<Map<Integer, Integer>> list;
    static Map<Integer, Double>[] cache;

    public static double largestSumOfAverages(int[] nums, int k) {
        cache = new Map[nums.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new HashMap<>();
        }
        K = k;
        globalNumArr = nums;
        prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = nums[i] + (i > 0 ? prefixSum[i - 1] : 0);
        }

        if (k == 1) {
            return (double) prefixSum[prefixSum.length - 1] / (double) prefixSum.length;
        }

        return memorySearch(0, nums.length - 1, k);
    }

    public static double largestSumOfAveragesV2(int[] nums, int k) {
        double[] pre = new double[nums.length];
        double[] current = new double[nums.length];
        prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = nums[i] + (i > 0 ? prefixSum[i - 1] : 0);
        }

        for (int i = 0; i < nums.length; i++) {
            pre[i] = prefixSum[i] / (double) (i + 1);
        }

        if(k == 1) return pre[pre.length - 1];

        for (int i = 2; i <= k; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int l = j - 1; l >= i - 2; l--) {
                    current[j] = Math.max(current[j], pre[l] + (double) (prefixSum[j] - prefixSum[l]) / (double) (j - l));
                }
            }

            pre = current;
            if (i < k) current = new double[nums.length];
        }

        return current[nums.length - 1];
    }

    private static void backtrace(List<Integer> node, int index) {
        if (index >= globalNumArr.length) return;
        if (node.size() == K - 1) {
            double sum = 0d;
            for (int i = 0; i < node.size(); i++) {
                int temp;
                Integer right = node.get(i);
                if (i == 0) {
                    temp = prefixSum[right];
                    sum += (double) temp / (double) (right + 1);
                } else {
                    Integer left = i > 0 ? node.get(i - 1) : 0;
                    temp = prefixSum[right] - (i > 0 ? prefixSum[left] : 0);
                    sum += (double) temp / (double) (right - left);
                }


                if (i == node.size() - 1) {
                    int last = prefixSum[prefixSum.length - 1] - prefixSum[right];
                    sum += (double) last / (double) (prefixSum.length - 1 - right);
                }
            }

            max = Math.max(max, sum);
            return;
        }

        for (int i = index; i < globalNumArr.length; i++) {
            node.add(i);
            backtrace(node, i + 1);
            node.remove(node.size() - 1);
        }
    }

    private static void backtraceV2(int nodeCount, int preIndex, int index, double sum) {
        if (index >= globalNumArr.length) return;
        if (nodeCount == K - 1) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = index; i < globalNumArr.length; i++) {
            int temp;
            double areaSum;
            if (preIndex == -1) {
                temp = prefixSum[i];
                areaSum = (double) temp / (double) (i + 1);
            } else {
                temp = prefixSum[i] - prefixSum[preIndex];
                areaSum = (double) temp / (double) (i - preIndex);
            }

            if (nodeCount == K - 2) {
                temp = prefixSum[prefixSum.length - 1] - prefixSum[i];
                areaSum += (double) temp / (double) (prefixSum.length - 1 - i);
            }

            backtraceV2(nodeCount + 1, i, i + 1, sum + areaSum);
        }
    }

    private static double memorySearch(int start, int end, int k) {
        if (cache[start].get(end) != null) return cache[start].get(end);
        double max = Double.MIN_VALUE;
        if (k == 1) {
            double currentAreaScore = 0d;
            int sum = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);
            currentAreaScore += (double) sum / (double) (end - start + 1);
            cache[start].put(end, max);
            return currentAreaScore;
        }

        for (int i = start; i < end; i++) {
            double currentAreaScore = 0d;
            int sum = prefixSum[i] - (start > 0 ? prefixSum[start - 1] : 0);
            currentAreaScore += (double) sum / (double) (i - start + 1);
            max = Math.max(max, currentAreaScore + memorySearch(i + 1, end, k - 1));
        }

        cache[start].put(end, max);
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(largestSumOfAveragesV2(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
//        System.out.println(largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
        System.out.println(largestSumOfAverages(new int[]{1}, 1));
//        System.out.println(largestSumOfAverages(new int[]{1,2,3}, 2));
//        System.out.println(largestSumOfAverages(new int[]{4663, 3020, 7789, 1627, 9668, 1356, 4207, 1133, 8765, 4649, 205, 6455, 8864, 3554, 3916, 5925, 3995, 4540, 3487, 5444, 8259, 8802, 6777, 7306, 989, 4958, 2921, 8155, 4922, 2469, 6923, 776, 9777, 1796, 708, 786, 3158, 7369, 8715, 2136, 2510, 3739, 6411, 7996, 6211, 8282, 4805, 236, 1489, 7698}, 27));
    }
}
