package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class Search_33 {

    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：nums = [1], target = 0
     * 输出：-1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * nums 中的每个值都 独一无二
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -104 <= target <= 104
     *
     * @param nums
     * @param target
     * @return ma
     */
    public static void main(String[] args) {
//        System.out.println(new Search_33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new Search_33().search(new int[]{1, 3}, 3));
        System.out.println(new Search_33().search(new int[]{3, 1}, 1));
    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) return middle;
            if (nums[middle] >= nums[start]) {
                if (target >= nums[start] && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if (target > nums[middle] && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }

        return -1;
    }
}
