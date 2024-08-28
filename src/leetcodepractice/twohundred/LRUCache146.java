package leetcodepractice.twohundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class LRUCache146 {

    /**
     * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     * <p>
     * 1 <= capacity <= 3000
     * 0 <= key <= 10000
     * 0 <= value <= 105
     * 最多调用 2 * 105 次 get 和 put
     *
     * @param capacity
     */
    Map<Integer, TwoWayNode> map = new HashMap<>();
    TwoWayNode head = null;
    TwoWayNode tail = null;

    int capacity;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        var twoWayNode = map.get(key);
        moveToHead(twoWayNode);
        return twoWayNode.val;
    }

    public void put(int key, int value) {
        if (head == null && tail == null) {
            var node = new TwoWayNode(key, value);
            map.put(key, node);
            head = node;
            tail = node;
            return;
        }

        if (map.containsKey(key)) {
            var node = map.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }

        var node = new TwoWayNode(key, value);
        map.put(key, node);
        addToHead(node);

        if (map.size() > capacity) {
            map.remove(tail.key);
            removeTail();
        }
    }

    void addToHead(TwoWayNode node) {
        head.pre = node;
        node.next = head;
        head = node;
    }

    void moveToHead(TwoWayNode node) {
        if (node == head) return;
        if (node == tail) {
            var pre = tail.pre;
            pre.next = null;
            node.pre = null;
            tail = pre;
            addToHead(node);
            return;
        }

        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.pre = null;
        node.next = null;
        addToHead(node);
    }

    void removeTail() {
        var pre = tail.pre;
        pre.next = null;
        tail = pre;
    }

    public static class TwoWayNode {
        int key;
        public int val;
        public TwoWayNode pre;
        public TwoWayNode next;

        public TwoWayNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        var cache = new LRUCache146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
    }
}
