package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class RLEIterator_900 {

    /**
     * 我们可以使用游程编码(即 RLE )来编码一个整数序列。在偶数长度 encoding ( 从 0 开始 )的游程编码数组中，对于所有偶数 i ，encoding[i] 告诉我们非负整数 encoding[i + 1] 在序列中重复的次数。
     * <p>
     * 例如，序列 arr = [8,8,8,5,5] 可以被编码为 encoding =[3,8,2,5] 。encoding =[3,8,0,9,2,5] 和 encoding =[2,8,1,8,2,5] 也是 arr 有效的 RLE 。
     * 给定一个游程长度的编码数组，设计一个迭代器来遍历它。
     * <p>
     * 实现 RLEIterator 类:
     * <p>
     * RLEIterator(int[] encoded) 用编码后的数组初始化对象。
     * int next(int n) 以这种方式耗尽后 n 个元素并返回最后一个耗尽的元素。如果没有剩余的元素要耗尽，则返回 -1 。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * ["RLEIterator","next","next","next","next"]
     * [[[3,8,0,9,2,5]],[2],[1],[1],[2]]
     * 输出：
     * [null,8,8,5,-1]
     * 解释：
     * RLEIterator rLEIterator = new RLEIterator([3, 8, 0, 9, 2, 5]); // 这映射到序列 [8,8,8,5,5]。
     * rLEIterator.next(2); // 耗去序列的 2 个项，返回 8。现在剩下的序列是 [8, 5, 5]。
     * rLEIterator.next(1); // 耗去序列的 1 个项，返回 8。现在剩下的序列是 [5, 5]。
     * rLEIterator.next(1); // 耗去序列的 1 个项，返回 5。现在剩下的序列是 [5]。
     * rLEIterator.next(2); // 耗去序列的 2 个项，返回 -1。 这是由于第一个被耗去的项是 5，
     * 但第二个项并不存在。由于最后一个要耗去的项不存在，我们返回 -1。
     *  
     * <p>
     * 提示：
     * <p>
     * 2 <= encoding.length <= 1000
     * encoding.length 为偶
     * 0 <= encoding[i] <= 109
     * 1 <= n <= 109
     * 每个测试用例调用next 不高于 1000 次 
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/rle-iterator
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param encoding
     */
    int index = 0;
    long remain = 0;
    int[] ENCODING;
    long[] preSum;

    public RLEIterator_900(int[] encoding) {
        preSum = new long[encoding.length];
        for (int i = 0; i < encoding.length; i += 2) {
            preSum[i] = encoding[i] + (i - 2 >= 0 ? preSum[i - 2] : 0);
        }

        index = 0;
        ENCODING = encoding;
    }

    public int next(int n) {
        remain += n;
        for (int i = index; i < preSum.length; i += 2) {
            if (preSum[i] >= remain) {
                return ENCODING[i + 1];
            }

            index = i;
        }

        return -1;
    }
}
