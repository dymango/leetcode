package leetcodepractice.twohundred;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 */
public class singleNumber137 {

    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
     *
     * @param nums
     * @return
     */

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> r = new HashSet<>();
        for (int num : nums) {
            var add = set.add(num);
            if (!add) {
                r.remove(num);
            } else {
                r.add(num);
            }
        }

        return r.stream().findFirst().get();
    }
}
