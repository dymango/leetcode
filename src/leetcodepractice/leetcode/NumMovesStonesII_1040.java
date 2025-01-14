package leetcodepractice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 */
public class NumMovesStonesII_1040 {

    /**
     * 在 X 轴上有一些不同位置的石子。给定一个整数数组 stones 表示石子的位置。
     * <p>
     * 如果一个石子在最小或最大的位置，称其为 端点石子。每个回合，你可以将一颗 端点石子 拿起并移动到一个未占用的位置，使得该石子不再是一颗 端点石子。
     * <p>
     * 值得注意的是，如果石子像 stones = [1,2,5] 这样，你将 无法 移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。
     * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
     * <p>
     * 以长度为 2 的数组形式返回答案，其中：
     * <p>
     * answer[0] 是你可以移动的最小次数
     * answer[1] 是你可以移动的最大次数。
     *
     * @param stones
     * @return
     *
     */
    public int[] numMovesStonesII(int[] stones) {
        var array = Arrays.stream(stones).sorted().toArray();
        var maxStep = Math.max(array[1] - array[0] - 1, array[2] - array[1] - 1);
        int count = 0;
        while (true) {
            if (array[1] - array[0] > array[2] - array[1]) {
                int newP = (array[2] - array[1]) / 2 + array[1];
                if (newP <= array[1] || newP >= array[2]) break;
                array[0] = array[1];
                array[1] = newP;
            } else {
                int newP = (array[1] - array[0]) / 2 + array[0];
                if (newP <= array[0] || newP >= array[1]) break;
                array[2] = array[1];
                array[1] = newP;
            }

            count++;
        }

        return new int[]{count, maxStep};
    }

    public static void main(String[] args) {
        System.out.println(new NumMovesStonesII_1040().numMovesStonesII(new int[]{7, 4, 9}));
        System.out.println(new NumMovesStonesII_1040().numMovesStonesII(new int[]{6, 5, 4, 3, 10}));
    }
}
