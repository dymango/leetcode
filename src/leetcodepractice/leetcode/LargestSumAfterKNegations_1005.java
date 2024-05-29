package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class LargestSumAfterKNegations_1005 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
     * <p>
     * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
     * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
     * <p>
     * 以这种方式修改数组后，返回数组 可能的最大和 。
     *
     * @param nums
     * @param k
     * @return [3,-1,0,2]
     * <p>
     * [5,6,9,-3,3]
     * 2
     */
    @MainMethod
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            list.add(num);
        }

        list.sort(Integer::compare);
        int i = 0;
        while (k > 0) {
            if(i >= nums.length) {
                Integer tn = list.get(i - 1);
                sum -= tn;
                sum += -tn;
                list.set(i - 1, -tn);
                k--;
                continue;
            }

            Integer n = list.get(i);
            Integer pre;
            if (i > 0 && n > (pre = list.get(i - 1))) {
                sum -= pre;
                sum += -pre;
                list.set(i - 1, -pre);
            } else {
                sum -= n;
                sum += -n;
                list.set(i, -n);
                i++;
            }

            k--;
        }




        return sum;
    }
}
