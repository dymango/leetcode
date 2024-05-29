package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class SortArrayByParity_905 {

    /**
     * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
     * 返回满足此条件的 任一数组 作为答案。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,1,2,4]
     * 输出：[2,4,3,1]
     * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[0]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5000
     * 0 <= nums[i] <= 5000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sort-array-by-parity
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int startValue = nums[start];
            int endValue = nums[end];
            if (startValue % 2 == 0) {
                start++;
                continue;
            }

            while (endValue % 2 != 0) {
                end--;
                if(end <= 0) break;
                endValue = nums[end];
            }

            if(start < end) {
                int t = startValue;
                nums[start] = endValue;
                nums[end] = t;

                start++;
                end--;
            } else {
                break;
            }
        }

        return nums;
    }
}
