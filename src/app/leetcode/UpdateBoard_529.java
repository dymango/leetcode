package app.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 */
public class UpdateBoard_529 {

    /**
     * 让我们一起来玩扫雷游戏！
     * <p>
     * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
     * <p>
     * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
     * <p>
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
     * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
     * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入:
     * <p>
     * [['E', 'E', 'E', 'E', 'E'],
     * ['E', 'E', 'M', 'E', 'E'],
     * ['E', 'E', 'E', 'E', 'E'],
     * ['E', 'E', 'E', 'E', 'E']]
     * <p>
     * Click : [3,0]
     * <p>
     * 输出:
     * <p>
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'M', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     * <p>
     * 解释:
     * <p>
     * 示例 2：
     * <p>
     * 输入:
     * <p>
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'M', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     * <p>
     * Click : [1,2]
     * <p>
     * 输出:
     * <p>
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'X', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     * <p>
     * 解释:
     * <p>
     *  
     * <p>
     * 注意：
     * <p>
     * 输入矩阵的宽和高的范围为 [1,50]。
     * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
     * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
     * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minesweeper
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     * @param click
     * @return
     */
    static boolean[][] marked;
    public static char[][] updateBoard(char[][] board, int[] click) {
        marked = new boolean[board.length][board[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        if (board[x][y] == 'E') {
            board[x][y] = 'B';
            marked[x][y] = true;
            int bombsCount = aroundBombs(board, new int[]{x,y});
            if (bombsCount > 0) {
                board[x][y] = (char) (48 + bombsCount);
            }

            if(board[x][y] == 'B') addNearElement(board, x, y, queue);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    int px = poll[0];
                    int py = poll[1];
                    if (board[px][py] == 'E') {
                        board[px][py] = 'B';
                        int bombs = aroundBombs(board, poll);
                        if (bombs > 0) {
                            board[px][py] = (char) (48 + bombs);
                        }

                        if( board[px][py] == 'B') addNearElement(board, px, py, queue);
                    }
                }
            }
        }

        return board;
    }

    private static void addNearElement(char[][] board, int x, int y, Queue<int[]> queue) {
        int row = board.length;
        int col = board[0].length;
        if (x + 1 < row) put(x + 1, y, queue);
        if (x - 1 >= 0)  put(x - 1, y,queue);
        if (y + 1 < col)  put(x, y + 1, queue);
        if (y - 1 >= 0)  put(x, y - 1,queue);
        if (x + 1 < row && y + 1 < col)  put(x + 1, y + 1,queue);
        if (x + 1 < row && y - 1 >= 0)  put(x + 1, y - 1,queue);
        if (x - 1 >= 0 && y + 1 < col)  put(x - 1, y + 1,queue);
        if (x - 1 >= 0 && y - 1 >= 0)  put(x - 1, y - 1,queue);
    }

    public static void put(int x, int y, Queue<int[]> queue) {
        if(!marked[x][y]) {
            queue.add(new int[]{x,y});
            marked[x][y] = true;
        }
    }

    public static int aroundBombs(char[][] board, int[] position) {
        int x = position[0];
        int y = position[1];
        int row = board.length;
        int col = board[0].length;
        int count = 0;
        if (x + 1 < row) {
            if(board[x+1][y] == 'M') count++;
        }
        if (x - 1 >= 0) {
            if(board[x-1][y] == 'M') count++;
        }
        if (y + 1 < col) {
            if(board[x][y + 1] == 'M') count++;
        }
        if (y - 1 >= 0){
            if(board[x][y -1] == 'M') count++;
        }
        if (x + 1 < row && y + 1 < col){
            if(board[x+1][y+1] == 'M') count++;
        }
        if (x + 1 < row && y - 1 >= 0){
            if(board[x+1][y-1] == 'M') count++;
        }
        if (x - 1 >= 0 && y + 1 < col){
            if(board[x-1][y+1] == 'M') count++;
        }
        if (x - 1 >= 0 && y - 1 >= 0) {
            if(board[x-1][y-1] == 'M') count++;
        }

        return count;
    }

    public static void main(String[] args) {
//        updateBoard(new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}}, new int[]{3,0});
//        updateBoard(new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}}, new int[]{3,0});
        updateBoard(new char[][]{
                {'E','M','M','2','B','B','B','B'},
                {'E','E','M','2','B','B','B','B'},
                {'E','E','2','1','B','B','B','B'},
                {'E','M','1','B','B','B','B','B'},
                {'1','2','2','1','B','B','B','B'},
                {'B','1','M','1','B','B','B','B'},
                {'B','1','1','1','B','B','B','B'},
                {'B','B','B','B','B','B','B','B'}}, new int[]{0,0});
    }
}
