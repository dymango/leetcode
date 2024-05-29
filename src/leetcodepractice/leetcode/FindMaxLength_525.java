package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class FindMaxLength_525 {

    /**
     * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [0,1]
     * 输出: 2
     * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
     * 示例 2:
     * <p>
     * 输入: [0,1,0]
     * 输出: 2
     * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
     *  
     * <p>
     * 注意: 给定的二进制数组的长度不会超过50000。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contiguous-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 这道题用到的知识点就是前缀和，类似这种要找相同数量的题目其实都可以用到前缀和，用一个count变量来计算出现的总次数，当出现1则++，出现0则--，相同count数之间的连续数组即为题意所指区间，用一个hashmap来保存count数的位置即可
     *
     * 作者：CharlesGao
     * 链接：https://leetcode-cn.com/problems/contiguous-array/solution/javachao-qing-xi-miao-jie-by-charlesgao/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
    }
}
