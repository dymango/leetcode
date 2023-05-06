package app.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author dimmy
 */
public class ShortestSubarray_862 {

    /**
     * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
     * <p>
     * 如果没有和至少为 K 的非空子数组，返回 -1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：A = [1], K = 1
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：A = [1,2], K = 4
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：A = [2,-1,2], K = 3
     * 输出：3
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 50000
     * -10 ^ 5 <= A[i] <= 10 ^ 5
     * 1 <= K <= 10 ^ 9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     *
     * 方法一：滑动窗口
     * 分析
     *
     * 我们用数组 P 表示数组 A 的前缀和，即 P[i] = A[0] + A[1] + ... + A[i - 1]。我们需要找到 x 和 y，使得 P[y] - P[x] >= K 且 y - x 最小。
     *
     * 我们用 opt(y) 表示对于固定的 y，最大的满足 P[x] <= P[y] - K 的 x，这样所有 y - opt(y) 中的最小值即为答案。我们可以发现两条性质：
     *
     * 如果 x1 < x2 且 P[x2] <= P[x1]，那么 opt(y) 的值不可能为 x1，这是因为 x2 比 x1 大，并且如果 x1 满足了 P[x1] <= P[y] - K，那么 P[x2] <= P[x1] <= P[y] - K，即 x2 同样满足 P[x2] <= P[y] - K。
     *
     * 如果 opt(y1) 的值为 x，那么我们以后就不用再考虑 x 了。这是因为如果有 y2 > y1 且 opt(y2) 的值也为 x，但此时 y2 - x 显然大于 y1 - x，不会作为所有 y - opt(y) 中的最小值。
     *
     * 算法
     *
     * 我们维护一个关于前缀和数组 P 的单调队列，它是一个双端队列（deque），其中存放了下标 x：x0, x1, ... 满足 P[x0], P[x1], ... 单调递增。这是为了满足性质一。
     *
     * 当我们遇到了一个新的下标 y 时，我们会在队尾移除若干元素，直到 P[x0], P[x1], ..., P[y] 单调递增。这同样是为了满足性质一。
     *
     * 同时，我们会在队首也移除若干元素，如果 P[y] >= P[x0] + K，则将队首元素移除，直到该不等式不满足。这是为了满足性质二。
     *
     */
    public static void main(String[] args) {
        ShortestSubarray_862 shortestSubarray_862 = new ShortestSubarray_862();
        shortestSubarray_862.shortestSubarray(new int[]{2,-1,2}, 3);
        shortestSubarray_862.shortestSubarray(new int[]{1,2}, 4);
    }
    public int shortestSubarray(int[] nums, int k) {
        int[] sums = new int[nums.length];
        int l = Integer.MAX_VALUE;
        sums[0] = nums[0];
        if(sums[0] >= k) return 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= k) return 1;
            sums[i] = nums[i] + sums[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                int value = sums[i] - (j > 0 ? sums[j - 1] : 0);
                if(value >= k) {
                    l = Math.min(l, i -j + 1);
                    break;
                }
            }
        }

        return l == Integer.MAX_VALUE ? -1 : l;
    }

    public int shortestSubarrayV2(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }
}
