package leetcodepractice.tencent;

/**
 * @author dimmy
 */
public class ProductExceptSelf_238 {

    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     *  
     * <p>
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * <p>
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * 进阶：
     * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        l[0] = 1;
        r[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            r[i] = nums[i + 1] * r[i + 1];
        }

        for (int i = 0; i <nums.length; i++) {
            r[i] *= l[i];
        }

        return r;
    }

    public static void main(String[] args) {
        ProductExceptSelf_238 p = new ProductExceptSelf_238();
        p. productExceptSelf(new int[]{1,2,3,4});
    }
}
