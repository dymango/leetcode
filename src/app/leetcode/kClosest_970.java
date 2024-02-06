package app.leetcode;

import app.executor.Main;

import java.util.PriorityQueue;

/**
 * @author dimmy
 */
public class kClosest_970 {

    /**
     * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
     * <p>
     * 这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
     * <p>
     * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：points = [[1,3],[-2,2]], k = 1
     * 输出：[[-2,2]]
     * 解释：
     * (1, 3) 和原点之间的距离为 sqrt(10)，
     * (-2, 2) 和原点之间的距离为 sqrt(8)，
     * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
     * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
     * 示例 2：
     * <p>
     * 输入：points = [[3,3],[5,-1],[-2,4]], k = 2
     * 输出：[[3,3],[-2,4]]
     * （答案 [[-2,4],[3,3]] 也会被接受。）
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= k <= points.length <= 104
     * -104 < xi, yi < 104
     *
     * @param points
     * @param k
     * @return
     */
    @Main
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1[0]);
            int b = Math.abs(o1[1]);
            int c = Math.abs(o2[0]);
            int d = Math.abs(o2[1]);
            double sqrt = Math.sqrt(a * a + b * b);
            double sqrt2 = Math.sqrt(c * c + d * d);
            return sqrt > sqrt2 ? 1 : sqrt > sqrt2 ? 0 : -1;
        });
        for (int[] point : points) {
            priorityQueue.offer(point);
            if (priorityQueue.size() > 3) priorityQueue.poll();
        }

        int[][] r = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] poll = priorityQueue.poll();
            r[i] = poll;
        }

        return r;
    }
}
