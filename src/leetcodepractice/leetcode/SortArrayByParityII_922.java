package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class SortArrayByParityII_922 {

    /**
     * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
     * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
     * 你可以返回 任何满足上述条件的数组作为答案 。
     * <p>
     * <p>
     * 示例 1：
     * 输入：nums = [4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     * 示例 2：
     * <p>
     * 输入：nums = [2,3]
     * 输出：[2,3]
     *  
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 2 * 104
     * nums.length 是偶数
     * nums 中一半是偶数
     * 0 <= nums[i] <= 1000
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sort-array-by-parity-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * <p>
     * [4,2,5,7]
     * 输出
     * [4,5,7,2]
     * 预期结果
     * [4,5,2,7]
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII(int[] nums) {
        sortEvenNumbers(nums);
        sortOddNumbers(nums);
        return nums;
    }

    private void sortOddNumbers(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 != 0) {
                start += 2;
                continue;
            }

            while (nums[end] % 2 == 0 || end % 2 != 0) {
                end--;
            }
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start += 2;
        }
    }

    private void sortEvenNumbers(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 == 0) {
                start += 2;
                continue;
            }

            while (nums[end] % 2 != 0 || end % 2 == 0) {
                end--;
            }
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start += 2;
        }
    }
}
