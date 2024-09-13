package leetcodepractice.twohundred;

import leetcodepractice.core.LeetCode;

/**
 * @author dimmy
 */
public class findKthLargest215 {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,1,5,6,4], k = 2
     * 输出: 5
     * 示例 2:
     * <p>
     * 输入: [3,2,3,1,2,4,5,5,6], k = 4
     * 输出: 4
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     * @param nums
     * @param k
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new findKthLargest215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new findKthLargest215().findKthLargest(new int[]{-1, 2,0}, 1));
        System.out.println(new findKthLargest215().findKthLargest(new int[]{-1, -1}, 2));

    }

    public int findKthLargest(int[] nums, int k) {
        var center = findCenter(nums, 0, nums.length - 1);
        var width = nums.length - center - 1;
        int target = nums.length - k;
        if(target == center) return nums[center];
        if (center < target) {
            var newArr = new int[width];
            System.arraycopy(nums, center + 1, newArr, 0, width);
            return findKthLargest(newArr, k);
        } else {
            var newArr = new int[center];
            System.arraycopy(nums, 0, newArr, 0, center);
            return findKthLargest(newArr, k - width - 1);
        }
    }

    private int findCenter(int[] nums, int start, int end) {
        int tag = nums[start];
        int s = start + 1;
        int e = end;
        while (s < e) {
            while (s < nums.length && nums[s] < tag) s++;
            while (e >= 0 && nums[e] > tag) e--;
            if (s < e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            } else {
                break;
            }
        }

        if(nums[e] < nums[start]) {
            int temp = nums[start];
            nums[start] = nums[e];
            nums[e] = temp;
        }

        return e;
    }

//    int quickselect(int[] nums, int l, int r, int k) {
//        if (l == r) return nums[k];
//        int x = nums[l], i = l - 1, j = r + 1;
//        while (i < j) {
//            do i++; while (nums[i] < x);
//            do j--; while (nums[j] > x);
//            if (i < j){
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//            }
//        }
//        if (k <= j) return quickselect(nums, l, j, k);
//        else return quickselect(nums, j + 1, r, k);
//    }
//    public int findKthLargest(int[] _nums, int k) {
//        int n = _nums.length;
//        return quickselect(_nums, 0, n - 1, n - k);
//    }
}
