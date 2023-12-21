package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class findPeakElement_162 {
    /**
     * 峰值元素是指其值严格大于左右相邻值的元素。
     * <p>
     * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * <p>
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     * <p>
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     *
     * 我们可以发现，如果 nums[i]<nums[i+1]\textit{nums}[i] < \textit{nums}[i+1]nums[i]<nums[i+1]，并且我们从位置 iii 向右走到了位置 i+1i+1i+1，那么位置 iii 左侧的所有位置是不可能在后续的迭代中走到的。
     *
     * 这是因为我们每次向左或向右移动一个位置，要想「折返」到位置 iii 以及其左侧的位置，我们首先需要在位置 i+1i+1i+1 向左走到位置 iii，但这是不可能的。
     *
     * 并且根据方法二，我们知道位置 i+1i+1i+1 以及其右侧的位置中一定有一个峰值，因此我们可以设计出如下的一个算法：
     *
     * 对于当前可行的下标范围 [l,r][l, r][l,r]，我们随机一个下标 iii；
     *
     * 如果下标 iii 是峰值，我们返回 iii 作为答案；
     *
     * 如果 nums[i]<nums[i+1]\textit{nums}[i] < \textit{nums}[i+1]nums[i]<nums[i+1]，那么我们抛弃 [l,i][l, i][l,i] 的范围，在剩余 [i+1,r][i+1, r][i+1,r] 的范围内继续随机选取下标；
     *
     * 如果 nums[i]>nums[i+1]\textit{nums}[i] > \textit{nums}[i+1]nums[i]>nums[i+1]，那么我们抛弃 [i,r][i, r][i,r] 的范围，在剩余 [l,i−1][l, i-1][l,i−1] 的范围内继续随机选取下标。
     *
     * 在上述算法中，如果我们固定选取 iii 为 [l,r][l, r][l,r] 的中点，那么每次可行的下标范围会减少一半，成为一个类似二分查找的方法，时间复杂度为 O(log⁡n)O(\log n)O(logn)。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/find-peak-element/solutions/998152/xun-zhao-feng-zhi-by-leetcode-solution-96sj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 1) return 0;
        int i = 0;
        while (i < length) {
            int left = i > 0 ? nums[i - 1] : Integer.MIN_VALUE;
            int right = i < length - 1 ? nums[i + 1] : Integer.MIN_VALUE;
            if (nums[i] > left && nums[i] > right) return i;
            if (nums[i] >= right) {
                i = i + 2;
            } else {
                i++;
            }
        }

        return -1;

    }

}