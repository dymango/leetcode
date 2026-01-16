package leetcodepractice.leetcode;

import leetcodepractice.core.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class MaximizeSquareArea_2975 {

    /**
     * 有一个大型的 (m - 1) x (n - 1) 矩形田地，其两个对角分别是 (1, 1) 和 (m, n) ，田地内部有一些水平栅栏和垂直栅栏，分别由数组 hFences 和 vFences 给出。
     * 水平栅栏为坐标 (hFences[i], 1) 到 (hFences[i], n)，垂直栅栏为坐标 (1, vFences[i]) 到 (m, vFences[i]) 。
     * 返回通过 移除 一些栅栏（可能不移除）所能形成的最大面积的 正方形 田地的面积，或者如果无法形成正方形田地则返回 -1。
     * 由于答案可能很大，所以请返回结果对 109 + 7 取余 后的值。
     * <p>
     * 注意：田地外围两个水平栅栏（坐标 (1, 1) 到 (1, n) 和坐标 (m, 1) 到 (m, n) ）以及两个垂直栅栏（坐标 (1, 1) 到 (m, 1) 和坐标 (1, n) 到 (m, n) ）所包围。这些栅栏 不能 被移除。
     *
     * @param m
     * @param n
     * @param hFences
     * @param vFences
     * @return
     */
    class Solution {
        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            Set<Integer> hEdges = getEdges(hFences, m);
            Set<Integer> vEdges = getEdges(vFences, n);

            long res = 0;
            for (int e : hEdges) {
                if (vEdges.contains(e)) {
                    res = Math.max(res, e);
                }
            }

            if (res == 0) {
                return -1;
            } else {
                return (int)((res * res) % 1000000007);
            }
        }

        private Set<Integer> getEdges(int[] fences, int border) {
            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();

            for (int fence : fences) {
                list.add(fence);
            }

            list.add(1);
            list.add(border);
            Collections.sort(list);

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    set.add(list.get(j) - list.get(i));
                }
            }

            return set;
        }
    }


}
