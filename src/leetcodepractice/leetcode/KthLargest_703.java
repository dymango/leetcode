package leetcodepractice.leetcode;

import java.util.PriorityQueue;

/**
 * @author dimmy
 */
public class KthLargest_703 {
    PriorityQueue<Integer> heap;
    int k = 0;

    public KthLargest_703(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.offer(val);
        }

        return heap.peek();
    }
}
