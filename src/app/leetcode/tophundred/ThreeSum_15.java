package app.leetcode.tophundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class ThreeSum_15 {

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * 示例 3：
     * <p>
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length; j++) {
                int sum = nums[i] + nums[j];
                if (sum > 0) break;
                if (j != i + 1 && j > 0 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1; k < length; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) continue;
                    int i1 = sum + nums[k];
                    if (i1 > 0) break;
                    if (i1 == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        r.add(list);
                        break;
                    }
                }
            }
        }

        return r;
    }

    public List<List<Integer>> threeSumV3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        int length = nums.length;
        int first = 0;
        while (first < length - 2) {
            if (first > 0 && nums[first] == nums[first - 1]){
                first++;
                continue;
            }
            int firstVal = nums[first];
            int second = first + 1;
            int target = -firstVal;
            while (second < length - 1) {
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }
                int secondVal = nums[second];
                int third = second + 1;
                while (third < length && nums[third] + secondVal < target) {
                    third++;
                }

                if(third >= length) {
                    second++;
                    continue;
                }
                if(nums[third] + secondVal == target) {
                    r.add(List.of(firstVal, secondVal, nums[third]));
                }

                second++;
            }

            first++;
        }

        return r;
    }

    public List<List<Integer>> threeSumV2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        int length = nums.length;
        Map<Integer, List<List<Integer>>> listMap = new HashMap<>();
        for (int i = length - 2; i >= 1; i--) {
            if (i != length - 2 && nums[i] == nums[i] + 1) continue;
            for (int j = i + 1; j < length; j++) {
                if (j != i + 1 && nums[j] == nums[j] + 1) continue;
                int sum = nums[i] + nums[j];
                listMap.putIfAbsent(sum, new ArrayList<>());
                listMap.get(sum).add(List.of(i, j));
            }
        }

        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> lists = listMap.get(-nums[i]);
            if (lists == null) continue;
            for (List<Integer> list : lists) {
                if (list.get(0) > i) {
                    r.add(List.of(nums[i], nums[list.get(0)], nums[list.get(1)]));
                }
            }
        }

        return r;
    }

    public static void main(String[] args) {
        new ThreeSum_15().threeSumV3(new int[]{-1, 0, 1, 2, -1, -4});
        new ThreeSum_15().threeSumV3(new int[]{0,0,0,0});
    }
}
