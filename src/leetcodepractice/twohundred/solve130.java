package leetcodepractice.twohundred;

public class solve130 {

    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
     *
     * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
     * 区域：连接所有 'O' 的单元格来形成一个区域。
     * 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
     * 通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。
     * @param board
     */
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            if(board[i][0] == 'O') dfs(visited, board, i, 0);
            if(board[i][row - 1] == 'O') dfs(visited, board, i, row - 1);
        }

        for (int i = 0; i < col; i++) {
            if(board[0][i] == 'O') dfs(visited, board, 0, i);
            if(board[row - 1][i] == 'O') dfs(visited, board, row - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[0].length; i1++) {
                if(board[i][i1] == 'O' && !visited[i][i1]) board[i][i1] = 'X';
            }
        }
    }

    private void dfs(boolean[][] visited, char[][] board, int x, int y) {
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
        if(board[x][y] != 'O' || visited[x][y]) return;
        visited[x][y] = true;
        dfs(visited, board, x+1, y);
        dfs(visited, board, x-1, y);
        dfs(visited, board, x, y + 1);
        dfs(visited, board, x,  y - 1);
    }
}
