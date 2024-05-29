package leetcodepractice.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class SpiralOrder_54 {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * <p>
     * <p>
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *  
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int direction = 0;
        int x = 0, y = 0;
        int circle = 0;
        boolean[][] visited = new boolean[row][col];
        while (true) {
            if(x < 0 || x >= row || y < 0 || y >= col) break;
            if(visited[x][y]) break;
            result.add(matrix[x][y]);
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

        return result;
    }
}
