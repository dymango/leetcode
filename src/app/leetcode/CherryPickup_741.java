package app.leetcode;

/**
 * @author dimmy
 */
public class CherryPickup_741 {

    /**
     * 一个N x N的网格(grid) 代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
     *
     * 0 表示这个格子是空的，所以你可以穿过它。
     * 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
     * -1 表示这个格子里有荆棘，挡着你的路。
     * 你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
     *
     * 从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
     * 当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
     * 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
     * 如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
     * 示例 1:
     *
     * 输入: grid =
     * [[0, 1, -1],
     *  [1, 0, -1],
     *  [1, 1,  1]]
     * 输出: 5
     * 解释：
     * 玩家从（0,0）点出发，经过了向下走，向下走，向右走，向右走，到达了点(2, 2)。
     * 在这趟单程中，总共摘到了4颗樱桃，矩阵变成了[[0,1,-1],[0,0,-1],[0,0,0]]。
     * 接着，这名玩家向左走，向上走，向上走，向左走，返回了起始点，又摘到了1颗樱桃。
     * 在旅程中，总共摘到了5颗樱桃，这是可以摘到的最大值了。
     * 说明:
     *
     * grid 是一个 N * N 的二维数组，N的取值范围是1 <= N <= 50。
     * 每一个 grid[i][j] 都是集合 {-1, 0, 1}其中的一个数。
     * 可以保证起点 grid[0][0] 和终点 grid[N-1][N-1] 的值都不会是 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cherry-pickup
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public static boolean back = false;
    public static int cherryPickup(int[][] grid) {
        int[] pick = down(grid, 0, 0);
        if(back) return pick[0];
        return 0;
    }

    private static  int[] down(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) return new int[]{0, 0};
        int cur = 0;
        boolean isPick = false;
        if(grid[x][y] == 1) {
            cur = 1;
            grid[x][y] = 0;
            isPick = true;
        }

        int pick = cur;
        if(x == grid.length - 1 && y == grid.length - 1) {
            int[] up = up(grid, x - 1, y);
            int[] left = up(grid, x, y - 1);
            int can = 1;
            if(up[1] == 1) {
                pick = Math.max(pick, cur + up[0]);
                can = 1;
            }
            if(left[1] == 1) {
                pick = Math.max(pick, cur + left[0]);
                can = 1;
            }

            if(isPick) grid[x][y] = 1;
            return new int[]{pick, can};
        }

        int[] down = down(grid, x + 1, y);
        int[] right = down(grid, x, y + 1);
        int can = 0;
        if(down[1] == 1) {
            pick = Math.max(pick, cur + down[0]);
            can = 1;
        }
        if(right[1] == 1) {
            pick = Math.max(pick, cur + right[0]);
            can = 1;
        }

        if(isPick) grid[x][y] = 1;
        return new int[]{pick, can};
    }

    private static int[] up(int[][] grid, int x, int y) {
        back = true;
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) return new int[]{0, 0};
        int cur = 0;
        boolean isPick = false;
        if(grid[x][y] == 1) {
            cur = 1;
            grid[x][y] = 0;
            isPick = true;
        }

        int[] up = up(grid, x - 1, y);
        int[] left = up(grid, x, y - 1);
        int can = (x == 0 && y == 0 ? 1 : 0);
        int pick = cur;
        if(up[1] == 1) {
            pick = Math.max(pick, cur + up[0]);
            can = 1;
        }
        if(left[1] == 1) {
            pick = Math.max(pick, cur + left[0]);
            can = 1;
        }

        if(isPick) grid[x][y] = 1;
        return new int[]{pick, can};
    }

    public static void main(String[] args) {
//        System.out.println(cherryPickup(new int[][]{{0,1,-1}, {1, 0, -1}, {1,1,1}}));
        System.out.println(cherryPickup(new int[][]{{1}}));

    }
}
