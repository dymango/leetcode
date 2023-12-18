package app.leetcode.tophundred;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class solve_130 {

    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *
     * @param board
     */
    char[][] BOARD;
    boolean[][] mark;

    public void solve(char[][] board) {
        BOARD = board;
        int row = board.length;
        int column = board[0].length;
        mark = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            mark(i, 0);
            mark(i, column - 1);
        }

        for (int i = 0; i < column; i++) {
            mark(0, i);
            mark(row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!mark[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void mark(int i, int j) {
        if (mark[i][j]) return;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                if (x >= 0 && x < BOARD.length && y >= 0 && y < BOARD[0].length) {
                    if(mark[x][y]) continue;
                    if (BOARD[x][y] == 'O') {
                        mark[x][y] = true;
                        queue.offer(new int[]{x + 1, y});
                        queue.offer(new int[]{x, y + 1});
                        queue.offer(new int[]{x - 1, y});
                        queue.offer(new int[]{x, y - 1});
                    }
                }
            }
        }
    }
}
