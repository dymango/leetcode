package app.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class IsNStraightHand_846 {

    /**
     * 爱丽丝有一手（hand）由整数数组给定的牌。 
     * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
     * 如果她可以完成分组就返回 true，否则返回 false。
     * <p>
     *  
     * <p>
     * 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
     * 输出：true
     * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
     * 示例 2：
     * <p>
     * 输入：hand = [1,2,3,4,5], W = 4
     * 输出：false
     * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= hand.length <= 10000
     * 0 <= hand[i] <= 10^9
     * 1 <= W <= hand.length
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hand-of-straights
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    public static void main(String[] args) {
        IsNStraightHand_846 isNStraightHand_846 = new IsNStraightHand_846();
        System.out.println(isNStraightHand_846.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(isNStraightHand_846.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(isNStraightHand_846.isNStraightHand(new int[]{1, 2, 3}, 1));
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        boolean[] visited = new boolean[hand.length];
        int index = 0;
        while (index < hand.length) {
            if(visited[index]) {
                index++;
                continue;
            }

            visited[index] = true;
            int limit = groupSize - 1;
            if(limit == 0) continue;
            int tv = hand[index];
            for (int i = index; i < hand.length; i++) {
                if (visited[i]) continue;
                if (hand[i] > tv + 1) return false;
                if (hand[i] == tv + 1) {
                    visited[i] = true;
                    limit--;
                    tv = hand[i];
                }

                if (limit == 0) break;
            }

            if (limit != 0) return false;
            index++;
        }

        return true;
    }
}
