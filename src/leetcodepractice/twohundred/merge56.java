package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class merge56 {

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     * <p>
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * @param intervals
     * @return
     */
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
