package app.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author dimmy
 */
public class MincostToHireWorkers_857 {

    /**
     * 有 N 名工人。 第 i 名工人的工作质量为 quality[i] ，其最低期望工资为 wage[i] 。
     * <p>
     * 现在我们想雇佣 K 名工人组成一个工资组。在雇佣 一组 K 名工人时，我们必须按照下述规则向他们支付工资：
     * <p>
     * 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
     * 工资组中的每名工人至少应当得到他们的最低期望工资。
     * 返回组成一个满足上述条件的工资组至少需要多少钱。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入： quality = [10,20,5], wage = [70,50,30], K = 2
     * 输出： 105.00000
     * 解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
     * 示例 2：
     * <p>
     * 输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
     * 输出： 30.66667
     * 解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= K <= N <= 10000，其中 N = quality.length = wage.length
     * 1 <= quality[i] <= 10000
     * 1 <= wage[i] <= 10000
     * 与正确答案误差在 10^-5 之内的答案将被视为正确的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-cost-to-hire-k-workers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param quality
     * @param wage
     * @param k
     * @return
     *
     * 方法二：堆（优先队列）
     * 在方法一中，我们枚举了一名工人，并对剩下的工人计算对应的工资，并选出 K - 1 个工资最低的进行累加。事实上，我们可以定义一个“价值”，表示工人最低期望工资与工作质量之比。例如某位工人的最低期望工资为 100，工作质量为 20，那么他的价值为 100 / 20 = 5.0。
     *
     * 可以发现，如果一名工人的价值为 R，当他恰好拿到最低期望工资时，如果所有价值高于 R 的工人都无法拿到最低期望工资，而所有价值低于 R 的工人都拿得比最低期望工资多。因此，我们可以按照这些工人的价值，对他们进行升序排序。排序后的第 i 名工人可以在它之前任选 K - 1 名工人，并计算对应的工资总和，为 R * sum(quality[c1] + quality[c2] + ... + quality[c{k-1}] + quality[i])，也就是说，我们需要在前 i 名工人中选择 K 个工作质量最低的。我们可以使用一个大根堆来实时维护 K 个最小值。
     *
     * JavaPython
     *
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/minimum-cost-to-hire-k-workers/solution/gu-yong-k-ming-gong-ren-de-zui-di-cheng-ben-by-lee/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        MincostToHireWorkers_857 mincostToHireWorkers_857 = new MincostToHireWorkers_857();
        System.out.println(mincostToHireWorkers_857.mincostToHireWorkersV2(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
        System.out.println(mincostToHireWorkers_857.mincostToHireWorkersV2(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
        System.out.println(mincostToHireWorkers_857.mincostToHireWorkersV2(new int[]{2, 1, 5}, new int[]{17, 6, 4}, 2));
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < quality.length; i++) {
            double cost = wage[i];
            int qty = quality[i];
            Map<Double, Integer> counter = new HashMap<>();
            TreeSet<Double> treeSet = new TreeSet<>();
            for (int j = 0; j < quality.length; j++) {
                if (i == j) continue;
                double base = (double) quality[j] / (double) qty;
                double c = cost * base;
                if (c < wage[j]) {
                    continue;
                }
                treeSet.add(c);
                counter.merge(c, 1, Integer::sum);
            }


            Integer count = 0;
            for (Double aDouble : treeSet) {
                count += counter.get(aDouble);
            }

            if (count < k - 1) continue;
            int need = k - 1;
            while (need > 0) {
                Double aDouble = treeSet.pollFirst();
                Integer integer = counter.get(aDouble);
                if (integer < need) {
                    cost += aDouble * integer;
                    need -= integer;
                } else {
                    cost += aDouble * need;
                    need = 0;
                }
            }

            min = Math.min(min, cost);
        }

        return min;
    }

    public double mincostToHireWorkersV2(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; ++i)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers);

        double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue();
        for (Worker worker: workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;
            if (pool.size() > K)
                sumq += pool.poll();
            if (pool.size() == K)
                ans = Math.min(ans, sumq * worker.ratio());
        }

        return ans;
    }
    class Worker implements Comparable<Worker> {
        public int quality, wage;
        public Worker(int q, int w) {
            quality = q;
            wage = w;
        }

        public double ratio() {
            return (double) wage / quality;
        }

        public int compareTo(Worker other) {
            return Double.compare(ratio(), other.ratio());
        }
    }
}
