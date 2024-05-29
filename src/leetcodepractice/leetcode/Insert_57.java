package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class Insert_57 {

    /**
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * <p>
     * 示例 1：
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * 示例 2：
     * <p>
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     * 示例 3：
     * <p>
     * 输入：intervals = [], newInterval = [5,7]
     * 输出：[[5,7]]
     * 示例 4：
     * <p>
     * 输入：intervals = [[1,5]], newInterval = [2,3]
     * 输出：[[1,5]]
     * 示例 5：
     * <p>
     * 输入：intervals = [[1,5]], newInterval = [2,7]
     * 输出：[[1,7]]
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= intervals[i][0] <= intervals[i][1] <= 105
     * intervals 根据 intervals[i][0] 按 升序 排列
     * newInterval.length == 2
     * 0 <= newInterval[0] <= newInterval[1] <= 105
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            newArr[i][0] = intervals[i][0];
            newArr[i][1] = intervals[i][1];
        }

        newArr[newArr.length - 1][0] = newInterval[0];
        newArr[newArr.length - 1][1] = newInterval[1];

        Arrays.sort(newArr, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        List<int[]> list = new ArrayList<>();
        list.add(newArr[0]);
        int length = newArr.length;
        for (int i = 1; i < length; i++) {
            int[] interval = newArr[i];
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
