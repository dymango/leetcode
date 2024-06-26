package leetcodepractice.leetcode.tophundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class singleNumber_137 {

    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() == 1) return e.getKey();
        }

        return -1;
    }
}
