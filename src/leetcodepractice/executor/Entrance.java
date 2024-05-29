package leetcodepractice.executor;

import leetcodepractice.leetcode.ShipWithinDays_1011;


/**
 * @author dimmy
 */
public class Entrance {
    static Class<?> target = ShipWithinDays_1011.class;

    public static void main(String[] args) {
        MainMethodExecutor mainMethodExecutor = new MainMethodExecutor();
        mainMethodExecutor.execute(target);
    }
}
