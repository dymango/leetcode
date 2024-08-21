package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class fourSum_18 {

    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     * <p>
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> r = new ArrayList<>();
        Arrays.sort(nums);
        var length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long t =  (long)target - (long)nums[i] -  (long)nums[j];
                int start = j + 1;
                int end = length - 1;
                while (start < end) {
                    if (start > j + 1 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    if (end < length - 1 && nums[end] == nums[end + 1]) {
                        end--;
                        continue;
                    }
                    long sum =  (long)nums[start] +  (long)nums[end];
                    if (sum == t) {
                        r.add(List.of(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                    } else if (sum > t) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        return r;
    }
}
