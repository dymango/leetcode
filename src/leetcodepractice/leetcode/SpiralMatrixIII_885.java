package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class SpiralMatrixIII_885 {

    /**
     * 在 R 行 C 列的矩阵上，我们从 (r0, c0) 面朝东面开始
     * 这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
     * 现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
     * 每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
     * 最终，我们到过网格的所有 R * C 个空间。
     * 按照访问顺序返回表示网格位置的坐标列表。
     * <p>
     * 示例 1：
     * 输入：R = 1, C = 4, r0 = 0, c0 = 0
     * 输出：[[0,0],[0,1],[0,2],[0,3]]
     *  
     * <p>
     * 示例 2：
     * 输入：R = 5, C = 6, r0 = 1, c0 = 4
     * 输出：[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
     * <p>
     * 提示：
     * <p>
     * 1 <= R <= 100
     * 1 <= C <= 100
     * 0 <= r0 < R
     * 0 <= c0 < C
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/spiral-matrix-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param rows
     * @param cols
     * @param rStart
     * @param cStart
     * @return
     */
    public static void main(String[] args) {
        new SpiralMatrixIII_885().spiralMatrixIII(5, 6, 1, 4);
    }

    private void printVisitedArray(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < visited[0].length; j++) {
                stringBuilder.append(visited[i][j] ? "* " : "- ");
            }
            System.out.println(stringBuilder.toString() + "\n");
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int x = rStart, y = cStart;
        int[][] result = new int[rows * cols][2];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int count = 0;
        int direction = 0;
        int goal = rows * cols;
        result[count][0] = x;
        result[count][1] = y;
        map.putIfAbsent(x, new HashSet<>());
        map.get(x).add(y);
        count++;
        while (count < goal) {
            if (direction == 0) {
                y++;
            } else if (direction == 1) {
                x++;
            } else if (direction == 2) {
                y--;
            } else {
                x--;
            }

            if (check(rows, cols, x, y)) {
                result[count][0] = x;
                result[count][1] = y;
                count++;
                map.putIfAbsent(x, new HashSet<>());
                map.get(x).add(y);
            }

            if (direction == 0) {
                if (!map.containsKey(x + 1) || !map.get(x + 1).contains(y)) {
                    direction = 1;
                }
            } else if (direction == 1) {
                if (!map.containsKey(x) || !map.get(x).contains(y - 1)) {
                    direction = 2;
                }
            } else if (direction == 2) {
                if (!map.containsKey(x - 1) || !map.get(x - 1).contains(y)) {
                    direction = 3;
                }
            } else {
                if (!map.containsKey(x) || !map.get(x).contains(y + 1)) {
                    direction = 0;
                }
            }
        }

        return result;
    }

    private boolean check(int rows, int cols, int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
