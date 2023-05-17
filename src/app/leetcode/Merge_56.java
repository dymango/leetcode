package app.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class Merge_56 {

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     * <p>
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/merge-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intervals
     * @return
     */

    public static void main(String[] args) {
        new Merge_56().merge(new int[][]{{1, 4}, {4, 5}});
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int length = intervals.length;
        for (int i = 1; i < length; i++) {
            int[] interval = intervals[i];
            int[] last = list.get(list.size() - 1);
            if (last[1] >= interval[0]) {
                last[1] = Math.max(last[1], interval[1]);
            } else {
                list.add(interval);
            }
        }

        int[][] ints = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] array = list.get(i);
            ints[i][0] = array[0];
            ints[i][1] = array[1];
        }

        return ints;
    }

}
