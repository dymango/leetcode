package app.leetcode;

/**
 * @author dimmy
 */
public class PartitionDisjoint_915 {

    /**
     * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
     * <p>
     * left 中的每个元素都小于或等于 right 中的每个元素。
     * left 和 right 都是非空的。
     * left 的长度要尽可能小。
     * 在完成这样的分组后返回 left 的 长度 。
     * <p>
     * 用例可以保证存在这样的划分方法。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [5,0,3,8,6]
     * 输出：3
     * 解释：left = [5,0,3]，right = [8,6]
     * 示例 2：
     * <p>
     * 输入：nums = [1,1,1,0,6,12]
     * 输出：4
     * 解释：left = [1,1,1,0]，right = [6,12]
     *  
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 105
     * 0 <= nums[i] <= 106
     * 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/partition-array-into-disjoint-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */

    //两次遍历
    public int partitionDisjoint(int[] nums) {
        int length = nums.length;
        int[] rightMax = new int[length];
        rightMax[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.min(nums[i], rightMax[i + 1]);
        }

        int leftMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) leftMax = Math.max(nums[i], leftMax);
            if (leftMax <= rightMax[i + 1]) return i + 1;
        }

        return -1;
    }

    //一次遍历
    public int partitionDisjointV2(int[] nums) {
        int index = 0;
        int leftMax = nums[0];
        int length = nums.length;
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] < leftMax) {
                index = i;
                leftMax = max;
            }

            max = Math.max(max, nums[i]);
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int i = new PartitionDisjoint_915().partitionDisjointV2(new int[]{24, 11, 49, 80, 63, 8, 61, 22, 73, 85});
    }
}
