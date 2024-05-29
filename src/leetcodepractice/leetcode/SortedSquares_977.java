package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;

import java.util.PriorityQueue;

/**
 * @author dimmy
 */
public class SortedSquares_977 {

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * @param nums
     * @return
     */
    @MainMethod
    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.offer(num * num);
        }

        int[] r = new int[priorityQueue.size()];
        int size = priorityQueue.size();
        for (int i = 0; i < size; i++) {
            r[i] = priorityQueue.poll();
        }
        return r;
    }
}
