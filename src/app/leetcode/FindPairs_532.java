package app.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class FindPairs_532 {

    /**
     * 给定一个整数数组和一个整数 k，你需要在数组里找到不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
     *
     * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
     *
     * 0 <= i, j < nums.length
     * i != j
     * |nums[i] - nums[j]| == k
     * 注意，|val| 表示 val 的绝对值。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [3, 1, 4, 1, 5], k = 2
     * 输出：2
     * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     * 示例 2：
     *
     * 输入：nums = [1, 2, 3, 4, 5], k = 1
     * 输出：4
     * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     * 示例 3：
     *
     * 输入：nums = [1, 3, 1, 5, 4], k = 0
     * 输出：1
     * 解释：数组中只有一个 0-diff 数对，(1, 1)。
     * 示例 4：
     *
     * 输入：nums = [1,2,4,4,3,3,0,9,2,3], k = 3
     * 输出：2
     * 示例 5：
     *
     * 输入：nums = [-1,-2,-3], k = 1
     * 输出：2
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -107 <= nums[i] <= 107
     * 0 <= k <= 107
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int[] cache = new int[108];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            cache[nums[i]]++;
        }

        Map<String, Boolean> marked = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if(k == 0 && cache[num] < 2) continue;
            String key = num + k > num ? (num + k) + "," + num: num  + "," + (num + k);
            if(set.contains(num + k) && marked.get(key) == null) {
                count++;
                marked.put(key, true);
            }

            String key2 = num - k > num ? (num - k) + "," + num : num + "," + (num - k);
            if(set.contains(num - k) && marked.get(key2) == null) {
                count++;
                marked.put(key2, true);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(  findPairs(new int[]{3,1,4,1,5}, 0));
    }
}
