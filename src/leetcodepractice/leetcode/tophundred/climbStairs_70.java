package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class climbStairs_70 {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     * <p>
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int count = 1;
        int count2 = 2;
        for (int i = 3; i <= n; i++) {
            int t = count2;
            count2 = count + count2;
            count = t;
        }
        return count2;
    }

    private int climb(int n) {
        if (n == 1 || n == 2) return 1;
        return climb(n - 1) + climb(n - 2);
    }
}
