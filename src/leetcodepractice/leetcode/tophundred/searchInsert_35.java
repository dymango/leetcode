package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class searchInsert_35 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 为 无重复元素 的 升序 排列数组
     * -104 <= target <= 104
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
                int end = nums.length - 1;
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (nums[mid] == target) return mid;
                    if (nums[mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
            }
        }

        return end;
    }
}
