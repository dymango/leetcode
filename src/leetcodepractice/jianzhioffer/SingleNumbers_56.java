package leetcodepractice.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 */
public class SingleNumbers_56 {

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     *
     * 示例 1：
     *
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     * 示例 2：
     *
     * 输入：nums = [1,2,10,4,1,4,3,3]
     * 输出：[2,10] 或 [10,2]
     *  
     *
     * 限制：
     *
     * 2 <= nums.length <= 10000
     *
     *  answer
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }

        int[] r = new int[2];
        int index = 0;
        for (Integer integer : set) {
            r[index++] = integer;
        }
        return r;
    }
}
