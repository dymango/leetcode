package app.leetcode;

/**
 * @author dimmy
 */
public class Exist_79 {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：board = [ ["A","B","C","E"],
     * ["S","F","C","S"],
     * ["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * 输出：true
     * 示例 3：
     * <p>
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * 输出：false
     *  
     * <p>
     * 提示：
     * <p>
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     *  
     * <p>
     * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/word-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     * @param word
     * @return
     */
    boolean[][] visited;
    String WORD;
    char[][] BOARD;

    public boolean exist(char[][] board, String word) {
        WORD = word;
        int row = board.length, col = board[0].length;
        visited = new boolean[row][col];
        BOARD = board;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (search(i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean search(int x, int y, int charIndex) {
        if (charIndex >= WORD.length()) return true;
        if (x < 0 || x >= BOARD.length || y < 0 || y >= BOARD[0].length) return false;
        if (visited[x][y]) return false;
        if (BOARD[x][y] != WORD.charAt(charIndex)) return false;
        visited[x][y] = true;
        int nextIndex = charIndex + 1;
        boolean match = search(x + 1, y, nextIndex) || search(x, y + 1, nextIndex) || search(x - 1, y, nextIndex) || search(x, y - 1, nextIndex);
        visited[x][y] = false;
        return match;
    }
}
