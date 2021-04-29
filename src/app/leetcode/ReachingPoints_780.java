package app.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 */
public class ReachingPoints_780 {

    /**
     * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
     * 给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。
     *
     * 示例:
     * 输入: sx = 1, sy = 1, tx = 3, ty = 5
     * 输出: True
     * 解释:
     * 可以通过以下一系列转换从起点转换到终点：
     * (1, 1) -> (1, 2)
     * (1, 2) -> (3, 2)
     * (3, 2) -> (3, 5)
     *
     * 输入: sx = 1, sy = 1, tx = 2, ty = 2
     * 输出: False
     *
     * 输入: sx = 1, sy = 1, tx = 1, ty = 1
     * 输出: True
     *
     * 注意:
     *
     * sx, sy, tx, ty 是范围在 [1, 10^9] 的整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reaching-points
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param sx
     * @param sy
     * @param tx
     * @param ty
     * @return
     */
   static int globalTx, globalTy;
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx > tx || sy > ty) return false;
        if(sx < tx && sy < ty) {
            if (tx > ty) {
                return reachingPoints(sx, sy, tx%ty, ty);
            } else {
                return reachingPoints(sx, sy, tx, ty%tx);
            }

        }

        return ((tx- sx)%sy == 0) && ((ty - sy)%sx == 0);
    }

    private static boolean dfs(int sx, int sy) {
        if(sx > globalTx || sy > globalTy) return false;
        if(sx == globalTx && sy == globalTy) return true;
        boolean delivery = dfs(sx +sy, sy) || dfs(sx, sx + sy);
        if (delivery) return true;
        return false;
    }

    public static void main(String[] args) {
        reachingPoints(35, 13, 45595, 42009);
    }
}
