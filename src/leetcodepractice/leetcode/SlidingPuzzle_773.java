package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class SlidingPuzzle_773 {

    /**
     * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
     * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
     * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
     * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
     * <p>
     * 示例：
     * 输入：board = [[1,2,3],[4,0,5]]
     * 输出：1
     * 解释：交换 0 和 5 ，1 步完成
     * 输入：board = [[1,2,3],[5,4,0]]
     * 输出：-1
     * 解释：没有办法完成谜板
     * 输入：board = [[4,1,2],[5,0,3]]
     * 输出：5
     * 解释：
     * 最少完成谜板的最少移动次数是 5 ，
     * 一种移动路径:
     * 尚未移动: [[4,1,2],[5,0,3]]
     * 移动 1 次: [[4,1,2],[0,5,3]]
     * 移动 2 次: [[0,1,2],[4,5,3]]
     * 移动 3 次: [[1,0,2],[4,5,3]]
     * 移动 4 次: [[1,2,0],[4,5,3]]
     * 移动 5 次: [[1,2,3],[4,5,0]]
     * 输入：board = [[3,2,4],[1,5,0]]
     * 输出：14
     * 提示：
     * <p>
     * board 是一个如上所述的 2 x 3 的数组.
     * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-puzzle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param
     * @return
     */
    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][]{{1,2,3}, {4,0,5}}));
        System.out.println(slidingPuzzle(new int[][]{{1,2,3}, {5,4,0}}));
        System.out.println(slidingPuzzle(new int[][]{{4,1,2}, {5,0,3}}));
    }
   static int[][] target;
   static Map<String, Integer> cache = new HashMap<>();

    public static int slidingPuzzle(int[][] board) {
        target = new int[][]{{1, 2, 3}, {4, 5, 0}};
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[0].length; i1++) {
                if(board[i][i1] == 0) {
                    return change(board, i, i1, new HashSet<>());
                }
            }
        }

        return -1;
    }

    private static int change(int[][] board, int x, int y, Set<String> process) {
        if (board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 && board[1][0] == 4 && board[1][1] == 5 && board[1][2] == 0) {
            return 0;
        }

        String cacheKey = "" + board[0][0] + board[0][1] + board[0][2] + board[1][0] + board[1][1] + board[1][2];
        if(process.contains(cacheKey)) return -1;
        process.add(cacheKey);
        if(cache.containsKey(cacheKey)) return cache.get(cacheKey);
        int min = Integer.MAX_VALUE;
        if (x + 1 >= 0 && x + 1 < 2) {
            int temp = board[x + 1][y];
            board[x + 1][y] = 0;
            board[x][y] = temp;
            int change = change(board, x + 1, y, process);
            if(change != -1) {
                min = Math.min(min, 1 + change);
            }
            board[x + 1][y] = temp;
            board[x][y] = 0;
        }

        if (x - 1 >= 0 && x - 1 < 2) {
            int temp = board[x - 1][y];
            board[x - 1][y] = 0;
            board[x][y] = temp;
            int change = change(board, x - 1, y, process);
            if(change != -1) {
                min = Math.min(min, 1 + change);
            }
            board[x - 1][y] = temp;
            board[x][y] = 0;
        }

        if (y + 1 >= 0 && y + 1 < 3) {
            int temp = board[x][y + 1];
            board[x][y + 1] = 0;
            board[x][y] = temp;
            int change = change(board, x, y + 1, process);
            if(change != -1) {
                min = Math.min(min, 1 + change);
            }
            board[x][y + 1] = temp;
            board[x][y] = 0;
        }

        if (y - 1 >= 0 && y - 1 < 3) {
            int temp = board[x][y - 1];
            board[x][y - 1] = 0;
            board[x][y] = temp;
            int change = change(board, x, y - 1, process);
            if(change != -1) {
                min = Math.min(min, 1 + change);
            }
            board[x][y - 1] = temp;
            board[x][y] = 0;
        }

        min = min == Integer.MAX_VALUE ? -1 : min;
        cache.put(cacheKey, min);
        return min;
    }
}

