package app.tencent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 */
public class ThreeSumClosest_16 {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     *  
     *
     * 示例：
     *
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *  
     *
     * 提示：
     *
     * 3 <= nums.length <= 10^3
     * -10^3 <= nums[i] <= 10^3
     * -10^4 <= target <= 10^4
     *
     * @param nums
     * @param target
     * @return
     */
    int T;
    int[] numArr;
    int d;
    int r;
    public int threeSumClosest(int[] nums, int target) {
        T = target;
        numArr = nums;
        d = Integer.MAX_VALUE;
        r = 0;
        backTracking(0, new HashSet<>());
        return r;
    }

    public void backTracking(int sum, Set<Integer> set) {
        if(set.size() == 3) {
            if(Math.abs(sum - T) < d) {
                d = Math.abs(sum - T);
                r = sum;
            }
            return;
        }
        for (int i = 0; i < numArr.length; i++) {
            if(!set.add(i)) continue;
            sum += numArr[i];
            backTracking(sum, set);
            sum -= numArr[i];
            set.remove(i);
        }

    }
}
