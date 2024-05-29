package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class prisonAfterNDays_957 {

    /**
     * 监狱中 8 间牢房排成一排，每间牢房可能被占用或空置。
     * <p>
     * 每天，无论牢房是被占用或空置，都会根据以下规则进行变更：
     * <p>
     * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
     * 否则，它就会被空置。
     * 注意：由于监狱中的牢房排成一行，所以行中的第一个和最后一个牢房不存在两个相邻的房间。
     * <p>
     * 给你一个整数数组 cells ，用于表示牢房的初始状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0 。另给你一个整数 n 。
     * <p>
     * 请你返回 n 天后监狱的状况（即，按上文描述进行 n 次变更）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：cells = [0,1,0,1,1,0,0,1], n = 7
     * 输出：[0,0,1,1,0,0,0,0]
     * 解释：下表总结了监狱每天的状况：
     * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
     * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
     * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
     * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
     * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
     * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
     * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
     * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
     * 示例 2：
     * <p>
     * 输入：cells = [1,0,0,1,0,0,1,0], n = 1000000000
     * 输出：[0,0,1,1,1,1,1,0]
     * <p>
     * <p>
     * 模拟每一天监狱的状态。
     * <p>
     * 由于监狱最多只有 256 种可能的状态，所以状态一定会快速的形成一个循环。我们可以当状态循环出现的时候记录下循环的周期 t 然后跳过 t 的倍数的天数。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode.cn/problems/prison-cells-after-n-days/solutions/18185/n-tian-hou-de-lao-fang-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param cells
     * @param n
     * @return
     */
    public static void main(String[] args) {
        //[1,1,0,0,0,0,1,1]
        //[0,0,1,1,0,0,1,1]
        System.out.println(new prisonAfterNDays_957().prisonAfterNDays(new int[]{0, 0, 1, 1, 0, 0, 1, 1}, 4));
        System.out.println(new prisonAfterNDays_957().prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000));
        System.out.println(new prisonAfterNDays_957().prisonAfterNDays(new int[]{1, 1, 0, 0, 0, 0, 1, 1}, 7));
//        System.out.println(new prisonAfterNDays_957().prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7));
    }

    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] d = new int[8];
        int day = 0;
        while (true) {
            int[] days = new int[8];
            System.arraycopy(cells, 0, days, 0, 8);
            for (int j = 0; j < 8; j++) {
                if (j == 0 || j == 7) {
                    days[j] = 0;
                    continue;
                }

                if (cells[j - 1] == 0 && cells[j + 1] == 0
                    || cells[j - 1] == 1 && cells[j + 1] == 1) {
                    days[j] = 1;
                } else {
                    days[j] = 0;
                }
            }

            if (day != 0 && isSame(days, d)) {
                break;
            }

            if (day == 0) d = days;
            map.put(day, days);
            cells = days;
            System.out.println(day);
            day++;
        }

        return map.get((n - 1) % day);
    }

    private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < 8; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }
}
