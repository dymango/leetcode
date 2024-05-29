package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author dimmy
 */
public class SumOfDistancesInTree_834 {

    /**
     * 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
     * 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
     * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
     * <p>
     * 示例 1:
     * <p>
     * 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
     * 输出: [8,12,6,10,10,10]
     * 解释:
     * 如下为给定的树的示意图：
     * 0
     * / \
     * 1   2
     * /|\
     * 3 4 5
     * <p>
     * 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
     * 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
     * 说明: 1 <= N <= 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-distances-in-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param edges
     * @return
     */
    Map<Integer, List<Integer>> graph;
    Map<Integer, Integer>[] cache;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        cache = new Map[n];
        graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                r[i] += getDistance(i, j, new HashSet<>());
            }
        }

        return r;
    }

    private int getDistance(int start, int end, Set<Integer> visited) {
        if (start > end) {
            int temp = end;
            end = start;
            start = temp;
        }

        if (cache[start] != null) {
            Integer integer = cache[start].get(end);
            if (integer != null) return integer;
        }
        int distance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                if (!visited.add(node)) continue;
                if (node == end) return distance;
                List<Integer> nodes = graph.get(node);
                nodes.forEach(queue::offer);
            }

            distance++;
        }

        if (cache[start] == null) cache[start] = new HashMap<>();
        cache[start].put(end, distance);
        return distance;
    }
}
