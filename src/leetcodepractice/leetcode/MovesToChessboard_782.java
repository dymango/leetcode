package leetcodepractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class MovesToChessboard_782 {
    /**
     * 一个 N x N的 board 仅由 0 和 1 组成 。每次移动，你能任意交换两列或是两行的位置。
     * 输出将这个矩阵变为 “棋盘” 所需的最小移动次数。“棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。如果不存在可行的变换，输出 -1。
     *
     * 示例:
     * 输入: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
     * 输出: 2
     * 解释:
     * 一种可行的变换方式如下，从左到右：
     *
     * 0110     1010     1010
     * 0110 --> 1010 --> 0101
     * 1001     0101     1010
     * 1001     0101     0101
     *
     * 第一次移动交换了第一列和第二列。
     * 第二次移动交换了第二行和第三行。
     *
     *
     * 输入: board = [[0, 1], [1, 0]]
     * 输出: 0
     * 解释:
     * 注意左上角的格值为0时也是合法的棋盘，如：
     *
     * 01
     * 10
     *
     * 也是合法的棋盘.
     *
     * 输入: board = [[1, 0], [1, 0]]
     * 输出: -1
     * 解释:
     * 任意的变换都不能使这个输入变为合法的棋盘。
     *  
     *
     * 提示：
     *
     * board 是方阵，且行列数的范围是[2, 30]。
     * board[i][j] 将只包含 0或 1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/transform-to-chessboard
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param board
     * @return
     */
    public static int movesToChessboard(int[][] board) {
        if(!check(board)) return -1;
        Queue<int[][]> queue = new LinkedList<>();
        queue.offer(board);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[][] poll = queue.poll();
                if(match(poll)) return count;
                for (int j = 0; j < board.length - 1; j++) {
                    queue.offer(exchangeRow(poll, j));
                    queue.offer(exchangeCol(poll, j));
                }
            }

            count++;
        }

        return count;
    }

    private static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            int dif = 0;
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 0) dif++;
                else dif--;
            }

            if(Math.abs(dif) > 1) return false;
        }

        for (int i = 0; i < board.length; i++) {
            int dif = 0;
            for (int j = 0; j < board.length; j++) {
                if(board[j][i] == 0) dif++;
                else dif--;
            }

            if(Math.abs(dif) > 1) return false;
        }

        return true;
    }

    private static int[][] exchangeRow(int[][] board, int row) {
        int[][] newboard = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            if(i == row + 1) continue;
            for (int j = 0; j < board.length; j++) {
                if(i != row && i != row + 1) newboard[i][j] = board[i][j];
                else {
                    if(row == board.length - 1) {
                        for (int k = 0; k < board.length; k++) {
                            newboard[i][k] = board[i][k];
                        }
                    } else {
                        int[] temp = new int[board.length];
                        for (int k = 0; k < board.length; k++) {
                            temp[k] = board[i][k];
                        }

                        for (int k = 0; k < board.length; k++) {
                            newboard[i][k] = board[i + 1][k];
                        }

                        for (int k = 0; k < board.length; k++) {
                            newboard[i + 1][k] = temp[k];
                        }
                    }
                }
            }
        }

        return newboard;
    }

    private static int[][] exchangeCol(int[][] board, int col) {
        int[][] newboard = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(j == col + 1) continue;
                if(j != col && j != col + 1) newboard[i][j] = board[i][j];
                else {
                    if(j == board.length - 1) {
                        for (int k = 0; k < board.length; k++) {
                            newboard[k][j] = board[k][j];
                        }
                    } else {
                        int[] temp = new int[board.length];
                        for (int k = 0; k < board.length; k++) {
                            temp[k] = board[k][j];
                        }

                        for (int k = 0; k < board.length; k++) {
                            newboard[k][j] = board[k][j + 1];
                        }

                        for (int k = 0; k < board.length; k++) {
                            newboard[k][j + 1] = temp[k];
                        }
                    }
                }
            }
        }

        return newboard;
    }


    private static boolean match(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i + 1 < arr.length) {
                    if(arr[i][j] == arr[i + 1][j]) return false;
                }
                if(i - 1 >= 0) {
                    if(arr[i][j] == arr[i - 1][j]) return false;
                }
                if(j + 1 < arr.length) {
                    if(arr[i][j] == arr[i][j + 1]) return false;
                }
                if(j - 1 >= 0) {
                    if(arr[i][j] == arr[i][j - 1]) return false;
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(movesToChessboard(new int[][]{{1,0}, {1,0}}));

    }
}
