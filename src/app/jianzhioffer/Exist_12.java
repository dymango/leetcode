package app.jianzhioffer;

/**
 * @author dimmy
 */
public class Exist_12 {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     *  
     * <p>
     * 例如，在下面的 3×4 的矩阵中包含单词 'ABCCED'（单词中的字母已标出）。
     * <p>
     * <p>
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：board = [['a','b'],['c','d']], word = 'abcd'
     * 输出：false
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * board 和 word 仅由大小写英文字母组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     * @param word
     * @return
     */
    boolean[][] visited;
    char[][] board;
    String target;
    int r, c;

    public boolean exist(char[][] board, String word) {
        r = board.length;
        c = board[0].length;
        this.board = board;
        target = word;
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean exist = find(i, j, 0);
                    if(exist) return true;
                }
            }
        }

        return false;
    }

    public boolean find(int x, int y, int index) {
        if (x < 0 || x >= r || y < 0 || y >= c) return false;
        if (visited[x][y] || board[x][y] != target.charAt(index)) return false;
        if (index == target.length() - 1) return true;
        visited[x][y] = true;
        boolean exist;
        exist = find(x + 1, y, index + 1);
        if(!exist) exist = find(x - 1, y, index + 1);
        if(!exist)  exist = find(x, y + 1, index + 1);
        if(!exist)  exist = find(x, y - 1, index + 1);
        visited[x][y] = false;
        return exist;
    }

    public static void main(String[] args) {
        System.out.println(new Exist_12().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }
}
