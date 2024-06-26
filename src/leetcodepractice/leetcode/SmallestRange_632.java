package leetcodepractice.leetcode;

import java.util.List;

/**
 * @author dimmy
 */
public class SmallestRange_632 {

    /**
     * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
     *
     * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
     * 输出：[20,24]
     * 解释：
     * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
     * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
     * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
     * 示例 2：
     *
     * 输入：nums = [[1,2,3],[1,2,3],[1,2,3]]
     * 输出：[1,1]
     * 示例 3：
     *
     * 输入：nums = [[10,10],[11,11]]
     * 输出：[10,11]
     * 示例 4：
     *
     * 输入：nums = [[10],[11]]
     * 输出：[10,11]
     * 示例 5：
     *
     * 输入：nums = [[1],[2],[3],[4],[5],[6],[7]]
     * 输出：[1,7]
     *  
     *
     * 提示：
     *
     * nums.length == k
     * 1 <= k <= 3500
     * 1 <= nums[i].length <= 50
     * -105 <= nums[i][j] <= 105
     * nums[i] 按非递减顺序排列
     * 通过次数16,115提交次数27,365
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        //todo
        return null;
    }
}
