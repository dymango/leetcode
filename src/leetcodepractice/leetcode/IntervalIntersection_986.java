package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class IntervalIntersection_986 {


    /**
     * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。
     * 每个区间列表都是成对 不相交 的，并且 已经排序 。
     * 返回这 两个区间列表的交集 。
     * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
     * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
     * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     * 示例 2：
     * <p>
     * 输入：firstList = [[1,3],[5,9]], secondList = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：firstList = [], secondList = [[4,8],[10,12]]
     * 输出：[]
     * 示例 4：
     * <p>
     * 输入：firstList = [[1,7]], secondList = [[3,10]]
     * 输出：[[3,7]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= firstList.length, secondList.length <= 1000
     * firstList.length + secondList.length >= 1
     * 0 <= starti < endi <= 109
     * endi < starti+1
     * 0 <= startj < endj <= 109
     * endj < startj+1
     *
     * @param firstList
     * @param secondList
     * @return
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> r = new ArrayList<>();
        for (int[] f : firstList) {
            boolean tag = false;
            for (int[] s : secondList) {
                if (f[1] >= s[0] && f[0] <= s[1]) {
                    r.add(new int[]{Math.max(f[0], s[0]), Math.min(f[1], s[1])});
                    tag = true;
                } else if (tag) break;
            }
        }

        return r.toArray(new int[0][0]);
    }
}
