package app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class LenLongestFibSubseq_873 {

    /**
     * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
     * <p>
     * n >= 3
     * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
     * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
     * <p>
     * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: arr = [1,2,3,4,5,6,7,8]
     * 输出: 5
     * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
     * 示例 2：
     * <p>
     * 输入: arr = [1,3,7,11,12,14,18]
     * 输出: 3
     * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
     *  
     * <p>
     * 提示：
     * <p>
     * 3 <= arr.length <= 1000
     * 1 <= arr[i] < arr[i + 1] <= 10^9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        int[][] step = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        int ans = 0;

        for (int k = 0; k < N; ++k)
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int cand = (visited[i][j] ? step[i][j] : 2) + 1;
                    step[j][k] = cand;
                    visited[j][k] = true;
                    ans = Math.max(ans, cand);
                }
            }

        return ans >= 3 ? ans : 0;
    }


    public static void main(String[] args) {
//        new LenLongestFibSubseq_873().lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50});
        new LenLongestFibSubseq_873().lenLongestFibSubseq(new int[]{1, 3, 5});
    }
}
