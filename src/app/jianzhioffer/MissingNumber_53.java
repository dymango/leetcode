package app.jianzhioffer;

/**
 * @author dimmy
 */
public class MissingNumber_53 {
    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * 示例 1:
     *
     * 输入: [0,1,3]
     * 输出: 2
     * 示例 2:
     * index 4   v 3
     *  [0,2,3]
     *
     *
     * 输入: [0,1,2,3,3,5,6,7,9]
     * 输出: 8
     *  
     *
     * 限制：
     *
     * 1 <= 数组长度 <= 10000
     *
     * @param nums
     * @return
     */
    public static void main(String[] args) {
        //[]
        System.out.println(new MissingNumber_53().missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49}));
    }
    public int missingNumber(int[] nums) {
        int size = nums.length - 1;
        int start = 0;
        int end = size;
        while (start <= end) {
            if(end - start <= 10) {
                for (int i = start; i <= end; i++) {
                    if(nums[i] == i) continue;
                    return i;
                }

                return end +1;
            }

            int mid = start + (end - start)/2;
            if(mid == nums[mid]) {
                //目标在右侧
                start = mid + 1;
            } else  {
                //目标在左侧
                end = mid - 1;
            }
        }

        return -1;
    }

}
