package leetcodepractice.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class SmallestDistancePair_719 {

    /**
     * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
     * <p>
     * 示例 1:
     * <p>
     * 输入：
     * nums = [1,3,1]
     * k = 1
     * 输出：0
     * 解释：
     * 所有数对如下：
     * (1,3) -> 2
     * (1,1) -> 0
     * (3,1) -> 2
     * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
     * 提示:
     * <p>
     * 2 <= len(nums) <= 10000.
     * 0 <= nums[i] < 1000000.
     * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 这道题略难，不过仔细分析弄懂后会发现代码结构比较简单，题目中条件里写的len(nums)<=10000，也就是说数据量为10的4次方，那么时间复杂度上O(n2)基本是超时的，O(n)基本不可能，所以想到O(nlogn)，顺势也就能基本猜出用的是二分法，下面是二分法的具体实现
     * <p>
     * 首先需要对数组排序，这样能很快找出最大距离对，也就是nums[len-1]-nums[0]，然后我们知道第k小的距离对一定会在最大和最小距离对之间，
     * 一般这种范围查找用到的就是二分查找，核心是中间那一段for循环代码，mid指的是中间的距离对的长度，left和right分别是nums上的左右指针，
     * 通过while循环来将所有<=mid的距离对的个数算出来，并加到count中，如果count>=k，那么right=mid，如果count<k，那么left=mid+1；
     * 这里是二分查找的常规模板（因为计算mid时除以2是向下取整的，所以count<k时，目标值一定在mid右边，反之count>=k，可能目标值就是mid或者在左边；
     * 如果对这点始终有疑问，可以去看看探索里的二分查找模板~）
     * <p>
     * <p>
     * class Solution {
     * public int smallestDistancePair(int[] nums, int k) {
     * Arrays.sort(nums);
     * int len=nums.length;
     * int low=0;
     * int high=nums[len-1]-nums[0];
     * <p>
     * 6   1     2
     * <p>
     * while(low<high){
     * int mid=low+(high-low)/2;
     * int count=0;
     * int left=0;
     * for(int right=0; right<len; right++){
     * while(nums[right]-nums[left]>mid) left++;
     * count+=right-left;
     * }
     * <p>
     * if(count>=k){
     * high=mid;
     * }else{
     * low=mid+1;
     * }
     * }
     * return low;
     * }
     * }
     * <p>
     * 作者：CharlesGao
     * 链接：https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/solution/javajian-ji-qing-xi-si-lu-shi-xian-er-fen-fa-by-ch/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int low = 0;
        int high = nums[len - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < len; right++) {
                while (nums[right] - nums[left] > mid) left++;
                count += right - left;
            }

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        smallestDistancePair(new int[]{1, 3, 1}, 1);
//        smallestDistancePair(new int[]{1,1,1}, 2);
    }
}
