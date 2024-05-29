package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class LongestOnes_1004 {

    /**
     * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * 输出：6
     * 解释：[1,1,1,0,0,1,1,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * 输出：10
     * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * nums[i] 不是 0 就是 1
     * 0 <= k <= nums.length
     *
     * @param nums
     * @param k
     * @return
     */
    public static void main(String[] args) {
//        System.out.println(new LongestOnes_1004().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(new LongestOnes_1004().longestOnes(new int[]{0, 0, 1, 1, 1, 0, 0}, 0));
        System.out.println(new LongestOnes_1004().longestOnes(new int[]{0, 0, 0, 0}, 0));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int length = nums.length;
        int used = k;
        int max = 0;
        while (right < length) {
            if (nums[right] == 1) {
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                if (used > 0) {
                    used--;
                    max = Math.max(max, right - left + 1);
                    right++;
                } else {
                    if (nums[left] == 0 && used < k) {
                        used++;
                    }
                    left++;
                    if (left > right) right++;
                }
            }
        }

        return max;
    }
}
