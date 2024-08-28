package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class canCompleteCircuit134 {

    /**
     * 134. 加油站
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * <p>
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * <p>
     * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     *
     * @param gas
     * @param cost
     * @return
     */
    public static void main(String[] args) {
        //[1,2,3,4,5]
        //cost =
        //[3,4,5,1,2]

        //[5,8,2,8]
        //cost =
        //[6,5,6,6]
        System.out.println(new canCompleteCircuit134().canCompleteCircuitV2(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] dif = new int[gas.length];
        for (int i = 0; i < dif.length; i++) {
            dif[i] = gas[i] - cost[i];
        }

        int start = 0;
        while (true) {
            int next = start;
            int step = 0;
            int curGas = 0;
            while (curGas + dif[next] >= 0) {
                curGas += dif[next];
                next = (next + 1) % gas.length;
                step++;
                if (step == gas.length) return start;

            }

            int n = (next + 1) % gas.length;
            if (n <= start) break;
            start = n;
        }
        return -1;
    }

    public int canCompleteCircuitV2(int[] gas, int[] cost) {
        int length = gas.length;
        int nextStation = 0;
        while (true) {
            int position = nextStation;
            int curGas = 0;
            int step = 0;
            while (curGas + gas[position] >= cost[position]) {
                curGas += (gas[position] - cost[position]);
                step++;
                if (step == length) return nextStation;
                position = (position + 1) % length;
            }

            int next = (position + 1) % length;
            if (next <= nextStation) break;
            nextStation = next;
        }

        return -1;
    }
}
