package leetcodepractice.twohundred;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class numTrees96 {

    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     *
     * @param n
     * @return
     */
    int[][] cache = new int[20][20];
    public int numTrees(int n) {
        return (int) count(1, n);
    }

    int count(int start, int end) {
        if (start > end) return 1;
        if(cache[start][end] != 0) return cache[start][end];
        int count = 0;
        for (int i = start; i <= end; i++) {
            int left = count(start, i - 1);
            int right = count(i + 1, end);
            count += (left * right);
        }

        cache[start][end] = count;
        return count;
    }
}
