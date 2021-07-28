package app.tencent;

/**
 * @author dimmy
 */
public class Merge_88 {

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,3,,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 示例 2：
     *
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     *  
     *
     * 提示：
     *
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[i] <= 109
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if(nums2[i] == nums1[j] || (j == nums1.length - (n - i))) {
                    for (int k = nums1.length - 1; k > j; k--) {
                        nums1[k] = nums1[k - 1];
                    }

                    nums1[j] = nums2[i];
                    break;
                } else if(nums2[i] < nums1[j]) {
                    for (int k = nums1.length - 1; k > j; k--) {
                        nums1[k] = nums1[k - 1];
                    }

                    nums1[j] = nums2[i];
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Merge_88 merge_88 = new Merge_88();
//        merge_88.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        merge_88.merge(new int[]{4,5,6,0,0,0}, 3, new int[]{1,2,3}, 3);
        //[4,5,6,0,0,0]
        //3
        //[1,2,3]
        //3
    }
}
