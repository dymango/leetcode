package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MaxSumAfterPartitioning_1043 {

    /**
     * 给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
     * 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
     *
     * 示例 1：
     *
     * 输入：arr = [1,15,7,9,2,5,10], k = 3
     * 输出：84
     * 解释：数组变为 [15,15,15,9,10,10,10]
     * 示例 2：
     *
     * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
     * 输出：83
     * 示例 3：
     *
     * 输入：arr = [1], k = 1
     * 输出：1
     * @param arr
     * @param k
     * @return
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] maxArr = new int[arr.length];
        maxArr[0] = arr[0];
        for (int i = 1; i < maxArr.length; i++) {
            int max = Integer.MIN_VALUE;
            int limit = i - k + 1;
            if(limit < 0) limit = 0;
            for (int j = i; j >= limit; j--) {
                max = Math.max(max, arr[j]);
                int sum = max * (i - j + 1);
                maxArr[i] = Math.max(maxArr[i], sum + (j - 1 >= 0 ? maxArr[j - 1] : 0));
            }
        }

        return maxArr[maxArr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MaxSumAfterPartitioning_1043().maxSumAfterPartitioning(new int[]{1}, 1));
    }
}
