package leetcodepractice.twohundred;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class threeSum15 {

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * [-1,0,1,2,-1,-4]
     * <p>
     * 添加到测试用例
     * 输出
     * [[-1,0,1]]
     * [[-1,-1,2],[-1,0,1]]
     * 预期结果
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        var length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int cur = nums[i] + nums[j];
                int target = -cur;
                for (int k = length - 1; k > j; k--) {
                    if (nums[k] == target) {
                        r.add(List.of(nums[i], nums[j], nums[k]));
                        break;
                    }

                    if (nums[k] < target) break;
                }
            }
        }

        return r;
    }

    @MainParam
    int[] n = {-1,0,1,2,-1,-4};

    @MainMethod
    public List<List<Integer>> threeSumV2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        var length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1;
            int end = length - 1;
            var target = -nums[i];
            while (start < end) {
                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if (end < length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }

                var s = nums[start] + nums[end];
                if (s == target) {
                    r.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (s > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return r;
    }
}
