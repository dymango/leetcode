package app.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author dimmy
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class MedianFinder_295 {

    private PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> largeHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /** initialize your data structure here. */
    public MedianFinder_295() {

    }

    public void addNum(int num) {
        smallHeap.offer(num);
        if(num < smallHeap.peek()) {

        } else if(num > largeHeap.peek()) {

        }

        if(smallHeap.size() - largeHeap.size() > 1) {
            largeHeap.offer(smallHeap.poll());
        }
    }

    public double findMedian() {
        if(smallHeap.size() == largeHeap.size()) {
            return  (double)(smallHeap.peek() + largeHeap.peek())/2;
        } else if(smallHeap.size() < largeHeap.size()) {
            return largeHeap.peek();
        } else {
            return smallHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder_295 medianFinder_295 = new MedianFinder_295();
        medianFinder_295.addNum(-1);
        medianFinder_295.addNum(-2);
        System.out.println(medianFinder_295.findMedian());
        medianFinder_295.addNum(-3);
        System.out.println(medianFinder_295.findMedian());
    }
}
