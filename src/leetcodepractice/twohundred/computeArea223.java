package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class computeArea223 {

    /**
     * 给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
     * <p>
     * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
     * <p>
     * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
     * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
     *
     * @param ax1
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     */
    public static void main(String[] args) {
//        System.out.println(new computeArea223().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(new computeArea223().computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        //ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
        //ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int left = Math.min(ax1, bx1);
        int down = Math.min(ay1, by1);
        int right = Math.max(ax2, bx2);
        int up = Math.max(ay2, by2);
        var count = 0;
        for (int i = left; i <= right; i++) {
            for (int j = up; j >= down; j--) {
                if (i >= ax1 && i <= ax2 && j >= ay1 && j <= ay2
                    && i + 1 >= ax1 && i + 1 <= ax2 && j + 1 >= ay1 && j + 1 <= ay2
                    && i >= bx1 && i <= bx2 && j >= by1 && j <= by2
                    && i + 1 >= bx1 && i + 1 <= bx2 && j + 1 >= by1 && j + 1 <= by2) {
                    count++;
                }
            }
        }


        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - count;
    }

}
