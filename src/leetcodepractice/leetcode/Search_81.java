package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class Search_81 {

    /**
     * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
     * <p>
     * 你必须尽可能减少整个操作步骤。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,5,6,0,0,1,2], target = 0
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：nums = [2,5,6,0,0,1,2], target = 3
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -104 <= target <= 104
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
     * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
     * <p>
     * 对于数组中有重复元素的情况，二分查找时可能会有 a[l]=a[mid]=a[r]a[l]=a[\textit{mid}]=a[r]a[l]=a[mid]=a[r]，此时无法判断区间 [l,mid][l,\textit{mid}][l,mid] 和区间 [mid+1,r][\textit{mid}+1,r][mid+1,r] 哪个是有序的。
     * <p>
     * 例如 nums=[3,1,2,3,3,3,3]\textit{nums}=[3,1,2,3,3,3,3]nums=[3,1,2,3,3,3,3]，target=2\textit{target}=2target=2，首次二分时无法判断区间 [0,3][0,3][0,3] 和区间 [4,6][4,6][4,6] 哪个是有序的。
     * <p>
     * 对于这种情况，我们只能将当前二分区间的左边界加一，右边界减一，然后在新区间上继续二分查找。
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/solutions/704686/sou-suo-xuan-zhuan-pai-xu-shu-zu-ii-by-l-0nmp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) return true;
            if (nums[start] == nums[middle] && nums[middle] == nums[end]) {
                ++start;
                --middle;
                continue;
            }
            if (nums[middle] >= nums[start]) {
                if (target >= nums[start] && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if (target > nums[middle] && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }

        return false;
    }
}
