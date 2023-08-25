package app.leetcode;

/**
 * @author dimmy
 */
public class GenerateMatrix_59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int x = 0, y = 0;
        int num = 1;
        int position = 0;
        boolean[][] visited = new boolean[n][n];
        for (; ; ) {
            matrix[x][y] = num;
            visited[x][y] = true;

            if (position == 0) {
                y++;
                if (y >= n || visited[x][y]) {
                    y--;
                    x++;
                    position = 1;
                }

            } else if (position == 1) {
                x++;
                if (x >= n || visited[x][y]) {
                    x--;
                    y--;
                    position = 2;
                }
            } else if (position == 2) {
                y--;
                if (y < 0 || visited[x][y]) {
                    x--;
                    y++;
                    position = 3;
                }
            } else {
                x--;
                if (x < 0 || visited[x][y]) {
                    y++;
                    x++;
                    position = 0;
                }
            }
        }
    }
}
