package app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class CheckSubarraySum_523 {

    /**
     * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[23,2,4,6,7], k = 6
     * 输出：True
     * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
     * 示例 2：
     *
     * 输入：[23,2,6,4,7], k = 6
     * 输出：True
     * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
     *  
     *
     * 说明：
     *
     * 数组的长度不会超过 10,000 。
     * 你可以认为所有数字总和在 32 位有符号整数范围内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sumArr = new int[n];
        sumArr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i];
        }

        for (int j = 0; j < n - 1; j++) {
            int sum = nums[j] + nums[j + 1];
            if((k ==0 && sum == 0) || (k != 0 && sum%k == 0)) return true;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                int sum = nums[j] + sumArr[j+i-1] - sumArr[j];
                if((k ==0 && sum == 0) || (k != 0 && sum%k == 0)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7}, 0));
        System.out.println(checkSubarraySum(new int[]{0,0,0,0,0,0}, 1));
        System.out.println(checkSubarraySum(new int[]{0,1,0}, 0));
    }
}
