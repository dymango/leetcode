package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author dimmy
 */
public class EventualSafeNodes_802 {

    /**
     * 在有向图中，从某个节点和每个转向处开始出发，沿着图的有向边走。如果到达的节点是终点（即它没有连出的有向边），则停止。
     * <p>
     * 如果从起始节点出发，最后必然能走到终点，就认为起始节点是 最终安全 的。更具体地说，对于最终安全的起始节点而言，存在一个自然数 k ，无论选择沿哪条有向边行走 ，走了不到 k 步后必能停止在一个终点上。
     * <p>
     * 返回一个由图中所有最终安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
     * <p>
     * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
     * 输出：[2,4,5,6]
     * 解释：示意图如上。
     * 示例 2：
     * <p>
     * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
     * 输出：[4]
     *  
     * <p>
     * 提示：
     * <p>
     * n == graph.length
     * 1 <= n <= 104
     * 0 <= graph[i].legnth <= n
     * graph[i] 按严格递增顺序排列。
     * 图中可能包含自环。
     * 图中边的数目在范围 [1, 4 * 104] 内。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outDegree = new int[graph.length];
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                nodeMap.putIfAbsent(graph[i][j], new ArrayList<>());
                nodeMap.get(graph[i][j]).add(i);
                outDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                List<Integer> list = nodeMap.getOrDefault(node, new ArrayList<>());
                list.forEach(start -> {
                    outDegree[start]--;
                    if (outDegree[start] == 0) queue.offer(start);
                });
            }
        }

        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] <= 0) result.add(i);
        }

        return result;
    }
}
