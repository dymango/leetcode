package leetcodepractice.tencent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class FindMedianSortedArrays_4 {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     * <p>
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     * <p>
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     * <p>
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *  
     * <p>
     * 提示：
     * <p>
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     *  
     * <p>
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param nums2
     * @return
     *
     * 二分查找
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> cache = new HashMap<>();
        Map<Integer, Integer> preNumMap = new HashMap<>();
        Map<Integer, Integer> cache2 = new HashMap<>();
        Map<Integer, Integer> preNumMap2 = new HashMap<>();
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            map.merge(n, 1, Integer::sum);
            if(cache.containsKey(n)) continue;
            while (k < nums2.length) {
                int temp = nums2[k];
                if (temp >= n) break;
                preNumMap.put(n, temp);
                k++;
            }

            cache.put(n, k);
        }

        k = 0;
        for (int i = 0; i < nums2.length; i++) {
            int n = nums2[i];
            map2.merge(n, 1, Integer::sum);
            if(cache2.containsKey(n)) continue;
            while (k < nums1.length) {
                int temp = nums1[k];
                if (temp >= n) break;
                preNumMap2.put(n, temp);
                k++;
            }

            cache2.put(n, k);
        }

        int total = nums1.length + nums2.length;
        //result in nums1
        int start = 0;
        int end = nums1.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int tempC = middle + cache.getOrDefault(nums1[middle], 0);
            if (tempC == total / 2) {
                if (total % 2 == 0) {
                    return (double) (nums1[middle] + (Math.max(preNumMap.getOrDefault(nums1[middle], 0), middle > 0 ? nums1[middle - 1] : 0))) / 2;
                } else {
                    return nums1[middle];
                }
            }

            //total 5   tempC need 2
            //total 6   tempC need 3
            if (tempC > total / 2) {
                end = middle - 1;
            } else if (tempC < total / 2) {
                tempC += map2.getOrDefault(nums1[middle], 0);
                if (tempC >= total / 2) {
                    return nums1[middle];
                } else {
                    start = middle + 1;
                }
            }
        }

        start = 0;
        end = nums2.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int tempC = middle + cache2.getOrDefault(nums2[middle], 0);
            if (tempC == total / 2) {
                if (total % 2 == 0) {
                    return (double) (nums2[middle] + (Math.max(preNumMap2.getOrDefault(nums2[middle], 0), middle > 0 ? nums2[middle - 1] : 0))) / 2;
                } else {
                    return nums2[middle];
                }
            }
            //total 5   tempC need 2
            //total 6   tempC need 3
            if (tempC > total / 2) {
                end = middle - 1;
            } else if (tempC < total / 2) {
                tempC += map.getOrDefault(nums2[middle], 0);
                if (tempC >= total / 2) {
                    return nums2[middle];
                } else {
                    start = middle + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays_4 findMedianSortedArrays_4 = new FindMedianSortedArrays_4();
        System.out.println(findMedianSortedArrays_4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays_4.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println(findMedianSortedArrays_4.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays_4.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays_4.findMedianSortedArrays(new int[]{}, new int[]{0}));
        System.out.println(findMedianSortedArrays_4.findMedianSortedArrays(new int[]{2,2,4,4}, new int[]{2,2,4,4}));
        System.out.println(findMedianSortedArrays_4.findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 1}));
        System.out.println(findMedianSortedArrays_4.findMedianSortedArrays(new int[]{1,1,1,1,1,1,1,1,1,1,4,4}, new int[]{1,3,4,4,4,4,4,4,4,4,4}));
        //1,1,1,1,1,1,1,1,1,1,1,  3  ,  4,4,4,4,4,4,4,4,4,4,4
    }
}
