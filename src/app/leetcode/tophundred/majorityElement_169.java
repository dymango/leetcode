package app.leetcode.tophundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class majorityElement_169 {

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer merge = map.merge(num, 1, Integer::sum);
            if(merge > nums.length/2) return num;
        }

        return -1;
    }
}
