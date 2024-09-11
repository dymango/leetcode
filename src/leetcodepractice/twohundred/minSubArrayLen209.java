package leetcodepractice.twohundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class minSubArrayLen209 {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其总和大于等于 target 的长度最小的
     * 子数组
     * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     * <p>
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * <p>
     * 20
     * nums =
     * [2,16,14,15]
     *
     * @param target
     * @param nums
     * @return
     */

    public static void main(String[] args) {
        new minSubArrayLen209().minSubArrayLen(15, new int[]{1, 2, 3, 4, 5});
    }

    public int minSubArrayLenV2(int target, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        if (map.containsKey(target)) return 1;
        var i = find(map, target);
        return i == -1 ? 0 : i;
    }

    private int find(Map<Integer, Integer> map, int n) {
        if (n == 0) return 0;
        if (map.containsKey(n) && map.get(n) > 0) return 1;
        int min = Integer.MAX_VALUE;
        boolean find = false;
        for (int i = n; i > 0; i--) {
            if (map.containsKey(i) && map.get(i) > 0) {
                var num = map.get(i);
                map.put(i, num - 1);
                var r = find(map, n - i);
                map.put(i, num);
                if (r != -1) {
                    find = true;
                    min = Math.min(min, 1 + r);
                }
            }
        }

        return find ? min : -1;
    }

    public int minSubArrayLen(int target, int[] nums) {
        boolean match = false;
        int start = 0;
        int end = 1;
        int sum = nums[start];
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num >= target) {
                match = true;
                min = 1;
                break;
            }
        }

        while (start < end && end < nums.length) {
            sum += nums[end];
            if (sum >= target) {
                min = Math.min(min, end - start + 1);
                match = true;
                sum -= nums[start];
                sum -= nums[end];
                start++;
            } else {
                end++;
            }
        }

        return match ? min : 0;
    }

    private int initMin(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == target) {
                return 1;
            }
        }
        return min;
    }
}
