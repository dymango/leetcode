package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

/**
 * @author dimmy
 */
public class MaxSumTwoNoOverlap_1031 {

    /**
     * 给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 firstLen 和 secondLen 。
     * <p>
     * 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。
     * <p>
     * 子数组是数组的一个 连续 部分。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
     * 输出：20
     * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
     * 示例 2：
     * <p>
     * 输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
     * 输出：29
     * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
     * 示例 3：
     * <p>
     * 输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
     * 输出：31
     * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= firstLen, secondLen <= 1000
     * 2 <= firstLen + secondLen <= 1000
     * firstLen + secondLen <= nums.length <= 1000
     * 0 <= nums[i] <= 1000
     *
     * @param nums
     * @param firstLen
     * @param secondLen
     * @return
     */
    @MainParam
    int[] param = {73,19,19,55,88,6,34,21,75,5,93,30,4,12,18,98,45,15,8,9,28,56,5,69,55,95,93,46,2,29,41,28,74,9,10,14,81,52,23,57,76,59,18,66,25,87,46,32,96,1};
    @MainParam
    int a = 26;
    @MainParam
    int b = 5;

    @MainMethod
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        var length = nums.length;
        int[] sum = new int[length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i] + (i == 0 ? 0 : sum[i - 1]);
        }

        int[] firstMaxLeft = new int[length];
        int[] secondMaxLeft = new int[length];
        int aMax = Integer.MIN_VALUE;
        int bMax = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            var adif = getSumInWindow(sum, i - firstLen + 1, i);
            var bdif = getSumInWindow(sum, i - secondLen + 1, i);
            aMax = Math.max(aMax, adif);
            bMax = Math.max(bMax, bdif);
            firstMaxLeft[i] = aMax;
            secondMaxLeft[i] = bMax;
        }

        int[] firstMaxRight = new int[length];
        int[] secondMaxRight = new int[length];
        aMax = Integer.MIN_VALUE;
        bMax = Integer.MIN_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            var adif = getSumInWindow(sum, i, i + firstLen - 1);
            var bdif = getSumInWindow(sum, i, i + secondLen - 1);
            aMax = Math.max(aMax, adif);
            bMax = Math.max(bMax, bdif);
            firstMaxRight[i] = aMax;
            secondMaxRight[i] = bMax;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length - 1; i++) {
            max = Math.max(max, firstMaxLeft[i] + secondMaxRight[i + 1]);
            max = Math.max(max, secondMaxLeft[i] + firstMaxRight[i + 1]);
        }

        return max;
    }

    private int getSumInWindow(int[] arr, int start, int end) {
        if (start < 0 || end >= arr.length) return 0;
        var left = start - 1;
        return arr[end] - (left >= 0 ? arr[left] : 0);
    }
}
