package leetcodepractice.leetcode;

import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author dimmy
 */
public class LastStoneWeight_1050 {

    /**
     * 有一堆石头，每块石头的重量都是正整数。
     * <p>
     * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     * <p>
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            priorityQueue.add(stone);
        }

        while (priorityQueue.size() > 1) {
            var poll = priorityQueue.poll();
            var poll2 = priorityQueue.poll();
            if (Objects.equals(poll, poll2)) continue;
            priorityQueue.add(Math.abs(poll - poll2));
        }

        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }
}
