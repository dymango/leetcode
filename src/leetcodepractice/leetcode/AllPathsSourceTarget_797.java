package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class AllPathsSourceTarget_797 {

    /**
     * 输入：graph = [[1,2],[3],[3],[]]
     * 输出：[[0,1,3],[0,2,3]]
     * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
     *
     * @param graph
     * @return
     */
    private int[][] GRAPH;
    private boolean[] visited;
    private int target;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        GRAPH = graph;
        visited = new boolean[graph.length];
        target = graph.length - 1;
        dfs(0, new ArrayList<>());
        return result;
    }

    public void dfs(int node, List<Integer> paths) {
        if (node == target) {
            ArrayList<Integer> list = new ArrayList<>(paths);
            list.add(node);
            result.add(list);
            return;
        }

        if (visited[node]) return;
        visited[node] = true;
        int[] nextNodes = GRAPH[node];
        for (int nextNode : nextNodes) {
            paths.add(node);
            dfs(nextNode, paths);
            paths.remove(paths.size() - 1);
        }

        visited[node] = false;
    }
}
