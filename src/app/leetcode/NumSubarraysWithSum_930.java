package app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class NumSubarraysWithSum_930 {

    /**
     * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
     * 子数组 是数组的一段连续部分。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,0,1,0,1], goal = 2
     * 输出：4
     * 解释：
     * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,0,0,0], goal = 0
     * 输出：15
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 3 * 104
     * nums[i] 不是 0 就是 1
     * 0 <= goal <= nums.length
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-subarrays-with-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param goal
     * @return
     */
    public static void main(String[] args) {
        //[0,0,0,0,0]
        //0
        System.out.println(new NumSubarraysWithSum_930().numSubarraysWithSumV4(new int[]{1, 0, 1, 0, 1}, 2));
//        System.out.println(new NumSubarraysWithSum_930().numSubarraysWithSumV3(new int[]{0, 0, 0, 0, 0}, 0));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        int length = nums.length;
        int addIndex = 0;
        boolean check = true;
        while (end - start >= 0 && end < nums.length) {
            if (check) sum += nums[addIndex];
            if (sum == goal) {
                count++;
                if (end == length - 1) {
                    sum -= nums[start];
                    start++;
                    addIndex = start;
                    check = true;
                } else {
                    end++;
                    addIndex = end;
                    check = true;
                }
            } else if (sum > goal) {
                sum -= nums[start];
                start++;
                check = false;
                if (end < start) end = start;
            } else {
                end++;
                addIndex = end;
                check = true;
            }
        }

        return count;
    }

    public static class Node {
        public int index;
        public int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int numSubarraysWithSumV2(int[] nums, int goal) {
        int count = nums[0] == goal ? 1 : 0;
        int length = nums.length;
        int[] sumArr = new int[length];
        sumArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArr[i] = nums[i] + sumArr[i - 1];
            if (nums[i] == goal) count++;
            for (int j = i - 1; j >= 0; j--) {
                int sum = sumArr[i] - (j > 0 ? sumArr[j - 1] : 0);
                if (sum > goal) break;
                if (sum == goal) count++;
            }
        }

        return count;
    }

    public int numSubarraysWithSumV4(int[] nums, int goal) {
        int count = 0;
        int length = nums.length;
        int[] sumArr = new int[length];
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sumArr[0] = nums[0];
            } else {
                sumArr[i] = sumArr[i - 1] + nums[i];
            }

            int sum = sumArr[i];
            Integer c = cache.getOrDefault(sum - goal, 0);
            count += c;
            cache.merge(sum, 1, Integer::sum);
        }

        return count;
    }

    public int numSubarraysWithSumV3(int[] nums, int goal) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int r = sum[i + 1], l = r - goal;
            ans += map.getOrDefault(l, 0);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return ans;
    }

}
