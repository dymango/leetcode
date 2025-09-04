package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class NumberOfPairs_3025 {

    /**
     * 给你一个  n x 2 的二维数组 points ，它表示二维平面上的一些点坐标，其中 points[i] = [xi, yi] 。
     * 计算点对 (A, B) 的数量，其中
     * <p>
     * A 在 B 的左上角，并且
     * 它们形成的长方形中（或直线上）没有其它点（包括边界）。
     * 返回数量。
     * [[6,2],[4,4],[2,6]]
     *[[3,1],[1,3],[1,1]]
     * @param points
     * @return
     */
    public static void main(String[] args) {
        new NumberOfPairs_3025().numberOfPairs(new int[][]{{3,1},{1,3},{1,1}});
    }

    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            var a = points[i];
            for (int j = i + 1; j < n; j++) {
                var b = points[j];
                if (a[0] >= b[0] && a[1] <= b[1] || a[0] <= b[0] && a[1] >= b[1]) {
                    if (!in(points, i, j)) sum++;
                }
            }
        }
        return sum;
    }

    private boolean in(int[][] points, int x, int y) {
        int n = points.length;
        var a = points[x];
        var b = points[y];
        for (int i = 0; i < n; i++) {
            if (i == x || i == y) continue;
            var c = points[i];
            if (c[0] <= a[0] && c[0] >= b[0] && c[1] >= a[1] && c[1] <= b[1]
                || c[0] >= a[0] && c[0] <= b[0] && c[1] <= a[1] && c[1] >= b[1]
            ) return true;
        }

        return false;
    }

}
