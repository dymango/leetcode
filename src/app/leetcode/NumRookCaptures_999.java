package app.leetcode;

/**
 * @author dimmy
 */
public class NumRookCaptures_999 {
    /**
     * 在一个 8 x 8 的棋盘上，有一个白色的车（Rook），用字符 'R' 表示。棋盘上还可能存在空方块，白色的象（Bishop）以及黑色的卒（pawn），
     * 分别用字符 '.'，'B' 和 'p' 表示。不难看出，大写字符表示的是白棋，小写字符表示的是黑棋。
     * 车按国际象棋中的规则移动。东，西，南，北四个基本方向任选其一，然后一直向选定的方向移动，直到满足下列四个条件之一：
     * <p>
     * 棋手选择主动停下来。
     * 棋子因到达棋盘的边缘而停下。
     * 棋子移动到某一方格来捕获位于该方格上敌方（黑色）的卒，停在该方格内。
     * 车不能进入/越过已经放有其他友方棋子（白色的象）的方格，停在友方棋子前。
     * 你现在可以控制车移动一次，请你统计有多少敌方的卒处于你的捕获范围内（即，可以被一步捕获的棋子数）。
     *
     * @param board
     * @return
     */
    public int numRookCaptures(char[][] board) {
        int count = 0;
        int length1 = board.length;
        for (int i = 0; i < length1; i++) {
            int length = board[0].length;
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 'R') {
                    int column = j - 1;
                    while (column >= 0) {
                        if (board[i][column] == 'p') {
                            count++;
                            break;
                        } else if (board[i][column] == 'B') break;
                        column--;
                    }

                    column = j + 1;
                    while (column < length) {
                        if (board[i][column] == 'p') {
                            count++;
                            break;
                        } else if (board[i][column] == 'B') break;
                        column++;
                    }

                    int row = i - 1;
                    while (row >= 0) {
                        if (board[row][j] == 'p') {
                            count++;
                            break;
                        } else if (board[row][j] == 'B') break;
                        row--;
                    }

                    row = i + 1;
                    while (row < length1) {
                        if (board[row][j] == 'p') {
                            count++;
                            break;
                        } else if (board[row][j] == 'B') break;
                        row++;
                    }

                    return count;
                }
            }
        }

        return 0;
    }
}
