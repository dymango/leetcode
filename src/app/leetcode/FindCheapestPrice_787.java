package app.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author dimmy
 */
public class FindCheapestPrice_787 {

    /**
     * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
     * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
     * <p>
     * 示例 1：
     * <p>
     * 输入:
     * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
     * src = 0, dst = 2, k = 1
     * 输出: 200
     * 解释:
     * 城市航班图如下
     * <p>
     * <p>
     * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
     * 示例 2：
     * <p>
     * 输入:
     * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
     * src = 0, dst = 2, k = 0
     * 输出: 500
     * 解释:
     * 城市航班图如下
     * <p>
     * <p>
     * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
     *  
     * <p>
     * 提示：
     * <p>
     * n 范围是 [1, 100]，城市标签从 0 到 n - 1
     * 航班数量范围是 [0, n * (n - 1) / 2]
     * 每个航班的格式 (src, dst, price)
     * 每个航班的价格范围是 [1, 10000]
     * k 范围是 [0, n - 1]
     * 航班没有重复，且不存在自环
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[][] value = new int[100][100];
    int SRC;
    int DST;
    int K;
    int min = Integer.MAX_VALUE;
    boolean find = false;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        SRC = src;
        DST = dst;
        K = k;
        for (int i = 0; i < flights.length; i++) {
            int[] flight = flights[i];
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(flight[1]);
            value[flight[0]][flight[1]] = flight[2];
        }

        dfs(src, new HashSet<>(), 0);
        return find ? min : -1;
    }

    private void dfs(int city, Set<Integer> visited, int cost) {
        if(city == DST) {
            min = Math.min(min, cost);
            find = true;
            return;
        }

        if(cost > min || visited.size() > K) {
            return;
        }

        List<Integer> toCities = graph.get(city);
        if(toCities == null) return;
        for (Integer toCity : toCities) {
            if(visited.add(toCity)) {
                dfs(toCity, visited, cost + value[city][toCity]);
                visited.remove(toCity);
            }
        }
    }

    public int findCheapestPriceV2(int n, int[][] flights, int src, int dst, int K) {
        // 使用邻接矩阵表示有向图，0 表示不连通
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 向集合添加一个记录（起点, 费用, 站数限制）的数组，K + 1 表示可以走过站点的个数
        minHeap.offer(new int[]{src, 0, K + 1});

        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int v = front[0];
            int price = front[1];
            int k = front[2];

            if (v == dst) {
                return price;
            }

            // 如果还可以中转一个站
            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    // 并且存在一条有向边
                    if (graph[v][i] > 0 ) {
                        // 优先队列中存入：有向边指向的顶点 i、从起点 src 到 i 的总路径长度、还有多少站可以中转
                        minHeap.offer(new int[]{i, price + graph[v][i]  , k - 1});
                    }
                }
            }
        }
        return -1;
    }
}
