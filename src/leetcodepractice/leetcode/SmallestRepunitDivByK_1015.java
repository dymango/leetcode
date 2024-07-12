package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class SmallestRepunitDivByK_1015 {

    /**
     * 给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
     *
     * 返回 n 的长度。如果不存在这样的 n ，就返回-1。
     * 注意： n 可能不符合 64 位带符号整数。
     *
     * resid = 1 mod k
     * if resid != 0  n(new) =n(old)*10 + 1
     * resid(new) = (n(old)*10 + 1) % k
     *  =(n(old)*10%k + 1%k) %k
     *
     * <p>
     * 示例 1：
     * 输入：k = 1
     * 输出：1
     * 解释：最小的答案是 n = 1，其长度为 1。
     * <p>
     * 示例 2：
     * 输入：k = 2
     * 输出：-1
     * 解释：不存在可被 2 整除的正整数 n 。
     * 示例 3：
     * <p>
     * 输入：k = 3
     * 输出：3
     * 解释：最小的答案是 n = 111，其长度为 3。
     * 37
     *
     *题目要求出长度最小的仅包含的 1 的并且被 k 整除的正整数。我们从 n=1 开始枚举，此时对 k 取余得余数 resid=1modk。如果 resid 不为 0，则表示 n 当前还不能被 k 整除，我们需要增加 n 的长度。令 n
     * new
     * ​
     *  =n
     * old
     * ​
     *  ×10+1，resid
     * new
     * ​
     *  =n
     * new
     * ​
     *  modk。将 n
     * old
     * ​
     *   代入其中可得：
     *
     * resid
     * new
     * ​
     *
     * ​
     *
     * =(n
     * old
     * ​
     *  ×10+1)modk
     * =((n
     * old
     * ​
     *  modk)×10+1)modk
     * =(resid
     * old
     * ​
     *  ×10+1)modk
     * ​
     *
     * 从上式可以发现，新的余数 resid
     * new
     * ​
     *   可以由 resid
     * old
     * ​
     *   推导得到。因此在遍历过程中不需要记录 n，只需记录 resid。由于 resid 是对 k 取余之后的余数，因此种类数不会超过 k。
     *
     * 在遍历过程中如果出现重复的 resid，表示遇到了一个循环，接着遍历下去会重复循环中的每一步，不会产生新的余数。所以我们用一个哈希表记录出现过的余数，当更新 resid 后发现该值已经在哈希表时，直接返回 −1。否则我们一直遍历，直到 resid 变为 0。最终哈希表中的元素个数或者遍历次数就是实际 n 的长度。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/smallest-integer-divisible-by-k/solutions/2263173/ke-bei-k-zheng-chu-de-zui-xiao-zheng-shu-ynog/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param k
     * @return
     */
    public int smallestRepunitDivByK(int k) {
        return 1;
    }
}
