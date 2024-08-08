package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class NumMovesStones_1033 {

    /**
     * 三枚石子放置在数轴上，位置分别为 a，b，c。
     * 每一回合，你可以从两端之一拿起一枚石子（位置最大或最小），并将其放入两端之间的任一空闲位置。形式上，假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。那么就可以从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
     * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
     * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
     * <p>
     * <p>
     * 示例 1：
     * 输入：a = 1, b = 2, c = 5
     * 输出：[1, 2]
     * 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
     * <p>
     * 示例 2：
     * 输入：a = 4, b = 3, c = 2
     * 输出：[0, 0]
     * 解释：我们无法进行任何移动。
     *
     * @param a
     * @param b
     * @param c
     * @return 我们可以假设 x,y,z 分别为从小到大排序后的 a,b,c，来讨论最小和最大移动次数。
     * <p>
     * 当三枚石子连续放置时，即 (y−x)=1 并且 (z−y)=1，不需要额外移动，最小移动次数为 0。
     * 当三枚石子中有两枚是连续放置，或者间隔为 1 时，我们只需对另外一枚石子移动一次，最小移动次数为 1。
     * 对于其他情况，我们最小需要移动 2 次。
     * 对于最多移动次数，我们可以考虑将 x 向右（增加 1），或者将 z 向左（减小 1），每次移动都会使得两侧的距离减小 1，所以最多可以移动 z−x−2 次。
     */
    public int[] numMovesStones(int a, int b, int c) {
        if (c - b == 1 && b - a == 1) return new int[]{0, 0};
        if (c - b == 1) {
            return new int[]{1, b - a - 1};
        }
        if (b - a == 1) {
            return new int[]{1, c - b - 1};
        }

        if(c - b == 2) {
            return new int[]{1, b - a - 1 + 1};
        }
        if(b - a == 2) {
            return new int[]{1, c - b - 1 + 1};
        }

        return new int[]{2, c - b - 1 + b - a - 1};
    }
}
