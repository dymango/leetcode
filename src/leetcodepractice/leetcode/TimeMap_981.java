package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class TimeMap_981 {

    /**
     * 设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
     * <p>
     * 实现 TimeMap 类：
     * <p>
     * TimeMap() 初始化数据结构对象
     * void set(String key, String value, int timestamp) 存储给定时间戳 timestamp 时的键 key 和值 value。
     * String get(String key, int timestamp) 返回一个值，该值在之前调用了 set，其中 timestamp_prev <= timestamp 。如果有多个这样的值，它将返回与最大  timestamp_prev 关联的值。如果没有值，则返回空字符串（""）。
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * ["TimeMap", "set", "get", "get", "set", "get", "get"]
     * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
     * 输出：
     * [null, null, "bar", "bar", null, "bar2", "bar2"]
     * <p>
     * 解释：
     * TimeMap timeMap = new TimeMap();
     * timeMap.set("foo", "bar", 1);  // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1
     * timeMap.get("foo", 1);         // 返回 "bar"
     * timeMap.get("foo", 3);         // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"） 。
     * timeMap.set("foo", "bar2", 4); // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4
     * timeMap.get("foo", 4);         // 返回 "bar2"
     * timeMap.get("foo", 5);         // 返回 "bar2"
     */
    Map<String, List<Node>> map = new HashMap<>();
    Map<String, String> cache = new HashMap<>();

    public TimeMap_981() {

    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Node(value, timestamp));
        map.get(key).sort(Comparator.comparingInt(value1 -> value1.timestamp));
        cache.put(key + timestamp, value);
    }

    public String get(String key, int timestamp) {
        String key1 = key + timestamp;
        if (cache.containsKey(key)) return cache.get(key1);
        List<Node> nodes = map.get(key);
        int start = 0;
        int end = nodes.size() - 1;
        String r = "";
        while (start <= end) {
            int mid = start + (end - start) / 2;
            Node node = nodes.get(mid);
            if (node.timestamp > timestamp) {
                end = mid - 1;
            } else if (node.timestamp < timestamp) {
                r = node.value;
                start = mid + 1;
            } else {
                return node.value;
            }
        }


        cache.put(key1, r);
        return r;
    }

    private class Node {
        public String value;
        public int timestamp;

        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

}
