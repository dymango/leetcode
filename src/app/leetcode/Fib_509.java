package app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class Fib_509 {

    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 给定 N，计算 F(N)。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
     * 示例 2：
     *
     * 输入：3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
     * 示例 3：
     *
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
     *  
     *
     * 提示：
     *
     * 0 ≤ N ≤ 30
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fibonacci-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param N
     * @return
     */
    public int fib(int N) {
        if(N == 0 || N == 1) return N;
        Integer value;
        if((value = numberCache.get(N)) != null) return value;
        int n1 = fib(N-1);
        numberCache.put(N-1, n1);
        int n2 = fib(N-2);
        numberCache.put(N-2, n2);
        return n1 + n2;
    }

    Map<Integer, Integer> numberCache = new HashMap<>();
}
