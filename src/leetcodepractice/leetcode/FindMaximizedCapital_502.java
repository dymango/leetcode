package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author dimmy
 */
public class FindMaximizedCapital_502 {

    /**
     * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。
     *
     * 帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
     *
     * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
     *
     * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
     *
     * 示例 1:
     *
     * 输入: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
     *
     * 输出: 4
     *
     * 解释:
     * 由于你的初始资本为 0，你尽可以从 0 号项目开始。
     * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
     * 此时你可以选择开始 1 号或 2 号项目。
     * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
     * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
     *  
     * dp[i][j] 表示 i个项目,j资本可以获取的最大资本
     *
     * 注意:
     *
     * 假设所有输入数字都是非负整数。
     * 表示利润和资本的数组的长度不超过 50000。
     * 答案保证在 32 位有符号整数范围内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ipo
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param k
     * @param W
     * @param Profits
     * @param Capital
     * @return
     */
    static boolean[] marked;
    static int max = Integer.MIN_VALUE;
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < Profits.length; i++) {
            nodes.add(new Node(Profits[i], Capital[i]));
        }

        Collections.sort(nodes, (o1, o2) -> o2.profit - o1.profit);
        marked = new boolean[Profits.length];
        dfs(k, W, nodes);
        return max;
    }

    public static void dfs(int k, int currentCi, List<Node> nodes) {
        if(k == 0) {
            max = currentCi;
            return;
        }
        int maxValue = Integer.MIN_VALUE;
        int optimalSelectIndex = Integer.MIN_VALUE;
        boolean find = false;
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if(node.capital <= currentCi) {
                 find = true;
                 optimalSelectIndex = i;
                 maxValue = node.profit;
                 break;
            }
        }

        if(!find) {
            max = currentCi;
            return;
        }

        nodes.remove(optimalSelectIndex);
        dfs(k - 1, currentCi + maxValue, nodes);
    }

    public static class Node {
        int profit;
        int capital;

        public Node(int profit,
                int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public static void main(String[] args) {
        findMaximizedCapital(1,0,new int[]{1,2,3}, new int[]{1,1,2});
    }

    public int findMaximizedCapital2(int k, int W, int[] Profits, int[] Capital) {
        // to speed up: if all projects are available
        boolean speedUp = true;
        for (int c: Capital) if (W < c) speedUp = false;
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p: Profits) {
                heap.add(p);
                if (heap.size() > k) heap.poll();
            }
            for (int h: heap) W += h;
            return W;
        }

        int n = Profits.length;
        // sort the projects
        // the most available (= the smallest capital) is the head of the heap
        PriorityQueue<int[]> projects = new PriorityQueue<>((x, y) -> (x[0] - y[0]));
        for(int i = 0; i < n; i++) {
            projects.add(new int[] {Capital[i], Profits[i]});
        }

        // max heap
        PriorityQueue<Integer> available = new PriorityQueue<>((x, y) -> (y - x));
        while (k > 0) {
            // update available projects
            while (!projects.isEmpty() && projects.peek()[0] <= W)
                available.add(projects.poll()[1]);

            // if there are available projects,
            // pick the most profitable one
            if (!available.isEmpty()) W += available.poll();
                // not enough capital to start any project
            else break;
            --k;
        }
        return W;
    }
}
