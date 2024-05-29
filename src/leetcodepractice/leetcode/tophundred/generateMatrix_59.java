package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class generateMatrix_59 {

    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        List<Integer> result = new ArrayList<>();
        int x = 0, y = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int num = 1;
        boolean[][] visited = new boolean[row][column];
        Direction direction = Direction.RIGHT;
        while (x >= 0 && x < row && y >= 0 && y < column && !visited[x][y]) {
            matrix[x][y] = num;
            num++;
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

        return matrix;
    }

    public enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
