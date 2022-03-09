package app.jianzhioffer;

/**
 * @author dimmy
 */
public class Exchange_21 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     * <p>
     * 示例：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 50000
     * 0 <= nums[i] <= 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int l = nums.length;
        int p1 = 0;
        int p2 = l - 1;
        while (p1 < l) {
            if (nums[p1] % 2 == 0) break;
            p1++;
        }

        while (p2 >= 0) {
            if (nums[p2] % 2 != 0) break;
            p2--;
        }

        while (p1 < p2) {
            int t = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = t;
            while (++p1 < l) {
                if (nums[p1] % 2 == 0) break;
            }

            while (--p2 >= 0) {
                if (nums[p2] % 2 != 0) break;
            }
        }

        return nums;
    }
}
