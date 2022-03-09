package app.leetcode;

/**
 * @author dimmy
 */
public class LengthOfLIS_300 {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     *  
     * 示例 1：
     * 10
     * 9
     * 2
     * 25
     * 256
     * 2 3 101
     * <p>
     * <p>
     * 输入：nums = [10,9,2,5,6,3,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * 0
     * 01
     * 013
     * 012
     * 0123
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return 考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
     * <p>
     * 基于上面的贪心思路，我们维护一个数组 d[i]d[i] ，表示长度为 ii 的最长上升子序列的末尾元素的最小值，用 \textit{len}len 记录目前最长上升子序列的长度，起始时 lenlen 为 11，d[1] = \textit{nums}[0]d[1]=nums[0]。
     * <p>
     * 同时我们可以注意到 d[i]d[i] 是关于 ii 单调递增的。因为如果 d[j] \geq d[i]d[j]≥d[i] 且 j < ij<i，我们考虑从长度为 ii 的最长上升子序列的末尾删除 i-ji−j 个元素，那么这个序列长度变为 jj ，且第 jj 个元素 xx（末尾元素）必然小于 d[i]d[i]，也就小于 d[j]d[j]。那么我们就找到了一个长度为 jj 的最长上升子序列，并且末尾元素比 d[j]d[j] 小，从而产生了矛盾。因此数组 dd 的单调性得证。
     * <p>
     * 我们依次遍历数组 \textit{nums}nums 中的每个元素，并更新数组 dd 和 lenlen 的值。如果 \textit{nums}[i] > d[\textit{len}]nums[i]>d[len] 则更新 len = len + 1len=len+1，否则在 d[1 \ldots len]d[1…len]中找满足 d[i - 1] < \textit{nums}[j] < d[i]d[i−1]<nums[j]<d[i] 的下标 ii，并更新 d[i] = \textit{nums}[j]d[i]=nums[j]。
     * <p>
     * 根据 dd 数组的单调性，我们可以使用二分查找寻找下标 ii，优化时间复杂度。
     * <p>
     * 最后整个算法流程为：
     * <p>
     * 设当前已求出的最长上升子序列的长度为 \textit{len}len（初始时为 11），从前往后遍历数组 \textit{nums}nums，在遍历到 \textit{nums}[i]nums[i] 时：
     * <p>
     * 如果 \textit{nums}[i] > d[\textit{len}]nums[i]>d[len] ，则直接加入到 dd 数组末尾，并更新 \textit{len} = \textit{len} + 1len=len+1；
     * <p>
     * 否则，在 dd 数组中二分查找，找到第一个比 \textit{nums}[i]nums[i] 小的数 d[k]d[k] ，并更新 d[k + 1] = \textit{nums}[i]d[k+1]=nums[i]。
     * <p>
     * 以输入序列 [0, 8, 4, 12, 2][0,8,4,12,2] 为例：
     * <p>
     * 第一步插入 00，d = [0]d=[0]；
     * <p>
     * 第二步插入 88，d = [0, 8]d=[0,8]；
     * <p>
     * 第三步插入 44，d = [0, 4]d=[0,4]；
     * <p>
     * 第四步插入 1212，d = [0, 4, 12]d=[0,4,12]；
     * <p>
     * 第五步插入 22，d = [0, 2, 12]d=[0,2,12]。
     * <p>
     * 最终得到最大递增子序列长度为 33。
     * <p>
     * JavaC++Python3
     */
    public int lengthOfLIS(int[] nums) {
        int[] sublist = new int[nums.length];
        int max = 0;
        sublist[0] = nums[0];
        int l = nums.length;
        for (int i = 1; i < l; i++) {
            if (nums[i] > sublist[max]) {
                max += 1;
                sublist[max] = nums[i];
            } else if ((nums[i] < sublist[max])) {
                int index = findIndex(sublist, max, nums[i]);
                sublist[index] = nums[i];
            }
        }

        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS_300().lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    private int findIndex(int[] sublist, int max, int t) {
        int start = 0;
        int end = max;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (sublist[mid] > t) {
                end = mid;
            } else if (sublist[mid] < t) {
                start = mid + 1;
            } else return mid;

            if(start == end) return start;
        }

        return end;
    }
}
