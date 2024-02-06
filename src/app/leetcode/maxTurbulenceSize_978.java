package app.leetcode;

/**
 * @author dimmy
 */
public class maxTurbulenceSize_978 {

    /**
     * 给定一个整数数组 arr ，返回 arr 的 最大湍流子数组的长度 。
     * <p>
     * 如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是 湍流子数组 。
     * <p>
     * 更正式地来说，当 arr 的子数组 A[i], A[i+1], ..., A[j] 满足仅满足下列条件时，我们称其为湍流子数组：
     * <p>
     * 若 i <= k < j ：
     * 当 k 为奇数时， A[k] > A[k+1]，且
     * 当 k 为偶数时，A[k] < A[k+1]；
     * 或 若 i <= k < j ：
     * 当 k 为偶数时，A[k] > A[k+1] ，且
     * 当 k 为奇数时， A[k] < A[k+1]。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [9,4,2,10,7,8,8,1,9]
     * 输出：5
     * 解释：arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
     * 示例 2：
     * <p>
     * 输入：arr = [4,8,12,16]
     * 输出：2
     * 示例 3：
     * <p>
     * 输入：arr = [100]
     * 输出：1
     *
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        int length = arr.length;
        int[] subArrLengths = new int[length];
        subArrLengths[0] = 1;
        int max = 1;
        if (length > 1) {
            if (arr[1] == arr[0]) {
                subArrLengths[1] = 1;
            } else {
                subArrLengths[1] = 2;
                max = 2;
            }
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] && arr[i - 1] < arr[i - 2] ||
                arr[i] < arr[i - 1] && arr[i - 1] > arr[i - 2]) {
                subArrLengths[i] = subArrLengths[i - 1] + 1;
            } else {
                subArrLengths[i] = arr[i] == arr[i - 1] ? 1 : 2;
            }

            max = Math.max(max, subArrLengths[i]);
        }

        return max;
    }
}
