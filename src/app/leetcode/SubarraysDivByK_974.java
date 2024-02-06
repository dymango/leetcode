package app.leetcode;

import app.executor.Main;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class SubarraysDivByK_974 {

    /**
     * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
     * 子数组 是数组的 连续 部分。
     * <p>
     * 示例 1：
     * 输入：nums = [4,5,0,-2,-3,1], k = 5
     * 输出：7
     * 解释：
     * 有 7 个子数组满足其元素之和可被 k = 5 整除：
     * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
     * <p>
     * 示例 2:
     * 输入: nums = [5], k = 9
     * 输出: 0
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * 2 <= k <= 104
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int n = Math.floorMod(sum, k);
            Integer orDefault = countMap.getOrDefault(n, 0);
            count += orDefault;
            countMap.merge(n, 1, Integer::sum);
        }

        return count;
    }

    //因此我们可以考虑对数组进行遍历，在遍历同时统计答案。当我们遍历到第 iii 个元素时，我们统计以 iii 结尾的符合条件的子数组个数。我们可以维护一个以前缀和模 kkk 的值为键，出现次数为值的哈希表 record\textit{record}record，在遍历的同时进行更新。这样在计算以 iii 结尾的符合条件的子数组个数时，根据上面的分析，答案即为 [0..i−1][0..i-1][0..i−1] 中前缀和模 kkk 也为 P[i] mod kP[i] \bmod kP[i]modk 的位置个数，即 record[P[i] mod k]\textit{record}[P[i] \bmod k]record[P[i]modk]。
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/subarray-sums-divisible-by-k/solutions/187947/he-ke-bei-k-zheng-chu-de-zi-shu-zu-by-leetcode-sol/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    @Main
    public int subarraysDivByKV2(int[] nums, int k) {
        //nums = [4,5,0,-2,-3,1], k = 5
        //[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % k + k) % k;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int sum = -5;
        int k = 3;
        System.out.println( sum%k);
        System.out.println( Math.floorMod(-7, 2));
        System.out.println( (sum % k + k) % k);
    }
}
