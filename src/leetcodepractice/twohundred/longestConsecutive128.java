package leetcodepractice.twohundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestConsecutive128 {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (Integer i : set) {
            if(!set.contains(i - 1)) {
                int maxlen = 0;
                int target =i;
                while (set.contains(target)) {
                    target++;
                    maxlen++;
                }
                max = Math.max(max, maxlen);

            }
        }

        return max;
    }
}
