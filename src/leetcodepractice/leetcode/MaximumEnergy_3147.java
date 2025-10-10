package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MaximumEnergy_3147 {

    /**
     * 在神秘的地牢中，n 个魔法师站成一排。每个魔法师都拥有一个属性，这个属性可以给你提供能量。有些魔法师可能会给你负能量，即从你身上吸取能量。
     * 你被施加了一种诅咒，当你从魔法师 i 处吸收能量后，你将被立即传送到魔法师 (i + k) 处。这一过程将重复进行，直到你到达一个不存在 (i + k) 的魔法师为止。
     * 换句话说，你将选择一个起点，然后以 k 为间隔跳跃，直到到达魔法师序列的末端，在过程中吸收所有的能量。
     * <p>
     * 给定一个数组 energy 和一个整数k，返回你能获得的 最大 能量。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入： energy = [5,2,-10,-5,1], k = 3
     * <p>
     * 输出： 3
     * <p>
     * 解释：可以从魔法师 1 开始，吸收能量 2 + 1 = 3。
     * <p>
     * 示例 2：
     * <p>
     * 输入： energy = [-2,-3,-1], k = 2
     * <p>
     * 输出： -1
     * <p>
     * 解释：可以从魔法师 2 开始，吸收能量 -1。
     *
     * @param energy
     * @param k
     * @return
     */
    int[] memory = new int[100000];
    boolean[] visit = new boolean[100000];
    int max = Integer.MIN_VALUE;

    public int maximumEnergy(int[] energy, int k) {
        for (int i = 0; i < k; i++) {
            if(visit[i]) continue;
            var cur = energy[i] + next(energy, k, i + k);
            max = Math.max(max, cur);
        }

        return max;
    }

    public int next(int[] energy, int k, int p) {
        if (p > energy.length - 1) return 0;
        if (visit[p]) return memory[p];
        int total = energy[p] + next(energy, k, p + k);
        memory[p] = total;
        visit[p] = true;
        max = Math.max(max, total);
        return total;
    }
}
