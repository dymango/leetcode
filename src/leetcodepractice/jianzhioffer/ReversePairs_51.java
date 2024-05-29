package leetcodepractice.jianzhioffer;

/**
 * @author dimmy
 */
public class ReversePairs_51 {

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * <p>
     * 示例 1:
     * 输入: [7,5,6,4]
     * 输出: 5
     * <p>
     * 限制：
     * n^2
     * <p>
     * <p>
     * 0 <= 数组长度 <= 50000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static void main(String[] args) {
        new ReversePairs_51().reversePairs(new int[]{7, 5, 6, 4});
    }

    int result = 0;

    public int reversePairs(int[] nums) {
        if(nums.length == 0) return 0;
        mergedSort(nums, 0, nums.length - 1);
        return result;
    }

    private int[] mergedSort(int[] numArr, int start, int end) {
        if (start == end) return new int[]{numArr[start]};
        int mid = start + (end - start) / 2;
        int[] leftNumArr = mergedSort(numArr, start, mid);
        int[] rightNumArr = mergedSort(numArr, mid + 1, end);
        int index = start;
        int leftIndex = 0;
        int rightIndex = 0;
        while (index <= end) {
            if (leftIndex >= leftNumArr.length) {
                numArr[index++] = rightNumArr[rightIndex++];
            } else if (rightIndex >= rightNumArr.length) {
                numArr[index++] = leftNumArr[leftIndex++];
            } else {
                if (leftNumArr[leftIndex] <= rightNumArr[rightIndex]) {
                    numArr[index++] = leftNumArr[leftIndex++];
                } else {
                    numArr[index++] = rightNumArr[rightIndex++];
                    result += leftNumArr.length - leftIndex;
                }
            }
        }

        int[] t = new int[end - start + 1];
        for (int i = 0; i < t.length; i++) {
            t[i] = numArr[start + i];
        }

        return t;
    }
}
