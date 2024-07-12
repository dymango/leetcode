package leetcodepractice;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

import java.util.Arrays;

/**
 * @author dimmy
 * start: 15:32
 * end: 16:15
 */
public class videoStitching_1024 {

    /**
     * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 time 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
     * 使用数组 clips 描述所有的视频片段，其中 clips[i] = [starti, endi] 表示：某个视频片段开始于 starti 并于 endi 结束。
     * 甚至可以对这些片段自由地再剪辑：
     * 例如，片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
     * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, time]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
     * <p>
     * 示例 1：
     * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
     * 输出：3
     * 解释：
     * 选中 [0,2], [8,10], [1,9] 这三个片段。
     * 然后，按下面的方案重制比赛片段：
     * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
     * 现在手上的片段为 [0,2] + [2,8] + [8,10]，而这些覆盖了整场比赛 [0, 10]。
     *
     * @param clips
     * @param time
     * @return 贪心？
     */
    @MainParam
//    int[][] arr = {{8, 10}, {17, 39}, {18, 19}, {8, 16}, {13, 35}, {33, 39}, {11, 19}, {18, 35}};
    //    int[][] arr = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
    int[][] arr = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
    @MainParam
    int time = 10;


    public int videoStitching(int[][] clips, int time) {
        var list = Arrays.stream(clips).sorted((o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }

            return -1;
        }).toList();

        if (list.getLast()[1] < time) return -1;
        var size = list.size();
        int count = 0;
        int pre = time;
        int start = size - 1;
        while (start >= 0) {
            int tempP = pre;
            int index = start;
            while (index >= 0) {
                var arr = list.get(index);
                if (arr[1] < pre) {
                    if (index == start) return -1;
                    break;
                }

                tempP = Math.min(tempP, arr[0]);
                index--;
            }

            var a = list.get(index + 1);
            if (a[1] < pre) return -1;
            pre = tempP;
            start = index;
            count++;
            if (pre == 0) return count;
        }

        if (pre != 0) return -1;
        return count;
    }

    @MainMethod
    public int videoStitchingv2(int[][] clips, int time) {
        var list = Arrays.stream(clips).sorted((o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }

            return -1;
        }).toList();
        var size = list.size();
        int i = size - 1;
        int count = 0;
        int left = time, right = time;
        while (i >= 0) {
            var arr = list.get(i);
            if (arr[1] >= right) {
                left = Math.min(left, arr[0]);
                i--;
            } else {
                right = left;
                count++;
                if(arr[1] < right) break;
            }

            if(arr[0] == 0) return count + 1;
        }

        if(left != 0) return -1;
        return count + 1;
    }
}
