package app.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class GenerateMatrix_59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int direction = 0;
        int x = 0, y = 0;
        int circle = 0;
        int num = 1;
        boolean[][] visited = new boolean[row][col];
        while (true) {
            if(x < 0 || x >= row || y < 0 || y >= col) break;
            if(visited[x][y]) break;
            matrix[x][y] = num++;
            visited[x][y] = true;
            if(direction == 0) {
                if(y == col - circle - 1) {
                    direction = 1;
                    x++;
                } else {
                    y++;
                }
            } else if(direction == 1) {
                if(x == row - circle - 1) {
                    direction = 2;
                    y--;
                } else {
                    x++;
                }
            } else if(direction == 2) {
                if(y == circle) {
                    direction = 3;
                    x--;
                } else {
                    y--;
                }
            } else if(direction == 3) {
                if(x == circle + 1) {
                    direction = 0;
                    y++;
                    circle++;
                } else {
                    x--;
                }
            }
        }

        return matrix;
    }
}
