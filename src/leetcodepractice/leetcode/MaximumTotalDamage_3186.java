package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class MaximumTotalDamage_3186 {

    /**
     * 一个魔法师有许多不同的咒语。
     * 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。
     * 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。
     * 每个咒语最多只能被使用 一次 。
     * 请你返回这个魔法师可以达到的伤害值之和的 最大值 。
     * <p>
     * 示例 1：
     * 输入：power = [1,1,3,4]
     * 输出：6
     * 解释：
     * 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。
     * <p>
     * 示例 2：
     * 输入：power = [7,1,6,6]
     * 输出：13
     * <p>
     * 解释：
     * <p>
     * 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。
     *
     * @param power
     * @return
     */
    public static void main(String[] args) {
        new MaximumTotalDamage_3186().maximumTotalDamage(new int[]{1, 1, 3, 4});
    }


    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + p);
        }

        // 排序
        List<Integer> vals = new ArrayList<>(map.keySet());
        Collections.sort(vals);

        int n = vals.size();
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = map.get(vals.get(i));

            // 找上一个不冲突的 j
            int j = i - 1;
            while (j >= 0 && vals.get(i) - vals.get(j) <= 2) {
                j--;
            }

            long pick = cur + (j >= 0 ? dp[j] : 0);
            long notPick = (i > 0 ? dp[i - 1] : 0);
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

}
