package leetcodepractice.leetcode;

import leetcodepractice.core.UnResolve;

/**
 * @author dimmy
 */
@UnResolve(type = "UniquePathsIII_980")
public class UniquePathsIII_980 {

    /**
     * 在二维网格 grid 上，有 4 种类型的方格：
     *
     * 1 表示起始方格。且只有一个起始方格。
     * 2 表示结束方格，且只有一个结束方格。
     * 0 表示我们可以走过的空方格。
     * -1 表示我们无法跨越的障碍。
     * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
     *
     * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
     * 示例 1：
     *
     * 输入：[[1,0,0,0],
     *       [0,0,0,0],
     *       [0,0,2,-1]]
     * 输出：2
     * 解释：我们有以下两条路径：
     * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
     * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
     *
     * @param grid
     * @return
     */
    public int uniquePathsIII(int[][] grid) {
        return 1;
    }
}
