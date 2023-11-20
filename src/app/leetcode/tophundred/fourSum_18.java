package app.leetcode.tophundred;

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
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,2,2,2], target = 8
     * 输出：[[2,2,2,2]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length - 3; first++) {
            if (first != 0 && nums[first] == nums[first - 1]) continue;
            for (int second = first + 1; second < length - 2; second++) {
                if (second != first + 1 && nums[second] == nums[second - 1]) continue;
                long left = (long) target - nums[first] - nums[second];
                int third = second + 1;
                int fourth = length - 1;
                while (third < fourth) {
                    int sum = nums[third] + nums[fourth];
                    if (sum == left) {
                        result.add(List.of(nums[first], nums[second], nums[third], nums[fourth]));
                        fourth--;
                        while (fourth > third && nums[fourth] == nums[fourth + 1]) {
                            fourth--;
                        }
                    } else if (sum > left) {
                        fourth--;
                        while (fourth > third && nums[fourth] == nums[fourth + 1]) {
                            fourth--;
                        }
                    } else {
                        third++;
                        while (third < fourth && nums[third] == nums[third - 1]) {
                            third++;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //1000000000,1000000000,1000000000,1000000000]
        //target =
        //-294967296
        long a = -294967296;
        System.out.println(a - 1000000000 - 1000000000);
    }
}
