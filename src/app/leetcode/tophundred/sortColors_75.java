package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class sortColors_75 {

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     * <p>
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int right = nums.length - 1, left = 0;
        while (right > 0) {
            if (nums[right] == 0) {
                while (left < nums.length && nums[left] == 0) left++;
                if (left < right) {
                    int t = nums[left];
                    nums[left] = nums[right];
                    nums[right] = t;
                }
            }

            right--;
        }

        right = nums.length - 1;
        left = 0;
        while (right > 0) {
            if (nums[right] == 1) {
                while (left < nums.length && (nums[left] == 0 || nums[left] == 1)) left++;
                if (left < right) {
                    int t = nums[left];
                    nums[left] = nums[right];
                    nums[right] = t;
                }
            }

            right--;
        }
    }
}
