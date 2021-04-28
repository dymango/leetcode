package app.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author dimmy
 */
public class FindKthNumber_668 {

    /**
     * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
     *
     * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
     *
     * 例 1：
     *
     * 输入: m = 3, n = 3, k = 5
     * 输出: 3
     * 解释:
     * 乘法表:
     * 1	2	3
     * 2	4	6
     * 3	6	9
     *
     * 第5小的数字是 3 (1, 2, 2, 3, 3).
     * 例 2：
     *
     * 输入: m = 2, n = 3, k = 6
     * 输出: 6
     * 解释:
     * 乘法表:
     * 1	2	3
     * 2	4	6
     *
     * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
     * 注意：
     *
     * m 和 n 的范围在 [1, 30000] 之间。
     * k 的范围在 [1, m * n] 之间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int findKthNumber(int m, int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                list.add(i * j);
            }
        }

        list.sort(Comparator.comparingInt(o -> o));
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(2,3,6));
        System.out.println(findKthNumber(3,3,5));
    }
}
