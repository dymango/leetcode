package app.leetcode;

/**
 * @author dimmy
 */
public class FindPaths_576 {

    /**
     * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: m = 2, n = 2, N = 2, i = 0, j = 0
     * 输出: 6
     * 解释:
     * <p>
     * 示例 2：
     * <p>
     * 输入: m = 1, n = 3, N = 3, i = 0, j = 1
     * 输出: 12
     * 解释:
     * <p>
     *  
     * <p>
     * 说明:
     * <p>
     * 球一旦出界，就不能再被移动回网格内。
     * 网格的长度和高度在 [1,50] 的范围内。
     * N 在 [0,50] 的范围内。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param m
     * @param n
     * @param N
     * @param i
     * @param j
     * @return
     */


    /**
     * 解题思路
     * 令f(i,j,N)是位于i，j,总共有N步的总数。
     * 那么向左走一步就是f(i-1,j,N-1)。
     * <p>
     * 这里关键在于可以向四个方向走，
     * <p>
     * 所以状态转移方程就是把四个方向上的加起来的总和：
     * f(i,j,N) = f(i+1,j,N-1)+f(i-1,j,N-1)+f(i,j+1,N-1)+f(i,j-1,N-1);
     * 翻译成代码如下：
     * <p>
     * 作者：wai-guo-rou-jia-mo
     * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths/solution/dai-ji-yi-de-dong-tai-gui-hua-4msji-bai-95-by-wai-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param m
     * @param n
     * @param N
     * @param i
     * @param j
     * @return
     */
   static int row;
   static int col;
   static int modularity = 1000000007;
   static Long[][][] marked;
    public static int findPaths(int m, int n, int N, int i, int j) {
        row = m;
        col = n;
        marked = new Long[N + 1][row][col];
        return (int)(dfs(i, j, N)%modularity);
    }

    public static Long dfs(int i, int j, int step) {
        if (step < 0) return 0L;
        if (step == 0) {
            if (i < 0 || j < 0 || i >= row || j >= col) return 1L;
            return 0L;
        }

        if (i < 0 || j < 0 || i >= row || j >= col) return 1L;
        if (marked[step][i][j] != null) return marked[step][i][j];
        long count = (dfs(i + 1, j, step - 1)
                + dfs(i, j + 1, step - 1)
                + dfs(i - 1, j, step - 1)
                + dfs(i, j - 1, step - 1))%modularity;
        marked[step][i][j] = count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPaths(2,2,2,0,0));
    }
}
