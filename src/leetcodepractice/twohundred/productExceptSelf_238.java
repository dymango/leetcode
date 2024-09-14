package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class productExceptSelf_238 {

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        var length = nums.length;
        int[] leftProducts = new int[length];
        leftProducts[0] = 1;
        int[] rightProducts = new int[length];
        rightProducts[length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
        }

        int[] sumArr = new int[length];
        sumArr[length - 1] = leftProducts[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
            if (i > 0) sumArr[i] = leftProducts[i - 1] * rightProducts[i + 1];
        }

        sumArr[0] = rightProducts[0];
        return sumArr;
    }

}
