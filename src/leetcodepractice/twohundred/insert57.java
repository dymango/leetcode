package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class insert57 {

    /**
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
     * <p>
     * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
     * <p>
     * 返回插入之后的 intervals。
     * <p>
     * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var newInte = new int[intervals.length + 1][2];
        for (int i = 0; i < newInte.length - 1; i++) {
            newInte[i] = intervals[i];
        }

        newInte[newInte.length - 1] = newInterval;
        return merge(newInte);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            var compare = Integer.compare(o1[0], o2[0]);
            if (compare == 0) return Integer.compare(o1[1], o2[1]);
            return compare;
        });

        List<int[]> list = new ArrayList<>();
        int start = 0;
        var length = intervals.length;
        while (start < length) {
            var startArr = intervals[start];
            int next = start + 1;
            while (next < length) {
                var interval = intervals[next];
                if (interval[0] <= startArr[1]) {
                    startArr[1] = Math.max(startArr[1], interval[1]);
                } else {
                    break;
                }

                next++;
            }

            list.add(startArr);
            start = next;
        }

        return list.toArray(new int[list.size()][]);
    }
}
