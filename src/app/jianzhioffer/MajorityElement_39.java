package app.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class MajorityElement_39 {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *
     * 示例1:
     *
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     *
     * 限制：
     *
     * 1 <= 数组长度 <= 50000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int t = nums.length/2;
        for (int num : nums) {
            Integer merge = map.merge(num, 1, Integer::sum);
            if(merge > t) return num;
        }

        return -1;
    }
}
