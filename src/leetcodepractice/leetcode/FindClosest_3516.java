package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class FindClosest_3516 {

    /**
     * 给你三个整数 x、y 和 z，表示数轴上三个人的位置：
     *
     * x 是第 1 个人的位置。
     * y 是第 2 个人的位置。
     * z 是第 3 个人的位置，第 3 个人 不会移动 。
     * 第 1 个人和第 2 个人以 相同 的速度向第 3 个人移动。
     *
     * 判断谁会 先 到达第 3 个人的位置：
     *
     * 如果第 1 个人先到达，返回 1 。
     * 如果第 2 个人先到达，返回 2 。
     * 如果两个人同时到达，返回 0 。
     * 根据上述规则返回结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入： x = 2, y = 7, z = 4
     *
     * 输出： 1
     *
     * 解释：
     *
     * 第 1 个人在位置 2，到达第 3 个人（位置 4）需要 2 步。
     * 第 2 个人在位置 7，到达第 3 个人需要 3 步。
     * 由于第 1 个人先到达，所以输出为 1。
     * @param x
     * @param y
     * @param z
     * @return
     */
    public int findClosest(int x, int y, int z) {
        return Math.abs(x - z) < Math.abs(y - z) ? 1 : Math.abs(x - z) > Math.abs(y - z) ? 2 : 0;
    }
}
