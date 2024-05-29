package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class PossibleBipartition_886 {

    /**
     * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
     * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
     *  
     * <p>
     * 示例 1：
     * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
     * 输出：true
     * 解释：group1 [1,4], group2 [2,3]
     * <p>
     * 示例 2：
     * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
     * 输出：false
     *  
     * <p>
     * 提示：
     * 1 <= n <= 2000
     * 0 <= dislikes.length <= 104
     * dislikes[i].length == 2
     * 1 <= dislikes[i][j] <= n
     * ai < bi
     * dislikes 中每一组都 不同
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/possible-bipartition
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param dislikes
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new PossibleBipartition_886().possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println(new PossibleBipartition_886().possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }

    ArrayList<Integer>[] graph;
    Map<Integer, Integer> map;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new ArrayList[n + 1];
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < dislikes.length; i++) {
            graph[dislikes[i][0]].add(dislikes[i][1]);
            graph[dislikes[i][1]].add(dislikes[i][0]);
        }

        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i) && !dfs(i, 0)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int color) {
        if (!map.containsKey(node)) {
            map.put(node, color);
        } else {
            return map.get(node) == color;
        }

        ArrayList<Integer> list = graph[node];
        for (Integer integer : list) {
            if (!dfs(integer, color ^ 1)) return false;
        }

        return true;
    }
}
