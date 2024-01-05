package app.leetcode;

import java.util.Stack;

/**
 * @author dimmy
 */
public class maxWidthRamp_962 {

    /**
     * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
     * <p>
     * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[6,0,8,2,1,5]
     * 输出：4
     * 解释：
     * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
     * 示例 2：
     * <p>
     * 输入：[9,8,1,0,1,9,4,0,4,1]
     * [5,6,7,8,9,12,0,3]
     * 输出：7
     * 解释：
     * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= A.length <= 50000
     * 0 <= A[i] <= 50000
     *
     * @param nums
     * @return
     */
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            if (nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if(stack.isEmpty()) break;
            while (!stack.isEmpty()) {
                if(nums[stack.peek()] <= nums[i]) {
                    max = Math.max(max, i - stack.pop());
                } else {
                    break;
                }
            }
        }


        return max;
    }
}
