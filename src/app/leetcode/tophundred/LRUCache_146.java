package app.leetcode.tophundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class LRUCache_146 {

    /**
     * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     * <p>
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     * <p>
     * <p>
     * <p>
     * [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
     * <p>
     * [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
     * 双向链表
     *
     * @param capacity
     */

    Map<Integer, TwoWayNode> nodeMap;
    TwoWayNode head;
    TwoWayNode tail;
    int sizeLimit;

    public LRUCache_146(int capacity) {
        nodeMap = new HashMap<>();
        sizeLimit = capacity;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        TwoWayNode twoWayNode = nodeMap.get(key);
        move(twoWayNode);
        return twoWayNode.val;
    }

    public void put(int key, int value) {
        TwoWayNode newHead;
        if (!nodeMap.containsKey(key)) {
            newHead = new TwoWayNode(key, value);
            nodeMap.put(key, newHead);
        } else {
            newHead = nodeMap.get(key);
        }

        move(newHead);
        if (nodeMap.size() > sizeLimit) {
            nodeMap.remove(tail.key);
            tail = tail.pre;
            tail.next = null;
        }
    }

    private void move(TwoWayNode node) {
        if(head == null) {
            head = node;
            tail = node;
            return;
        }

        if (node == head) return;
        if (node == tail) {
            tail = node.pre;
            node.next = head;
            head.pre = node;
            head = node;
            return;
        }

        if (node.pre == null && node.next == null) {
            head.pre = node;
            node.next = head;
            head = node;
            return;
        }

        node.pre.next = node.next;
        node.next = head;
        head.pre = node;
        head = node;
    }

    public static class TwoWayNode {
        public int key;
        public int val;
        public TwoWayNode pre;
        public TwoWayNode next;

        public TwoWayNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache_146 lruCache146 = new LRUCache_146(2);
        lruCache146.put(2, 1);
        lruCache146.put(1, 1);
//        lruCache146.get(1);
        lruCache146.put(2, 3);
//        lruCache146.get(2);
        lruCache146.put(4, 1);
        int i = 1;
    }

}
