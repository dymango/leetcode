package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class findMedianSortedArrays_4 {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * <p>
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
     * <p>
     * <p>
     * 上边的两种思路，时间复杂度都达不到题目的要求 O(log(m+n)O(log(m+n)O(log(m+n)。看到 log，很明显，我们只有用到二分的方法才能达到。我们不妨用另一种思路，题目是求中位数，其实就是求第 k 小数的一种特殊情况，而求第 k 小数有一种算法。
     * <p>
     * 解法二中，我们一次遍历就相当于去掉不可能是中位数的一个值，也就是一个一个排除。由于数列是有序的，其实我们完全可以一半儿一半儿的排除。假设我们要找第 k 小数，我们可以每次循环排除掉 k/2 个数。看下边一个例子。
     * <p>
     * 假设我们要找第 7 小的数字。
     * 我们比较两个数组的第 k/2 个数字，如果 k 是奇数，向下取整。也就是比较第 333 个数字，上边数组中的 444 和下边数组中的 333，如果哪个小，就表明该数组的前 k/2 个数字都不是第 k 小数字，所以可以排除。也就是 111，222，333 这三个数字不可能是第 777 小的数字，我们可以把它排除掉。将 134913491349 和 456789104567891045678910 两个数组作为新的数组进行比较。
     * <p>
     * 更一般的情况 A[1] ，A[2] ，A[3]，A[k/2] ... ，B[1]，B[2]，B[3]，B[k/2] ... ，如果 A[k/2]<B[k/2] ，那么A[1]，A[2]，A[3]，A[k/2]都不可能是第 k 小的数字。
     * <p>
     * A 数组中比 A[k/2] 小的数有 k/2-1 个，B 数组中，B[k/2] 比 A[k/2] 小，假设 B[k/2] 前边的数字都比 A[k/2] 小，也只有 k/2-1 个，所以比 A[k/2] 小的数字最多有 k/1-1+k/2-1=k-2个，所以 A[k/2] 最多是第 k-1 小的数。而比 A[k/2] 小的数更不可能是第 k 小的数了，所以可以把它们排除。
     * <p>
     * 橙色的部分表示已经去掉的数字。
     * <p>
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 作者：windliang
     * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/8999/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int index = 0;
        int[] newNums = new int[length];
        int n1p = 0;
        int n2p = 0;
        while (n1p < nums1.length && n2p < nums2.length) {
            if (nums1[n1p] < nums2[n2p]) {
                newNums[index] = nums1[n1p];
                n1p++;
            } else {
                newNums[index] = nums2[n2p];
                n2p++;
            }

            index++;
        }

        while (n1p < nums1.length) {
            newNums[index] = nums1[n1p];
            n1p++;
            index++;
        }

        while (n2p < nums2.length) {
            newNums[index] = nums2[n2p];
            n2p++;
            index++;
        }

        if (length % 2 == 0) {
            int n = length / 2;
            return (double) (newNums[n] + newNums[n - 1]) / 2;
        } else {
            int n = length / 2;
            return newNums[n];
        }
    }

    public double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 0) {
            int remove = length / 2 - 1;
            int n1s = 0;
            int n2s = 0;
            while (remove > 0) {
                int quota = remove == 1 ? 1 : remove / 2;
                int n1e = quota == 1 ? n1s : n1s + quota;
                if (n1s < nums1.length && n1e >= nums1.length) n1e = nums1.length - 1;
                int n2e = quota == 1 ? n2s : n2s + quota;
                if (n2s < nums2.length && n2e >= nums2.length) n2e = nums2.length - 1;
                if (n1e < nums1.length && n2e < nums2.length) {
                    if (nums1[n1e] > nums2[n2e]) {
                        n2s += quota;
                    } else {
                        n1s += quota;
                    }
                } else if (n1e < nums1.length) {
                    remove -= nums2.length - n2s;
                    int end = n1s + remove;
                    return (double) (nums1[end] + nums1[end + 1]) / 2;
                } else {
                    remove -= nums1.length - n1s;
                    int end = n2s + remove;
                    return (double) (nums2[end] + nums2[end + 1]) / 2;
                }

                remove -= quota;
            }

            if (n1s < nums1.length && n2s < nums2.length) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[n1s]);
                list.add(nums2[n2s]);
                if (n1s + 1 < nums1.length) list.add(nums1[n1s + 1]);
                if (n2s + 1 < nums2.length) list.add(nums2[n2s + 1]);
                list.sort(Integer::compareTo);
                return (double) (list.get(0) + list.get(1)) / 2;
            } else if (n1s < nums1.length) {
                return (double) (nums1[n1s] + nums1[n1s + 1]) / 2;
            } else {
                return (double) (nums2[n2s] + nums2[n2s + 1]) / 2;
            }
        } else {
            int remove = length / 2;
            int n1s = 0;
            int n2s = 0;
            while (remove > 0) {
                int quota = remove == 1 ? 1 : remove / 2;
                int n1e = quota == 1 ? n1s : n1s + quota;
                if (n1s < nums1.length && n1e >= nums1.length) n1e = nums1.length - 1;
                int n2e = quota == 1 ? n2s : n2s + quota;
                if (n2s < nums2.length && n2e >= nums2.length) n2e = nums2.length - 1;
                if (n1e < nums1.length && n2e < nums2.length) {
                    if (nums1[n1e] > nums2[n2e]) {
                        n2s += quota;
                    } else {
                        n1s += quota;
                    }
                } else if (n1e < nums1.length) {
                    remove -= nums2.length - n2s;
                    int end = n1s + remove;
                    return nums1[end];
                } else {
                    remove -= nums1.length - n1s;
                    int end = n2s + remove;
                    return nums2[end];
                }

                remove -= quota;
            }

            if (n1s < nums1.length && n2s < nums2.length) {
                return Math.min(nums1[n1s], nums2[n2s]);
            } else if (n1s < nums1.length) {
                return nums1[n1s];
            } else {
                return nums2[n2s];
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new findMedianSortedArrays_4().findMedianSortedArraysV2(new int[]{1, 2}, new int[]{3, 4}));
//        System.out.println(new findMedianSortedArrays_4().findMedianSortedArraysV2(new int[]{1, 2, 5}, new int[]{3, 4, 6}));
//        System.out.println(new findMedianSortedArrays_4().findMedianSortedArraysV2(new int[]{1, 2,7}, new int[]{3,5}));
//        System.out.println(new findMedianSortedArrays_4().findMedianSortedArraysV2(new int[]{0}, new int[]{0}));
//        System.out.println(new findMedianSortedArrays_4().findMedianSortedArraysV2(new int[]{0}, new int[]{}));
//        System.out.println(new findMedianSortedArrays_4().findMedianSortedArraysV2(new int[]{0}, new int[]{1}));
//        System.out.println(new findMedianSortedArrays_4().findMedianSortedArraysV2(new int[]{1}, new int[]{2, 3, 4, 5, 6, 7, 8, 9}));
//        System.out.println(new findMedianSortedArrays_4().findMedianSortedArraysV2(new int[]{5}, new int[]{1, 2, 3, 4, 6, 7, 8, 9}));
        System.out.println(new findMedianSortedArrays_4().findMedianSortedArraysV2(new int[]{1, 5}, new int[]{2,3,4,6,7,8,9}));
    }
}
