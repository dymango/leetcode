package leetcodepractice.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class lastStoneWeightII {

    /**
     * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
     * <p>
     * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     * <p>
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
     * <p>
     * <p>
     * 最后两块石头必须尽量地重且重量相近
     * <p>
     * 消尽量小的石头，
     * <p>
     * 2 7 4 1 8 1
     * 111
     * <p>
     * 9   26
     * 12
     * <p>
     * 9
     * 7
     * 21
     * <p>
     * 9 26 31 33
     * 24 26 31
     * [31,26,33,21,40]
     * 5 7 12 9
     * 31 24
     * 9 26 21 33
     * 7 12
     * 7 19 31
     * 24
     * <p>
     * 1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98
     * <p>
     * [21,60,61,20,31]
     * 5
     * * 2
     * <p>
     * <p>
     * <p>
     * 20 21 31 60 61
     * 20 30 39
     * 10
     * <p>
     * 41
     * 39 31
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        for (int j = target; j >= 0; j--) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(new lastStoneWeightII().lastStoneWeightII(new int[]{21, 60, 61, 20, 31}));
        System.out.println(new lastStoneWeightII().lastStoneWeightII(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 14, 23, 37, 61, 98}));
    }
}
