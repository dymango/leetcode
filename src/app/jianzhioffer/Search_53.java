package app.jianzhioffer;

/**
 * @author dimmy
 */
public class Search_53 {

    /**
     * 统计一个数字在排序数组中出现的次数。
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int index = getIndex(nums, target);
        if(index == -1) return 0;
        int count = 1;
        int i = index - 1;
        while (i >= 0) {
            if(nums[i] == target) count++;
            else break;
            i--;
        }

        int j = index + 1;
        while (j < nums.length) {
            if(nums[j] == target) count++;
            else break;
            j++;
        }

        return count;
    }

    private int getIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
