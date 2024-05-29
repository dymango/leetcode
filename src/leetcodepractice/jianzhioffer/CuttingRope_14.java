package leetcodepractice.jianzhioffer;

/**
 * @author dimmy
 */
public class CuttingRope_14 {

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * <p>
     * 示例 1：
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * <p>
     * 示例 2:
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * 提示：
     * <p>
     * 2 <= n <= 58
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    int[] cache;
    boolean[] visited;
    public int cuttingRope(int n) {
        if(n == 2) return 1;
        cache = new int[n+1];
        visited = new boolean[n+1];
        return max(n, false);
    }

    //长度为n的绳子， 切割最大乘积
    private int max(int n, boolean useSelf) {
        if(n == 1) return 1;
        if(visited[n]) return cache[n];
        int max = useSelf ? n : Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int temp = i * max(n - i, true);
            max = Math.max(temp, max);
        }

        cache[n] = max;
        visited[n] = true;
        return max;
    }
}
