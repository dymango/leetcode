package leetcodepractice.twohundred;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

/**
 * @author dimmy
 */
public class nthUglyNumber264 {

    /**
     * 要得到从小到大的第 n 个丑数，可以使用最小堆实现。
     * 初始时堆为空。首先将最小的丑数 1 加入堆。
     * 每次取出堆顶元素 x，则 x 是堆中最小的丑数，由于 2x,3x,5x 也是丑数，因此将 2x,3x,5x 加入堆。
     * 上述做法会导致堆中出现重复元素的情况。为了避免重复元素，可以使用哈希集合去重，避免相同元素多次加入堆。
     * 在排除重复元素的情况下，第 n 次从最小堆中取出的元素即为第 n 个丑数。
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/ugly-number-ii/solutions/712102/chou-shu-ii-by-leetcode-solution-uoqd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 方法二：动态规划
     * 方法一使用最小堆，会预先存储较多的丑数，维护最小堆的过程也导致时间复杂度较高。可以使用动态规划的方法进行优化。
     * <p>
     * 定义数组 dp，其中 dp[i] 表示第 i 个丑数，第 n 个丑数即为 dp[n]。
     * <p>
     * 由于最小的丑数是 1，因此 dp[1]=1。
     * <p>
     * 如何得到其余的丑数呢？定义三个指针 p
     * 2
     * ​
     * ,p
     * 3
     * ​
     * ,p
     * 5
     * ​
     * ，表示下一个丑数是当前指针指向的丑数乘以对应的质因数。初始时，三个指针的值都是 1。
     * <p>
     * 当 2≤i≤n 时，令 dp[i]=min(dp[p
     * 2
     * ​
     * ]×2,dp[p
     * 3
     * ​
     * ]×3,dp[p
     * 5
     * ​
     * ]×5)，然后分别比较 dp[i] 和 dp[p
     * 2
     * ​
     * ]×2,dp[p
     * 3
     * ​
     * ]×3,dp[p
     * 5
     * ​
     * ]×5 是否相等，如果相等则将对应的指针加 1。
     * <p>
     * 正确性证明
     * <p>
     * 对于 i>1，在计算 dp[i] 时，指针 p
     * x
     * ​
     * (x∈{2,3,5}) 的含义是使得 dp[j]×x>dp[i−1] 的最小的下标 j，即当 j≥p
     * x
     * ​
     * 时 dp[j]×x>dp[i−1]，当 j<p
     * x
     * ​
     * 时 dp[j]×x≤dp[i−1]。
     * <p>
     * 因此，对于 i>1，在计算 dp[i] 时，dp[p
     * 2
     * ​
     * ]×2,dp[p
     * 3
     * ​
     * ]×3,dp[p
     * 5
     * ​
     * ]×5 都大于 dp[i−1]，dp[p
     * 2
     * ​
     * −1]×2,dp[p
     * 3
     * ​
     * −1]×3,dp[p
     * 5
     * ​
     * −1]×5 都小于或等于 dp[i−1]。令 dp[i]=min(dp[p
     * 2
     * ​
     * ]×2,dp[p
     * 3
     * ​
     * ]×3,dp[p
     * 5
     * ​
     * ]×5)，则 dp[i]>dp[i−1] 且 dp[i] 是大于 dp[i−1] 的最小的丑数。
     * <p>
     * 在计算 dp[i] 之后，会更新三个指针 p
     * 2
     * ​
     * ,p
     * 3
     * ​
     * ,p
     * 5
     * ​
     * ，更新之后的指针将用于计算 dp[i+1]，同样满足 dp[i+1]>dp[i] 且 dp[i+1] 是大于 dp[i] 的最小的丑数。
     *
     * @param n
     * @return
     */
    @MainParam
    int n = 10;

    @MainMethod
    public int nthUglyNumber(int n) {
        var minArr = new int[n];
        minArr[0] = 1;
        var p2 = 0;
        var p3 = 0;
        var p5 = 0;
        for (int i = 1; i < n; i++) {
            minArr[i] = Math.min(minArr[p2] * 2, Math.min(minArr[p3] * 3, minArr[p5] * 5));
            if(minArr[i] == minArr[p2] * 2) {
                p2++;
            }

            if(minArr[i] == minArr[p3] * 3) {
                p3++;
            }

            if(minArr[i] == minArr[p5] * 5) {
                p5++;
            }
        }

        return minArr[n- 1];
    }
}
