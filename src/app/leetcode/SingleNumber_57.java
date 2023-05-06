package app.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 */
public class SingleNumber_57 {
    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     *  
     * <p>
     * 限制：
     * <p>
     * 1 <= nums.length <= 10000
     * 1 <= nums[i] < 2^31
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> multipleSet = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) multipleSet.add(num);
            else set.add(num);
        }

        for (Integer integer : set) {
            if(!multipleSet.contains(integer)) return integer;
        }

        return -1;
    }

}
