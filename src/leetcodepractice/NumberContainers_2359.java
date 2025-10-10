package leetcodepractice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author dimmy
 */
public class NumberContainers_2359 {

    /**
     * 设计一个数字容器系统，可以实现以下功能：
     * <p>
     * 在系统中给定下标处 插入 或者 替换 一个数字。
     * 返回 系统中给定数字的最小下标。
     * 请你实现一个 NumberContainers 类：
     * <p>
     * NumberContainers() 初始化数字容器系统。
     * void change(int index, int number) 在下标 index 处填入 number 。如果该下标 index 处已经有数字了，那么用 number 替换该数字。
     * int find(int number) 返回给定数字 number 在系统中的最小下标。如果系统中没有 number ，那么返回 -1 。
     */
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, PriorityQueue<Integer>> numMap = new HashMap<>();

    public NumberContainers_2359() {

    }

    public void change(int index, int number) {
        var pre = map.get(index);
        if (pre != null && pre == number) return;
        if (pre != null) {
            var integers = numMap.get(pre);
            integers.remove(index);
        }


        map.put(index, number);
        numMap.putIfAbsent(number, new PriorityQueue<>());
        var l = numMap.get(number);
        l.add(index);
    }

    public int find(int number) {
        var integers = numMap.get(number);
        if (integers == null || integers.isEmpty()) return -1;
        return integers.peek();
    }
}
