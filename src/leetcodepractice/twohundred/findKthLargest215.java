package leetcodepractice.twohundred;

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
//        System.out.println(new findKthLargest215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
//        System.out.println(new findKthLargest215().findKthLargest(new int[]{-1, 2, 0}, 1));
//        System.out.println(new findKthLargest215().findKthLargest(new int[]{-1, -1}, 2));
        System.out.println(new findKthLargest215().findKthLargest(new int[]{3,3,3,3,3,3,3,3,3}, 1));

    }

    public int findKthLargest(int[] nums, int k) {
        var length = nums.length;
        var center = quickSort(nums, 0, length - 1);
        var target = length - k;
        if (center == target) return nums[center];
        var width = length - center - 1;
        if (center < target) {
            int[] newArr = new int[width];
            System.arraycopy(nums, center + 1, newArr, 0, width);
            return findKthLargest(newArr, k);
        }

        int[] newArr = new int[center];
        System.arraycopy(nums, 0, newArr, 0, center);
        return findKthLargest(newArr, k - width - 1);
    }

    int quickSort(int[] nums, int start, int end) {
        if (nums.length < 2) return 0;
        var tag = nums[0];
        int s = start + 1, e = end;
        while (s < e) {
            while (s < nums.length && nums[s] < tag) s++;
            while (e > 0 && nums[e] > tag) e--;
            if (s < e) {
                var t = nums[s];
                nums[s] = nums[e];
                nums[e] = t;
            } else {
                break;
            }

            s++;
            e--;
        }

        if (nums[e] < tag) {
            var t = nums[e];
            nums[e] = nums[0];
            nums[0] = t;
        }

        return e;
    }

}
