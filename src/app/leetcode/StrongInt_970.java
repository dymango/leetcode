package app.leetcode;

import app.executor.Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class StrongInt_970 {

    /**
     * 给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。
     * <p>
     * 如果某一整数可以表示为 xi + yj ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。
     * <p>
     * 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 2, y = 3, bound = 10
     * 输出：[2,3,4,5,7,9,10]
     * 解释：
     * 2 = 20 + 30
     * 3 = 21 + 30
     * 4 = 20 + 31
     * 5 = 21 + 31
     * 7 = 22 + 31
     * 9 = 23 + 30
     * 10 = 20 + 32
     * 示例 2：
     * <p>
     * 输入：x = 3, y = 5, bound = 15
     * 输出：[2,4,6,8,10,14]
     * <p>
     * 1 <= x, y <= 100
     * 0 <= bound <= 106
     *
     * @param x
     * @param y
     * @param bound
     * @return
     */



    @Main
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> integers = new ArrayList<>();
        List<Integer> integers2 = new ArrayList<>();
        integers.add(1);
        integers.add(x);
        int n = x;
        while (true) {
            n *= x;
            if (n > bound || n == x) break;
            integers.add(n);
        }

        integers2.add(1);
        integers2.add(y);
        n = y;
        while (true) {
            n *= y;
            if (n > bound || n == y) break;
            integers2.add(n);
        }

        Set<Integer> r = new HashSet<>();
        for (Integer integer : integers) {
            for (Integer integer2 : integers2) {
                int sum = integer + integer2;
                if (sum <= bound) {
                    r.add(sum);
                } else {
                    break;
                }
            }
        }

        return new ArrayList<>(r);
    }
}
