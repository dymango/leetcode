package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class spiralOrder_54 {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int x = 0, y = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] visited = new boolean[row][column];
        Direction direction = Direction.RIGHT;
        while (x >= 0 && x < row && y >= 0 && y < column && !visited[x][y]) {
            result.add(matrix[x][y]);
            visited[x][y] = true;
            switch (direction) {
                case RIGHT -> {
                    y++;
                    if (y >= column || visited[x][y]) {
                        direction = Direction.DOWN;
                        y--;
                        x++;
                    }
                }
                case DOWN -> {
                    x++;
                    if (x >= row || visited[x][y]) {
                        direction = Direction.LEFT;
                        x--;
                        y--;
                    }
                }
                case LEFT -> {
                    y--;
                    if (y < 0 || visited[x][y]) {
                        direction = Direction.UP;
                        y++;
                        x--;
                    }
                }
                case UP -> {
                    x--;
                    if (x < 0 || visited[x][y]) {
                        direction = Direction.RIGHT;
                        x++;
                        y++;
                    }
                }
            }
        }

        return result;
    }

    public enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
