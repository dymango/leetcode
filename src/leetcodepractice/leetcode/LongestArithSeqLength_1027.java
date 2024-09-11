package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class LongestArithSeqLength_1027 {
    /**
     * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
     * <p>
     * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。
     * 并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,6,9,12]
     * 输出：4
     * 解释：
     * 整个数组是公差为 3 的等差数列。
     * 示例 2：
     * <p>
     * 输入：nums = [9,4,7,2,10]
     * 输出：3
     * 解释：
     * 最长的等差子序列是 [4,7,10]。
     * 示例 3：
     * <p>
     * 输入：nums = [20,1,15,3,10,5,8]
     * 输出：4
     * 解释：
     * 最长的等差子序列是 [20,15,10,5]。
     * <p>
     * [22,8,57,41,36,46,42,28,42,14,9,43,27,51,0,0,38,50,31,60,29,31,20,23,37,53,27,1,47,42,28,31,10,35,39,12,15,6,35,31,45,21,30,19,5,5,4,18,38,51,10,7,20,38,28,53,15,55,60,56,43,48,34,53,54,55,14,9,56,52]
     *
     * @param nums
     * @return 思路1
     * 双重循环，先确定差值，再查找这个差值的最大长度
     */

    @MainParam
    int[] arr = {22, 8, 57, 41, 36, 46, 42, 28, 42, 14, 9, 43, 27, 51, 0, 0, 38, 50, 31, 60, 29, 31, 20, 23, 37, 53, 27, 1, 47, 42, 28, 31, 10, 35, 39, 12, 15, 6, 35, 31, 45, 21, 30, 19, 5, 5, 4, 18, 38, 51, 10, 7, 20, 38, 28, 53, 15, 55, 60, 56, 43, 48, 34, 53, 54, 55, 14, 9, 56, 52};


    public int longestArithSeqLengthV3(int[] nums) {
        int minv = Arrays.stream(nums).min().getAsInt();
        int maxv = Arrays.stream(nums).max().getAsInt();
        int diff = maxv - minv;
        int ans = 1;
        for (int d = -diff; d <= diff; ++d) {
            int[] f = new int[maxv + 1];
            Arrays.fill(f, -1);
            for (int num : nums) {
                int prev = num - d;
                if (prev >= minv && prev <= maxv && f[prev] != -1) {
                    f[num] = Math.max(f[num], f[prev] + 1);
                    ans = Math.max(ans, f[num]);
                }
                f[num] = Math.max(f[num], 1);
            }
        }
        return ans;
    }

    public void longestArithSeqLengthV2(int[] nums) {
        var length = nums.length;
        Map<Integer, Map<Integer, Integer>> memorizedMap = new HashMap<>();
        Set<Integer> difSet = new HashSet<>();
        for (int i = length - 1; i >= 0; i--) {
            for (Integer integer : difSet) {

            }
        }
    }

    @MainMethod
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Map<Integer, Integer>> memorizedMap = new HashMap<>();
        var initMap = new HashMap<Integer, Integer>();
        initMap.put(0, 1);
        memorizedMap.putIfAbsent(0, initMap);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            memorizedMap.putIfAbsent(i, new HashMap<>());
            for (int j = i - 1; j >= 0; j--) {
                var list = memorizedMap.get(j);
                var dif = num - nums[j];
                var count = list.get(dif);
                var value = count == null ? 2 : count + 1;
                memorizedMap.get(i).merge(dif, value, Math::max);
                max = Math.max(max, value);
            }
        }

        return max;
    }
}
