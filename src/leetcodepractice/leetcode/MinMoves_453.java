package leetcodepractice.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class MinMoves_453 {

    /**
     * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
     *
     *  
     *
     * 示例:
     *
     * 输入:
     * [1,2,3]
     *
     * 输出:
     * 3
     *
     * 解释:
     * 只需要3次移动（注意每次移动会增加两个元素的值）：
     *
     * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }
}
