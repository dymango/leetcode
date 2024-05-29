package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class wordSearch_79 {
    String WORD;

    public boolean exist(char[][] board, String word) {
        WORD = word;
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                boolean match = dps(board, i, j, new boolean[row][column], 0);
                if (match) return true;
            }
        }
        return false;
    }
    //[["A","B","C","E"]
    // ,["S","F","C","S"]
    // ,["A","D","E","E"]]

    private boolean dps(char[][] board, int i, int j, boolean[][] visited, int strIndex) {
        if (strIndex >= WORD.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return false;
        if (board[i][j] != WORD.charAt(strIndex)) return false;
        visited[i][j] = true;
        int nextIndex = strIndex + 1;
        boolean match = dps(board, i + 1, j, visited, nextIndex)
            || dps(board, i, j + 1, visited, nextIndex)
            || dps(board, i - 1, j, visited, nextIndex)
            || dps(board, i, j - 1, visited, nextIndex);
        visited[i][j] = false;
        return match;


    }

    public static void main(String[] args) {
        System.out.println(new wordSearch_79().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
