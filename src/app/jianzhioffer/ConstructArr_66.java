package app.jianzhioffer;

/**
 * @author dimmy
 */
public class ConstructArr_66 {

    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     * <p>
     * 示例:
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]
     *  
     * 提示：
     * <p>
     * 所有元素乘积之和不会溢出 32 位整数
     * a.length <= 100000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if(a.length == 0) return new int[0];
        int length = a.length;
        int[] left = new int[length];
        left[0] = a[0];
        int[] right = new int[length];
        right[length - 1] = a[length - 1];
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * a[i];
        }

        int[] r = new int[length];
        r[length - 1] = left[length - 2];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i];
            int leftValue = i > 0 ? left[i - 1] : 1;
            r[i] = leftValue * right[i + 1];
        }

        return r;
    }
}
