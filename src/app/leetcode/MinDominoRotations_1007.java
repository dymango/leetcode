package app.leetcode;

import app.executor.MainMethod;
import app.executor.MainParam;

/**
 * @author dimmy
 */
public class MinDominoRotations_1007 {
    @MainParam
    int[] tops = new int[]{2, 1, 2, 4, 2, 2};
    @MainParam
    int[] bottoms =  new int[]{5, 2, 6, 2, 3, 2};

    /**
     * 在一排多米诺骨牌中，tops[i] 和 bottoms[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
     * 我们可以旋转第 i 张多米诺，使得 tops[i] 和 bottoms[i] 的值交换。
     * 返回能使 tops 中所有值或者 bottoms 中所有值都相同的最小旋转次数。
     * 如果无法做到，返回 -1.
     * <p>
     * <p>
     * 算法： 算法核心是找到替换的value, 然后返回value值最多的行中非value的槽数
     *
     * @param tops
     * @param bottoms
     * @return
     */
    @MainMethod
    public int minDominoRotations(int[] tops, int[] bottoms) {
        var size = tops.length;
        var a = tops[0];
        var countt = 0;
        var countb = 0;
        var result = true;
        for (int i = 0; i < size; i++) {
            if (tops[i] != a && bottoms[i] != a) {
                result = false;
                break;
            }
            if (tops[i] != a && bottoms[i] == a) countt++;
            if (bottoms[i] != a && tops[i] == a) countb++;
        }

        if (result) return Math.min(countb, countt);

        a = bottoms[0];
        countt = 0;
        countb = 0;
        result = true;
        for (int i = 0; i < size; i++) {
            if (tops[i] != a && bottoms[i] != a) {
                result = false;
                break;
            }
            if (tops[i] != a && bottoms[i] == a) countt++;
            if (bottoms[i] != a && tops[i] == a) countb++;
        }

        if (result) return Math.min(countb, countt);
        return -1;
    }
}
