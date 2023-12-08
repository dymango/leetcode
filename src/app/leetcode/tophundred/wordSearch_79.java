package app.leetcode.tophundred;

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

        //露3藏2
        //3个 饵 核
        //2个 核 反
        //核: 圣堂 火猫 魂守 天怒 敌法 末日 （巨魔，一姐）
        //
        //前排： 尸王 骨王 潮汐 全能
        //尸王: 大概率被师奶/速攻处理，
        //潮汐全能: 师奶/神灵
        //骷髅: 物理队

        //尸王： 末日 天怒 骨法(哈斯卡)
        //潮汐: 火猫 圣堂 天怒
        //骷髅: 潮汐全能冰女魂守巫医
    }

    public static void main(String[] args) {
        System.out.println(new wordSearch_79().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
