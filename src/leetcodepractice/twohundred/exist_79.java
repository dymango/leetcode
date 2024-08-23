package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class exist_79 {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        var c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == c) {
                    var match = match(board, i, j, word, 0, new boolean[board.length][board[0].length]);
                    if (match) return true;
                }
            }
        }

        return false;
    }

    boolean match(char[][] board, int x, int y, String word, int wi, boolean[][] visited) {
        if (wi >= word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] ) return false;
        if (board[x][y] != word.charAt(wi)) return false;
        visited[x][y] = true;
        var match = match(board, x + 1, y, word, wi + 1, visited)
            || match(board, x, y + 1, word, wi + 1, visited)
            || match(board, x - 1, y, word, wi + 1, visited)
            || match(board, x, y - 1, word, wi + 1, visited);
        visited[x][y] = false;
        return match;
    }
}
