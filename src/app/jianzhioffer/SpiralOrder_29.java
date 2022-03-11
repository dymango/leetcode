package app.jianzhioffer;

/**
 * @author dimmy
 */
public class SpiralOrder_29 {

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * <p>
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * <p>
     * 示例 2：
     * <p>
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= matrix.length <= 100
     * 0 <= matrix[i].length <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @return
     */
    int r;
    int c;
    boolean[][] visited;

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[]{};
        r = matrix.length;
        c = matrix[0].length;
        int size = r * c;
        int[] result = new int[size];
        visited = new boolean[r][c];
        visited[0][0] = true;
        int x = 0, y = 0;
        // 1 right  2 down  3left 4up
        int status = 1;
        int arrLength = 0;
        while (arrLength < size) {
            result[arrLength] = matrix[x][y];
            arrLength += 1;
            if(arrLength >= size) break;
            Status move = move(status, x, y);
            status = move.status;
            x = move.x;
            y = move.y;
        }

        return result;
    }

    private Status move(int status, int x, int y) {
        Status statusView = new Status();
        if (status == 1) {

            if (y + 1 < c && !visited[x][y + 1]) {
                statusView.x = x;
                statusView.y = y + 1;
                statusView.status = 1;
                visited[x][y + 1] = true;
            } else {
                statusView.x = x + 1;
                statusView.y = y;
                statusView.status = 2;
                visited[x + 1][y] = true;
            }
        } else if (status == 2) {

            if (x + 1 < r && !visited[x + 1][y]) {
                statusView.x = x + 1;
                statusView.y = y;
                statusView.status = 2;
                visited[x + 1][y] = true;
            } else {
                statusView.x = x;
                statusView.y = y - 1;
                statusView.status = 3;
                visited[x][y - 1] = true;
            }
        } else if (status == 3) {

            if (y - 1 >= 0 && !visited[x][y - 1]) {
                statusView.x = x;
                statusView.y = y - 1;
                statusView.status = 3;
                visited[x][y - 1] = true;
            } else {
                statusView.x = x - 1;
                statusView.y = y;
                statusView.status = 4;
                visited[x - 1][y] = true;
            }
        } else {

            if (x - 1 >= 0 && !visited[x - 1][y]) {
                statusView.x = x - 1;
                statusView.y = y;
                statusView.status = 4;
                visited[x - 1][y] = true;
            } else {
                statusView.x = x;
                statusView.y = y + 1;
                statusView.status = 1;
                visited[x][y + 1] = true;
            }
        }

        return statusView;
    }

    private static class Status {
        public int x;
        public int y;
        public int status;
    }
}
