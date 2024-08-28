package leetcodepractice.twohundred;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class rotate189 {

    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * @param nums
     * @param k
     * [1,2,3,4,5,6,7]
     * k =
     * 3
     */

    public static void main(String[] args) {
        var a = new int[]{1, 2, 3, 4, 5, 6, 7};
        new rotate189().rotate(a, 3);
        int i = 1;
    }
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        int[] old = Arrays.copyOf(nums, nums.length);
        for(int i = 0; i < l; i++) {
            nums[(i+k)%l] = old[i];
        }
    }
}
