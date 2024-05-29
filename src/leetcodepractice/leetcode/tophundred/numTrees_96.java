package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class numTrees_96 {

    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     *
     * @param n
     * @return
     */
    int[][] cache;

    public int numTrees(int n) {
        cache = new int[n + 1][n + 1];
        return generate(1, n);
    }

    private int generate(int start, int end) {
        if (start > end) return 1;
        if (cache[start][end] != 0) return cache[start][end];
        int count = 0;
        for (int i = start; i <= end; i++) {
            int left = generate(start, i - 1);
            int right = generate(i + 1, end);
            count += left * right;
        }

        cache[start][end] = count;
        return count;
    }

}
