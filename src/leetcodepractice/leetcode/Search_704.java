package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class Search_704 {

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     *
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *  
     *
     * 提示：
     *
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        if(nums[start] > target) return -1;
        if(nums[end] < target) return -1;
        while (start < end) {
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            int middle = start + (end - start) / 2;
            if (nums[middle] >= target) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(search(new int[]{-1,0,3,5,9,12}, 3));

    }
}
