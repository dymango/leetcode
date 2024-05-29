package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class FindShortestSubArray_697 {
    /**
     * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
     * <p>
     * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1, 2, 2, 3, 1]
     * 输出：2
     * 解释：
     * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
     * 连续子数组里面拥有相同度的有如下所示:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * 最短连续子数组[2, 2]的长度为2，所以返回2.
     * 示例 2：
     * <p>
     * 输入：[1,2,2,3,1,4,2]
     * 输出：6
     *  
     * <p>
     * 提示：
     * <p>
     * nums.length 在1到 50,000 区间范围内。
     * nums[i] 是一个在 0 到 49,999 范围内的整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/degree-of-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     *
     * 由于已知值的范围是 [0, 49999]。
     *
     * 我们可以使用数组 cnt 来统计每个值出现的次数，数组 first 和 last 记录每个值「首次出现」和「最后出现」的下标。
     *
     * 同时统计出最大词频为 max。
     *
     * 然后再遍历一次数组，对于那些满足词频为 max 的数值进行长度计算。
     *
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/degree-of-an-array/solution/shu-zu-ji-shu-ha-xi-biao-ji-shu-jie-fa-y-a0mg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int findShortestSubArray(int[] nums) {
        int degree = 0;
        int length = Integer.MAX_VALUE;
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> numStart = new HashMap<>();
        Map<Integer, Integer> numEnd = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            degree = Math.max(countMap.merge(nums[i], 1, Integer::sum), degree);
            Integer integer = numStart.get(nums[i]);
            if(integer == null) {
                numStart.put(nums[i], i);
            } else {
                numEnd.put(nums[i], i);
            }
        }


        if (degree == 1) return 1;
        Set<Integer> duplication = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(duplication.contains(num)) continue;
            if (countMap.get(num) < degree) continue;
            length = Math.min(length, numEnd.get(nums[i]) - numStart.get(nums[i]) + 1);
            duplication.add(nums[i]);
        }

        return length;
    }

    public static void main(String[] args) {
        findShortestSubArray(new int[]{1,2,2,3,1,4,2});
        findShortestSubArray(new int[]{1,2,2,3,1});
    }
}
