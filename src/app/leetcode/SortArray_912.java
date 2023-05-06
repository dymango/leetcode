package app.leetcode;

/**
 * @author dimmy
 */
public class SortArray_912 {

    /**
     * 给你一个整数数组 nums，请你将该数组升序排列。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [5,2,3,1]
     * 输出：[1,2,3,5]
     * 示例 2：
     * <p>
     * 输入：nums = [5,1,1,2,0,0]
     * 输出：[0,0,1,1,2,5]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5 * 104
     * -5 * 104 <= nums[i] <= 5 * 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sort-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        return nums;
    }

    public void quickSort(int start, int end, int[] nums) {
        if (start >= end) return;
        int j = sort(start, end, nums);
        quickSort(start, j - 1, nums);
        quickSort(j + 1, end, nums);
    }

    private int sort(int start, int end, int[] nums) {
        int i = start;
        int j = end + 1;
        int sign = nums[start];
        while (true) {
            while (nums[++i] < sign) {
                if (i == end) break;
            }

            while (nums[--j] > sign) {
                if (j == start) break;
            }

            if (i >= j) break;
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        int t = nums[j];
        nums[j] = sign;
        nums[start] = t;
        return j;
    }
}
