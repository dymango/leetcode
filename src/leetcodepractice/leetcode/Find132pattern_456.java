package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class Find132pattern_456 {

    /**
     * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
     *
     * 注意：n 的值小于15000。
     *
     * 示例1:
     *
     * 输入: [1, 2, 3, 4]
     *
     * 输出: False
     *
     * 解释: 序列中不存在132模式的子序列。
     * 示例 2:
     *
     * 输入: [3, 1, 4, 2]
     *
     * 输出: True
     *
     * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
     * 示例 3:
     *
     * 输入: [-1, 3, 2, 0]
     *
     * 输出: True
     *
     * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/132-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums 
     * @return 
     */
    public static boolean find132pattern(int[] nums) {
        int[] leftMin = new int[nums.length];
        leftMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMin[i] = nums[i] > leftMin[i - 1] ? leftMin[i - 1] : nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            int center = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int right = nums[j];
                if(right < center) {
                    int left = leftMin[i - 1];
                    if(left < right) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        find132pattern(new int[]{3,1,4,2});
    }
}
