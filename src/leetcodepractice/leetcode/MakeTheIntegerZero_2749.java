package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class MakeTheIntegerZero_2749 {

    /**
     * 给你两个整数：num1 和 num2 。
     * <p>
     * 在一步操作中，你需要从范围 [0, 60] 中选出一个整数 i ，并从 num1 减去 2i + num2 。
     * <p>
     * 请你计算，要想使 num1 等于 0 需要执行的最少操作数，并以整数形式返回。
     * <p>
     * 如果无法使 num1 等于 0 ，返回 -1 。
     * <p>
     * 3
     * 2^i + -2 = 3;
     * 2^i = 5 , i = 2.5
     * <p>
     * 1 -2
     * <p>
     * 1 -
     * <p>
     * 初始0， 可以到达哪些数值
     * n2不变
     * n1
     * <p>
     * 2i + n2 = n1
     * <p>
     * next-n1 =  n1 - (2^i + n2)
     * 3  -2
     * 0 4
     * 1 3
     * 2 1
     * 3 -3
     * 1
     * 3
     * -3
     * <p>
     * 示例 1：
     * <p>
     * 输入：num1 = 3, num2 = -2
     * 输出：3
     * 解释：可以执行下述步骤使 3 等于 0 ：
     * - 选择 i = 2 ，并从 3 减去 22 + (-2) ，num1 = 3 - (4 + (-2)) = 1 。
     * - 选择 i = 2 ，并从 1 减去 22 + (-2) ，num1 = 1 - (4 + (-2)) = -1 。
     * - 选择 i = 0 ，并从 -1 减去 20 + (-2) ，num1 = (-1) - (1 + (-2)) = 0 。
     * 可以证明 3 是需要执行的最少操作数。
     * 示例 2：
     * <p>
     * 输入：num1 = 5, num2 = 7
     * 输出：-1
     * 5 - (2i + 7)
     * 解释：可以证明，执行操作无法使 5 等于 0 。
     *
     * @param num1
     * @param num2
     * @return
     */
    public static void main(String[] args) {
//        System.out.println(new MakeTheIntegerZero_2749().makeTheIntegerZero(3, -2));
        System.out.println(new MakeTheIntegerZero_2749().makeTheIntegerZero(5, 7));
    }

    public int makeTheIntegerZero(int num1, int num2) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        List<Integer> preNumbers = new ArrayList<>();
        preNumbers.add(0);
        while (!preNumbers.isEmpty()) {
            count++;
            if (count > 5) return -1;
            List<Integer> news = new ArrayList<>();
            for (Integer preNumber : preNumbers) {
                for (int i = 0; i <= 60; i++) {
                    var pow = (int) Math.pow(2, i);
                    var x = preNumber + (pow + num2);
                    if (x == num1) return count;
                    if (visited.add(x) && x <= 1000000000) news.add(x);

                }
            }

            preNumbers = news;
        }


        return -1;
    }

}
