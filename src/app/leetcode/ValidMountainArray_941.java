package app.leetcode;

/**
 * @author dimmy
 */
public class ValidMountainArray_941 {

    /**
     * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
     * <p>
     * 让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：
     * <p>
     * arr.length >= 3
     * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
     * arr[0] < arr[1] < ... arr[i-1] < arr[i]
     * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     *  
     * <p>
     * <p>
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [2,1]
     * 输出：false
     * 示例 2：
     * <p>
     * 输入：arr = [3,5,5]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：arr = [0,3,2,1]
     * 输出：true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-mountain-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {
        boolean up = false;
        boolean down = false;
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > pre) {
                up = true;
                if (down) return false;
            } else if(arr[i] < pre) {
                if (!up) return false;
                down = true;
            } else {
                return false;
            }

            pre = arr[i];
        }

        return up && down;
    }
}
