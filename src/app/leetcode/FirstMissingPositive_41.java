package app.leetcode;


/**
 * @author dimmy
 */
public class FirstMissingPositive_41 {

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,0]
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：nums = [3,4,-1,1]
     * -1 4 3 1
     * -1 1 3 4
     * <p>
     * 输出：2
     * 示例 3：
     * <p>
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5 * 105
     * -231 <= nums[i] <= 231 - 1
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        new FirstMissingPositive_41().firstMissingPositive(new int[]{-1,4,2,1,9,10});
    }
}
