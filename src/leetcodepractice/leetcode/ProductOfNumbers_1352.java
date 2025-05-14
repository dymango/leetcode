package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class ProductOfNumbers_1352 {

    /**
     * 设计一个算法，该算法接受一个整数流并检索该流中最后 k 个整数的乘积。
     * <p>
     * 实现 ProductOfNumbers 类：
     * <p>
     * ProductOfNumbers() 用一个空的流初始化对象。
     * void add(int num) 将数字 num 添加到当前数字列表的最后面。
     * int getProduct(int k) 返回当前数字列表中，最后 k 个数字的乘积。你可以假设当前列表中始终 至少 包含 k 个数字。
     * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32 位整数范围内，不会溢出。
     */
    List<Integer> l = new ArrayList<>();

    public ProductOfNumbers_1352() {

    }

    public void add(int num) {
        if (num == 0) {
            l.clear();
            return;
        }

        if (l.isEmpty()) {
            l.add(num);
            return;
        }

        l.add(l.getLast() * num);
    }

    public int getProduct(int k) {
        if (k == l.size()) return l.getLast();
        if (k > l.size()) return 0;
        return l.getLast() / l.get(l.size() - k - 1);
    }
}
