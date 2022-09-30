package app.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 */
public class FairCandySwap_888 {
    /**
     * 爱丽丝和鲍勃拥有不同总数量的糖果。给你两个数组 aliceSizes 和 bobSizes ，aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数量，bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。
     * 两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。一个人拥有的糖果总数量是他们每盒糖果数量的总和。
     * 返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。如果存在多个答案，你可以返回其中 任何一个 。
     * 题目测试用例保证存在与输入对应的答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：aliceSizes = [1,1], bobSizes = [2,2]
     * 输出：[1,2]
     * 示例 2：
     * <p>
     * 输入：aliceSizes = [1,2], bobSizes = [2,3]
     * 输出：[1,2]
     * 示例 3：
     * <p>
     * 输入：aliceSizes = [2], bobSizes = [1,3]
     * 输出：[2,3]
     * 示例 4：
     * <p>
     * 输入：aliceSizes = [1,2,5], bobSizes = [2,4]
     * 输出：[5,4]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= aliceSizes.length, bobSizes.length <= 104
     * 1 <= aliceSizes[i], bobSizes[j] <= 105
     * 爱丽丝和鲍勃的糖果总数量不同。
     * 题目数据保证对于给定的输入至少存在一个有效答案。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/fair-candy-swap
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param aliceSizes
     * @param bobSizes
     * @return
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0, bobSum = 0;
        Set<Integer> aliceSet = new HashSet<>();
        Set<Integer> bobSet = new HashSet<>();
        for (int aliceSize : aliceSizes) {
            aliceSum += aliceSize;
            aliceSet.add(aliceSize);
        }
        for (int bobSize : bobSizes) {
            bobSum += bobSize;
            bobSet.add(bobSize);
        }

        if (aliceSum >= bobSum) {
            for (int aliceSize : aliceSizes) {
                int tempAlice = aliceSum - aliceSize;
                int tempBob = bobSum + aliceSize;
                if (tempBob <= tempAlice) continue;
                int t = tempBob - tempAlice;
                if (t % 2 != 0) continue;
                if (bobSet.contains(t / 2)) {
                    return new int[]{aliceSize, t / 2};
                }
            }
        } else {
            for (int bobSize : bobSizes) {
                int tempAlice = aliceSum + bobSize;
                int tempBob = bobSum - bobSize;
                if (tempBob >= tempAlice) continue;
                int t = tempAlice - tempBob;
                if (t % 2 != 0) continue;
                if (aliceSet.contains(t / 2)) {
                    return new int[]{t / 2, bobSize};
                }
            }
        }

        return new int[0];
    }
}
