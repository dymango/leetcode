package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author dimmy
 */
public class SnakesAndLadders_909 {

    /**
     * 给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）每一行交替方向。
     * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
     * 每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：
     * <p>
     * 选定目标方格 next ，目标方格的编号符合范围 [curr + 1, min(curr + 6, n2)] 。
     * 该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
     * 传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。 
     * 当玩家到达编号 n2 的方格时，游戏结束。
     * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。编号为 1 和 n2 的方格上没有蛇或梯子。
     * <p>
     * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
     * <p>
     * 举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3 上的梯子前往方格 4 。
     * 返回达到编号为 n2 的方格所需的最少移动次数，如果不可能，则返回 -1。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
     * 输出：4
     * 解释：
     * 首先，从方格 1 [第 5 行，第 0 列] 开始。
     * 先决定移动到方格 2 ，并必须爬过梯子移动到到方格 15 。
     * 然后决定移动到方格 17 [第 3 行，第 4 列]，必须爬过蛇到方格 13 。
     * 接着决定移动到方格 14 ，且必须通过梯子移动到方格 35 。
     * 最后决定移动到方格 36 , 游戏结束。
     * 可以证明需要至少 4 次移动才能到达最后一个方格，所以答案是 4 。
     * 示例 2：
     * <p>
     * 输入：board = [[-1,-1],[-1,3]]
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * n == board.length == board[i].length
     * 2 <= n <= 20
     * grid[i][j] 的值是 -1 或在范围 [1, n2] 内
     * 编号为 1 和 n2 的方格上没有蛇或梯子
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/snakes-and-ladders
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     * @return
     */
    public static void main(String[] args) {
//        System.out.println(new SnakesAndLadders_909().snakesAndLadders(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}}));
//        System.out.println(new SnakesAndLadders_909().snakesAndLadders(new int[][]{{-1, -1}, {-1, 3}}));
        System.out.println(new SnakesAndLadders_909().snakesAndLadders(new int[][]{{-1, -1}, {-1, 1}}));
    }

    Map<Integer, Integer> locationMap = new HashMap<>();
    int[][] BOARD;
    Set<Integer> tagSet = new HashSet<>();

    public int snakesAndLadders(int[][] board) {
        BOARD = board;
        int row = board.length;
        int col = board[0].length;
        int max = row * col;
        Integer[] dp = new Integer[max + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != -1) {
                    int n = i % 2 == 0 ? (row - i) * col - j : (row - i - 1) * col + j + 1;
                    locationMap.put(board[i][j], n);
                    tagSet.add(n);
                }
            }
        }

        calculateStep(dp, new HashSet<>(), max);
        return dp[max];
    }

    private int calculateStep(Integer[] dp, Set<Integer> set, int target) {
        if (dp[target] != null) return dp[target];
        if (target == 1) return 0;
        int min = Integer.MAX_VALUE;
        int v = Math.max(1, target - 6);
        for (int i = target - 1; i >= v; i--) {
            if (i == 1) {
                min = 0;
                break;
            }

            if (tagSet.contains(i)) continue;
            if (!set.add(i)) continue;
            if (dp[i] == null) {
                if (locationMap.containsKey(i)) {
                    Integer integer = locationMap.get(i);
                    if (!set.add(integer)) continue;
                    min = Math.min(min, calculateStep(dp, set, integer));
                } else {
                    min = Math.min(min, calculateStep(dp, set, i));
                }
            } else {
                min = Math.min(dp[i], min);
            }


            set.remove(i);
        }

        dp[target] = min + 1;
        return dp[target];
    }

    public int snakesAndLaddersV2(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int nxt = p[0] + i;
                if (nxt > n * n) { // 超出边界
                    break;
                }
                int[] rc = id2rc(nxt, n); // 得到下一步的行列
                if (board[rc[0]][rc[1]] > 0) { // 存在蛇或梯子
                    nxt = board[rc[0]][rc[1]];
                }
                if (nxt == n * n) { // 到达终点
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                }
            }
        }
        return -1;
    }

    public int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }

}
