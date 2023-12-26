package app.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class removeStones_947 {

    /**
     * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
     * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
     * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
     * 输出：5
     * 解释：一种移除 5 块石头的方法如下所示：
     * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
     * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
     * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
     * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
     * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
     * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
     * 示例 2：
     * <p>
     * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
     * 输出：3
     * 解释：一种移除 3 块石头的方法如下所示：
     * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
     * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
     * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
     * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
     * 示例 3：
     * <p>
     * 输入：stones = [[0,0]]
     * 输出：0
     * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
     *
     * @param stones
     * @return
     */
    Set<Integer> visited = new HashSet<>();
    int count = 0;

    public int removeStones(int[][] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int length = stones.length;
        for (int i = 0; i < length; i++) {
            map.put(i, new HashSet<>());
            for (int j = 0; j < length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    map.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (visited.contains(i)) continue;
            visited.add(i);
            count++;
            dfs(i, map);
        }

        return length - count;
    }

    private void dfs(int n, Map<Integer, Set<Integer>> map) {
        Set<Integer> values = map.get(n);
        if (values == null) return;
        for (Integer value : values) {
            if (visited.contains(value)) continue;
            visited.add(n);
            dfs(value, map);
        }
    }

    public static void main(String[] args) {
        new removeStones_947().removeStones(new int[][]{{5, 9}, {9, 0}, {0, 0}, {7, 0}, {4, 3}, {8, 5}, {5, 8}, {1, 1}, {0, 6}, {7, 5}, {1, 6}, {1, 9}, {9, 4}, {2, 8}, {1, 3}, {4, 2}, {2, 5}, {4, 1}, {0, 2}, {6, 5}});
    }

    public int removeStonesV2(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> edge = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edge.add(new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    edge.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                num++;
                dfs(i, edge, vis);
            }
        }
        return n - num;
    }

    public void dfs(int x, List<List<Integer>> edge, boolean[] vis) {
        vis[x] = true;
        for (int y : edge.get(x)) {
            if (!vis[y]) {
                dfs(y, edge, vis);
            }
        }
    }
}
