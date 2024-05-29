package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class FindUnsortedSubarray_581 {

    /**
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * <p>
     * 你找到的子数组应是最短的，请输出它的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1， 2,3, 10, 9, 7]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * 说明 :
     * <p>
     * 输入的数组长度范围在 [1, 10,000]。
     * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 解题思路：
     * 你要确保子数组前后的元素都大于等于子数组中任一元素
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int numsLength = nums.length;
        int index = 0;
        int start;
        boolean isASC = true;
        for (int i = 1; i < numsLength; i++) {
            if (nums[i] >= nums[i - 1]) continue;
            isASC = false;
            index = i;
            start = i - 1;
            while (start >= 0) {
                if (nums[start] > nums[index]) {
                    start--;
                    continue;
                }

                index = start + 1;
                break;
            }

            if (start == -1) index = 0;
            break;
        }

        if (isASC) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numsLength; i++) {
            max = Math.max(max, nums[i]);
        }

        int endIndex = numsLength - 1;
        int end;
        if(max != nums[numsLength - 1]) {
            endIndex = numsLength - 1;
        } else {
            for (int i = numsLength - 2; i >= 0; i--) {
                if (nums[i] <= nums[i + 1]) continue;
                endIndex = i;
                end = i + 1;
                while (end < numsLength) {
                    if (nums[end] < nums[endIndex]) {
                        end++;
                        continue;
                    }

                    endIndex = end - 1;
                    break;
                }

                if (end >= numsLength) endIndex = numsLength - 1;
                break;
            }
        }

        return endIndex - index + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 3, 3}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 5, 4, 2}));
    }
}
