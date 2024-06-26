package leetcodepractice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dimmy
 */
public class EraseOverlapIntervals_435 {

    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 注意:
     *
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * 示例 1:
     *
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     *
     * 输出: 1
     *
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * 示例 2:
     *
     * 输入: [ [1,2], [1,2], [1,2] ]
     *
     * 输出: 2
     *
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * 示例 3:
     *
     * 输入: [ [1,2], [2,3] ]
     *
     * 输出: 0
     *
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     *
     * [[1,100],[11,22],[1,11],[2,12]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if(i == 0) continue;
            if(intervals[i][0] < intervals[i-1][1]) {
                count++;
                intervals[i][1] = Math.min(intervals[i-1][1], intervals[i][1]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}});
    }
}
