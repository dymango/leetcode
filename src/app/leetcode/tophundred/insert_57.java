package app.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class insert_57 {

    /**
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * 示例 2：
     * <p>
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
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
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= intervals[i][0] <= intervals[i][1] <= 105
     * intervals 根据 intervals[i][0] 按 升序 排列
     * newInterval.length == 2
     * 0 <= newInterval[0] <= newInterval[1] <= 105
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int index = 0;
        int length = intervals.length;
        boolean insert = false;
        while (index < length) {
            int[] arr = intervals[index];
            if (insert) {
                list.add(arr);
                index++;
                continue;
            }

            if (newInterval[1] < arr[0]) {
                insert = true;
                list.add(newInterval);
            } else if (newInterval[0] > arr[1]) {
                list.add(arr);
                index++;
            } else {
                arr[0] = Math.min(arr[0], newInterval[0]);
                arr[1] = Math.max(arr[1], newInterval[1]);
                int next = index + 1;
                while (next < length && arr[1] >= intervals[next][0]) {
                    arr[1] = Math.max(arr[1], intervals[next][1]);
                    next++;
                }

                list.add(arr);
                insert = true;
                index = next;
            }
        }

        if(!insert) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        new insert_57().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
    }
}
