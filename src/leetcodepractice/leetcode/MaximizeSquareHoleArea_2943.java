package leetcodepractice.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class MaximizeSquareHoleArea_2943 {

    /**
     * 给你一个网格图，由 n + 2 条 横线段 和 m + 2 条 竖线段 组成，一开始所有区域均为 1 x 1 的单元格。
     * <p>
     * 所有线段的编号从 1 开始。
     * <p>
     * 给你两个整数 n 和 m 。
     * <p>
     * 同时给你两个整数数组 hBars 和 vBars 。
     * <p>
     * hBars 包含区间 [2, n + 1] 内 互不相同 的横线段编号。
     * vBars 包含 [2, m + 1] 内 互不相同的 竖线段编号。
     * 如果满足以下条件之一，你可以 移除 两个数组中的部分线段：
     * <p>
     * 如果移除的是横线段，它必须是 hBars 中的值。
     * 如果移除的是竖线段，它必须是 vBars 中的值。
     * 请你返回移除一些线段后（可能不移除任何线段），剩余网格图中 最大正方形 空洞的面积，正方形空洞的意思是正方形 内部 不含有任何线段
     *
     * @param n
     * @param m
     * @param hBars
     * @param vBars
     * @return
     */
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hm = 1;
        int vm = 1;
        int hMaxContinuous = 1;
        int vMaxContinuous = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                hMaxContinuous++;
            } else {
                hMaxContinuous = 1;
            }
            hm = Math.max(hm, hMaxContinuous);
        }


        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                vMaxContinuous++;
            } else {
                vMaxContinuous = 1;
            }

            vm = Math.max(vm, vMaxContinuous);
        }

        int min = Math.min(hm + 1, vm + 1);
        return min * min;
    }
}
