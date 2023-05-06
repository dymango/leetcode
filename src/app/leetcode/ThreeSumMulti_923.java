package app.leetcode;

/**
 * @author dimmy
 */
public class ThreeSumMulti_923 {
    /**
     * 给定一个整数数组 arr ，以及一个整数 target 作为目标值，返回满足 i < j < k 且 arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。
     * 由于结果会非常大，请返回 109 + 7 的模。
     * <p>
     * 示例 1：
     * 输入：arr = [1,1,2,2,3,3,4,4,5,5], target = 8
     * 输出：20
     * 解释：
     * 按值枚举(arr[i], arr[j], arr[k])：
     * (1, 2, 5) 出现 8 次；
     * (1, 3, 4) 出现 8 次；
     * (2, 2, 4) 出现 2 次；
     * (2, 3, 3) 出现 2 次。
     * 示例 2：
     * <p>
     * 输入：arr = [1,1,2,2,2,2], target = 5
     * 输出：12
     * 解释：
     * arr[i] = 1, arr[j] = arr[k] = 2 出现 12 次：
     * 我们从 [1,1] 中选择一个 1，有 2 种情况，
     * 从 [2,2,2,2] 中选出两个 2，有 6 种情况。
     *  
     * <p>
     * 提示：
     * <p>
     * 3 <= arr.length <= 3000
     * 0 <= arr[i] <= 100
     * 0 <= target <= 300
     * <p>
     *
     * @param arr
     * @param target
     * @return
     */
    //解决方案: 动态规划，排序后双指针
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1000_000_007;
        //前n个数，选m个，满足target的数量
        int N = arr.length;
        int M = 3;
        int T = target;
        int[][][] dp = new int[N + 1][M + 1][T + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j > i) break;
                for (int k = 0; k <= T; k++) {
                    int index = i - 1;
                    if (arr[index] == k) {
                        if (dp[i - 1][j - 1][0] > 0 || j == 1) {
                            if (j == 1) {
                                dp[i][j][k] += 1;
                            } else {
                                dp[i][j][k] += dp[i - 1][j - 1][0];
                            }
                        }
                    } else {
                        if (k >= arr[index]) {
                            dp[i][j][k] += dp[i - 1][j - 1][k - arr[index]];
                        }
                    }

                    dp[i][j][k] += dp[i - 1][j][k];
                    dp[i][j][k] %= MOD;
                }
            }
        }


        return dp[N][M][T];
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumMulti_923().threeSumMulti(new int[]{1, 3, 0, 0, 0, 3, 3}, 3));
        System.out.println(new ThreeSumMulti_923().threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println(new ThreeSumMulti_923().threeSumMulti(new int[]{1, 1, 2, 2, 2, 2}, 5));
        System.out.println(new ThreeSumMulti_923().threeSumMulti(new int[]{0, 2, 0}, 2));
    }
}
