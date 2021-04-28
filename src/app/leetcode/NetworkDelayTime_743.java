package app.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author dimmy
 */
public class NetworkDelayTime_743 {

    /**
     * 有 n 个网络节点，标记为 1 到 n。
     * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
     * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：times = [[1,2,1]], n = 2, k = 1
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：times = [[1,2,1]], n = 2, k = 2
     * 输出：-1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= k <= n <= 100
     * 1 <= times.length <= 6000
     * times[i].length == 3
     * 1 <= ui, vi <= n
     * ui != vi
     * 0 <= wi <= 100
     * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/network-delay-time
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param times
     * @param n
     * @param k
     * @return
     */

    public static int networkDelayTime(int[][] times, int n, int k) {
        boolean[] visited = new boolean[100];
        int[][] values = new int[100][100];
        int[] nodeMinValues = new int[100];
        for (int i = 0; i < 100; i++) {
            nodeMinValues[i] = Integer.MAX_VALUE;
        }
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        for (int[] time : times) {
            nodeMap.computeIfAbsent(time[0], integer -> new ArrayList<>());
            nodeMap.get(time[0]).add(time[1]);
            values[time[0]][time[1]] = time[2];
        }

        int count = 1;
        visited[k] = true;
        int result = Integer.MIN_VALUE;
        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.push(k);
        while (count != n) {
            if (nodeStack.isEmpty()) return -1;
            int currentNode = nodeStack.peek();
            List<Integer> toNodes = nodeMap.get(currentNode);
            if (toNodes == null) {
                nodeStack.pop();
                continue;
            }

            int min = Integer.MAX_VALUE;
            int node = 0;
            boolean calc = false;
            for (Integer toNode : toNodes) {
                if (visited[toNode]) continue;
                calc = true;
                int toNodeValue = values[currentNode][toNode] + nodeMinValues[currentNode];
                toNodeValue = Math.min(toNodeValue, nodeMinValues[toNode]);
                nodeMinValues[toNode] = toNodeValue;
                if (toNodeValue < min) {
                    min = toNodeValue;
                    node = toNode;
                }
            }

            if (calc) {
                nodeMinValues[node] = min;
                visited[node] = true;
                nodeStack.push(node);
                count++;
                result = Math.max(result, min);
            } else {
                nodeStack.pop();
            }
        }

        return result;
    }


    public static void main(String[] args) {
//        System.out.println(networkDelayTime(new int[][]{{2,1,1}, {2,3,1}, {3,4,1}}, 4, 2));
//        System.out.println(networkDelayTime(new int[][]{{1,2,1}}, 2, 2));
//        System.out.println(networkDelayTime(new int[][]{{1,2,1}, {2,1,3}}, 2, 2));
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 2));
    }
}
