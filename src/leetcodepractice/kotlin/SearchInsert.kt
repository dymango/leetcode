package leetcodepractice.kotlin

/**
 *  @author dimmy
 */
class SearchInsert {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    请必须使用时间复杂度为 O(log n) 的算法。

    示例 1:

    输入: nums = [1,3,5,6], target = 5
    输出: 2
    示例 2:

    输入: nums = [1,3,5,6], target = 2
    输出: 1
    示例 3:

    输入: nums = [1,3,5,6], target = 7
    输出: 4
     

    提示:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums 为 无重复元素 的 升序 排列数组
    -104 <= target <= 104

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/search-insert-position
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        while (start <= end) {
            var middle = start + (end - start) / 2
            if (nums[middle] == target) return middle
            if (nums[middle] > target) {
                end = middle - 1
            } else {
                start = middle + 1
            }
        }

        return start
    }
}